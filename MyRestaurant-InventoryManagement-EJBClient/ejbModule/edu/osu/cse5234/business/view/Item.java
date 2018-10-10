package edu.osu.cse5234.business.view;
import java.io.Serializable;

public class Item implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6205737053442725966L;

	private String name;

    private String price;

    private String quantity;

    public Item() {
        this.name = "";
        this.price = "0";
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
