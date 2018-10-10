package edu.osu.cse5234.model;

public class PaymentInfo {

	private String creditCard;
	
	private String expirationDate;
	
	private String cvvCode;
	
	private String holderName;

	public PaymentInfo() {
		
	}
	
	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String newCreditCard) {
		this.creditCard = newCreditCard;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String newExpirationDate) {
		this.expirationDate = newExpirationDate;
	}

	public String getCvvCode() {
		return cvvCode;
	}

	public void setCvvCode(String newCvvCode) {
		this.cvvCode = newCvvCode;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String newHolderName) {
		this.holderName = newHolderName;
	}
	
}
