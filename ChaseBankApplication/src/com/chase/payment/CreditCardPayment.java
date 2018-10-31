package com.chase.payment;

import java.io.Serializable;

public class CreditCardPayment implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 688739544022805419L;
	
	private String ccHolderName;
	
	private String ccNumber;
	
	private String expirationDate;
	
	private String cvvCode;
	
	private Double paymentAmount;
	

	public String getCcHolderName() {
		return ccHolderName;
	}

	public void setCcHolderName(String ccHolderName) {
		this.ccHolderName = ccHolderName;
	}

	public String getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getCvvCode() {
		return cvvCode;
	}

	public void setCvvCode(String cvvCode) {
		this.cvvCode = cvvCode;
	}

	public Double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(Double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
