package com.TheaterApp;

public class CreditCard {
    private String cardNumber;
    private String expDate;
    private String cardId;
    private String customersID;

    public CreditCard(String cardNumber, String expDate, String customersID){
        this.cardNumber = cardNumber;
        this.expDate = expDate;
        this.customersID = customersID;
        this.cardId = cardNumber.substring(cardNumber.length() - 4); // last four number of card
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCustomersID() {
        return customersID;
    }

    public void setCustomersID(String customersID) {
        this.customersID = customersID;
    }

    public String getId() {
        return cardId;
    }

    public String toString(){
        return "[ "+ " Card Number: " + cardNumber +"\nExp Date: "+ expDate;
    }
}
