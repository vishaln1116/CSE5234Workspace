package edu.osu.cse5234.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Item;
import edu.osu.cse5234.model.LineItem;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.util.ServiceLocator;

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
public class OrderProcessingServiceBean {

	private static Random rng = new Random();
	
	@PersistenceContext protected EntityManager entityManager;

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

    public String processOrder(Order order) {
    	InventoryService is = ServiceLocator.getInventoryService();
    	String confirmationCode = "";
    	
    	List<Item> currItems = retrieveItems(order);
    	
    	if (is.validateQuantity(currItems)) {
        	confirmationCode += Math.abs(rng.nextInt());
        	is.updateInventory(currItems);
    	}
    	
    	entityManager.persist(order.getCustomerName());
    	
    	for(LineItem lineItem : order.getItems()) {
    		entityManager.persist(lineItem);
    	}
    	
    	entityManager.persist(order.getPaymentInfo());
    	entityManager.persist(order.getShippingInfo());
    	entityManager.flush();
    	
    	return confirmationCode;
    }
    
    public boolean validateItemAvailability(Order order) {
    	return ServiceLocator.getInventoryService().validateQuantity(retrieveItems(order));
    }
    
}
