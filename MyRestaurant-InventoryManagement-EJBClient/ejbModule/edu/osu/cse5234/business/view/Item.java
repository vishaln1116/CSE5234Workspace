package edu.osu.cse5234.business.view;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ITEM")
public class Item implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6205737053442725966L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="ITEM_NUMBER")
	private int itemNumber;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="NAME")
	private String name;

	@Column(name="UNIT_PRICE")
    private String price;

	@Column(name="AVAILABLE_QUANTITY")
    private String quantity;

    public Item() {
    	this.id = -1;
    	this.itemNumber = -1;
    	this.description = "";
        this.name = "";
        this.price = "0";
        this.quantity = "0";
    }
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String newPrice) {
        this.price = newPrice;
    }

    public String getQuantity() {
        return this.quantity;
    }

    public void setQuantity(String newQuantity) {
        this.quantity = newQuantity;
    }

}
