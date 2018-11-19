package edu.osu.cse5234.batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class InventoryUpdater {

	public static void main(String[] args) {
		System.out.println("Starting Inventory Update ..."); 
		try {
			Connection conn = createConnection();
			Collection<Integer> newOrderIds = getNewOrders(conn);
			Map<Integer, Integer> orderedItems = getOrderedLineItems(newOrderIds, conn); 
			udpateInventory(orderedItems, conn);
			udpateOrderStatus(newOrderIds, conn);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	private static Connection createConnection() throws SQLException, ClassNotFoundException { Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:/Users/VishalReddy/Documents/workspace/CSE5234/h2db/MyRestaurantDB;AUTO_SERVER=TRUE", "sa", "");
		return conn;
	}
	
	private static Collection<Integer> getNewOrders(Connection conn) throws SQLException {
		Collection<Integer> orderIds = new ArrayList<Integer>(); 
		ResultSet rset = conn.createStatement().executeQuery("select ID from CUSTOMER_ORDER where STATUS = 'New'"); 
		
		while (rset.next()) {
			orderIds.add(new Integer(rset.getInt("ID"))); 
		}
		
		return orderIds;
	}
	
	private static Map<Integer, Integer> getOrderedLineItems(Collection<Integer> newOrderIds, Connection conn) throws SQLException {
		Map<Integer, Integer> ordered = new HashMap<>();
		
		for(int i = 1; i <= 5; i++) {
			ordered.put(i, 0);
		}
		
		for(Integer orderId : newOrderIds) {
			ResultSet rset = conn.createStatement().executeQuery("select ITEM_NUMBER, QUANTITY from CUSTOMER_ORDER_LINE_ITEM where CUSTOMER_ORDER_ID_FK = " + orderId);
			while(rset.next()) {
				Integer itemNum = rset.getInt("ITEM_NUMBER");
				Integer quantity = rset.getInt("QUANTITY");
				ordered.put(itemNum, ordered.get(itemNum) + quantity);
			}
		}
		
		return ordered;
	}
				
				
    private static void udpateInventory(Map<Integer, Integer> orderedItems, Connection conn) throws SQLException {
    	for(Integer itemNum : orderedItems.keySet()) {
    		ResultSet rset = conn.createStatement().executeQuery("select AVAILABLE_QUANTITY from ITEM where ID = " + itemNum);
    		int currentQuantity = rset.getInt("AVAILABLE_QUANTITY");
    		int updatedQuantity = currentQuantity - orderedItems.get(itemNum);
    		conn.createStatement().executeQuery("update ITEM set AVAILABLE_QUANTITY = " + updatedQuantity + " where ITEM_NUMBER = " + itemNum);
    	}
    }
    
	private static void udpateOrderStatus(Collection<Integer> newOrderIds, Connection conn) throws SQLException {
		for(Integer orderId : newOrderIds) {
			conn.createStatement().executeQuery("update CUSTOMER_ORDER set STATUS = 'Processed' where ID = " + orderId);
		}
	}
}
