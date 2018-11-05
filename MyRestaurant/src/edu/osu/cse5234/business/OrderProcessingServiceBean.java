package edu.osu.cse5234.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.ws.WebServiceRef;

import com.chase.payment.CreditCardPayment;
import com.chase.payment.PaymentProcessorService;
import com.ups.shipping.client.ShippingInitiationClient;

import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Item;
import edu.osu.cse5234.model.LineItem;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.model.PaymentInfo;
import edu.osu.cse5234.util.ServiceLocator;

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
public class OrderProcessingServiceBean {
	
	private static String shippingResourceURI = "http://localhost:9080/UPS/jaxrs";

	private static Random rng = new Random();
	
	@PersistenceContext protected EntityManager entityManager;
	
	@WebServiceRef(wsdlLocation =
			   "http://localhost:9080/ChaseBankApplication/PaymentProcessorService?wsdl")
	private PaymentProcessorService service;

    public OrderProcessingServiceBean() {
    }
    
    public static List<Item> retrieveItems(Order order){
    	List<LineItem> currLineItems = order.getItems();
    	List<Item> currItems = new ArrayList<>();
    	
    	for(LineItem currLineItem : currLineItems) {
    		Item currItem = new Item(currLineItem.getItemId(), currLineItem.getItemName(), currLineItem.getQuantity());
    		currItems.add(currItem);
    	}
    	
    	return currItems;
    }
    
    public static double calculateTotalPrice(Order order) {
    	double totalPrice = 0;
    	List<Item> items = ServiceLocator.getInventoryService().getAvailableInventory().getItems();
    	List<LineItem> lineItems = order.getItems();
    	
    	for(LineItem lI : lineItems) {
    		for(Item i : items) {
    			if(lI.getItemName().equals(i.getName())) {
    				totalPrice += lI.getQuantity() * i.getPrice();
    				break;
    			}
    		}
    	}
    	
    	return totalPrice;
    }

    public String processOrder(Order order) {
    	InventoryService is = ServiceLocator.getInventoryService();
    	String confirmationCode = "";
    	
    	List<Item> currItems = retrieveItems(order);
    	
    	if (is.validateQuantity(currItems)) {
        	//confirmationCode += Math.abs(rng.nextInt());
        	is.updateInventory(currItems);
    	}
    	
    	PaymentInfo payInfo = order.getPaymentInfo();
    	CreditCardPayment creditCardPayment = new CreditCardPayment();
    	creditCardPayment.setCcHolderName(payInfo.getHolderName());
    	creditCardPayment.setCcNumber(payInfo.getCreditCard());
    	creditCardPayment.setExpirationDate(payInfo.getExpirationDate());
    	creditCardPayment.setCvvCode(payInfo.getCvvCode());
    	creditCardPayment.setPaymentAmount(calculateTotalPrice(order));

    	confirmationCode += Integer.parseInt(service.getPaymentProcessorPort().processPayment(creditCardPayment));
    	
    	if(Integer.parseInt(confirmationCode) < 0) {
    		//ABANDON PAYMENT
    	}
    	
    	System.out.println("Total Price: " + calculateTotalPrice(order));
    	
    	order.getPaymentInfo().setConfirmationNumber(confirmationCode);
    	
    	entityManager.persist(order);
    	entityManager.flush();  
    	
    	//Count number of items to ship
    	int shipCount = 0;
    	for(LineItem item : order.getItems()) {
    		if(item.getQuantity() > 0) {
    			shipCount++;
    		}
    	}
    	
    	String organization = "BestBakery"; 
    	int orderRefId = order.getId();
		String zip = order.getShippingInfo().getZip();
		
		JsonObject requestJson = Json.createObjectBuilder()
		               .add("Organization", organization)
		               .add("OrderRefId", orderRefId)
		               .add("ItemsNumber", shipCount)
		               .add("Zip", zip)
		               .build();
		
    	ShippingInitiationClient client = new ShippingInitiationClient(shippingResourceURI);
    	JsonObject responseJson = client.invokeInitiateShipping(requestJson);
    	
    	System.out.println("UPS accepted request? " + responseJson.getBoolean("Accepted")); 
    	System.out.println("Shipping Reference Number: " + responseJson.getInt("ShippingReferenceNumber"));
    	
    	return confirmationCode;
    }
    
    public boolean validateItemAvailability(Order order) {
    	return ServiceLocator.getInventoryService().validateQuantity(retrieveItems(order));
    }
    
}
