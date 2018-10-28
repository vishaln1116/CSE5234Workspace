package edu.osu.cse5234.business.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Inventory implements Serializable {
	
	private static final long serialVersionUID = 1494692844220693060L;
	private List<Item> items;
	
	public Inventory() {
		this.items = new ArrayList<>();
	}
	
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Item itemByName(String name) {
		Item result = null;
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getName().equals(name)) {
				result = items.get(i);
				break;
			}
		}
		return result;
	}
}
