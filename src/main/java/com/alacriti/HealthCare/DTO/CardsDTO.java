package com.alacriti.HealthCare.DTO;

public class CardsDTO {
	private String cardName;
	private String cardNumber;
	private String cvv;
	private String expiryDate;
	
	
	public CardsDTO() {}


	public CardsDTO(String cardName, String cardNumber, String cvv, String expiryDate, int balance) {
		super();
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.expiryDate = expiryDate;
	}


	public String getCardName() {
		return cardName;
	}


	public void setCardName(String cardName) {
		this.cardName = cardName;
	}


	public String getCardNumber() {
		return cardNumber;
	}


	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}


	public String getCvv() {
		return cvv;
	}


	public void setCvv(String cvv) {
		this.cvv = cvv;
	}


	public String getExpiryDate() {
		return expiryDate;
	}


	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}


	@Override
	public String toString() {
		return "CardsDTO [cardName=" + cardName + ", cardNumber=" + cardNumber + ", cvv=" + cvv + ", expiryDate="
				+ expiryDate + "]";
	}

	
	
	
}
