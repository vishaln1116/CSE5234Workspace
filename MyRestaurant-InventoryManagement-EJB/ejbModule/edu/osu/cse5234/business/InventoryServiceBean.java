package edu.osu.cse5234.business;

import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Item;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class InventoryServiceBean
 */
@Stateless
@Remote(InventoryService.class)
public class InventoryServiceBean implements InventoryService {

	Inventory currentInventory;
	
	@PersistenceContext
	EntityManager entityManager;
	
	public static final String MY_QUERY = "Select i from Item i"; 

	/**
     * Default constructor. 
     */
    public InventoryServiceBean() {
    	currentInventory = new Inventory();
//        Item[] items = new Item[5];
//
//        items[0] = new Item();
//        items[0].setName("Pumpkin pie");
//        items[0].setPrice("5.00");
//
//        items[1] = new Item();
//        items[1].setName("Apple pie");
//        items[1].setPrice("4.00");
//
//        items[2] = new Item();
//        items[2].setName("Double chocolate chunk cake");
//        items[2].setPrice("7.00");
//
//        items[3] = new Item();
//        items[3].setName("Deluxe granola bar");
//        items[3].setPrice("10.00");
//
//        items[4] = new Item();
//        items[4].setName("Hardtack");
//        items[4].setPrice("0.20");
//
//        Inventory inv = new Inventory();
//        
//        ArrayList<Item> lst = new ArrayList<>();
//
//        for (Item i : items) {
//        	i.setQuantity("5");
//            lst.add(i);
//        }
//        
//        inv.setItems(lst);
//        
//		currentInventory = inv;
    }

	@Override
	public Inventory getAvailableInventory() {
		List<Item> items = entityManager.createQuery(MY_QUERY, Item.class).getResultList();
		currentInventory.setItems(items);
		return currentInventory;
	}

	@Override
	public boolean validateQuantity(List<Item> items) {
		boolean valid = true;
		for (int i = 0; i < items.size() && valid; i++) {
			valid = Integer.parseInt(currentInventory.itemByName(items.get(i).getName()).getQuantity()) 
					>= Integer.parseInt(items.get(i).getQuantity());
		}
		return valid;
	}

	@Override
	public boolean updateInventory(List<Item> items) {
		for(Item item : items) {
			int currentAmount = Integer.parseInt(currentInventory.itemByName(item.getName()).getQuantity());
			int newAmount = currentAmount - Integer.parseInt(item.getQuantity());
			currentInventory.itemByName(item.getName()).setQuantity("" + newAmount);
		}
		return true;
	}
	
    public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
