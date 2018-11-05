package edu.osu.cse5234.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PAYMENT_INFO")
public class PaymentInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;

	@Column(name="HOLDER_NAME")
	private String holderName;
	
	@Column(name="CARD_NUM")
	private String creditCard;
	
	@Column(name="EXP_DATE")
	private String expirationDate;
	
	@Column(name="CVV")
	private String cvvCode;
	
	@Column(name="CONFIRMATION_NUMBER")
	private String confirmationNumber;

	
	public PaymentInfo() {
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public String getConfirmationNumber() {
		return confirmationNumber;
	}

	public void setConfirmationNumber(String confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
	}
	
}
