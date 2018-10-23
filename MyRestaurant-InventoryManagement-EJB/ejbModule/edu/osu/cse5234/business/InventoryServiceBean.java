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
			valid = currentInventory.itemByName(items.get(i).getName()).getQuantity() 
					>= items.get(i).getQuantity();
		}
		return valid;
	}

	@Override
	public boolean updateInventory(List<Item> items) {
		for(Item item : items) {
			int currentAmount = currentInventory.itemByName(item.getName()).getQuantity();
			int newAmount = currentAmount - item.getQuantity();
			currentInventory.itemByName(item.getName()).setQuantity(newAmount);
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
