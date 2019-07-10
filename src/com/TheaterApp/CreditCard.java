package com.TheaterApp;

import java.util.Objects;

public class CreditCard {
    private String cardNumber;
    private String expDate;
    private String customersID;

    public CreditCard(String cardNumber, String expDate, String customersID){
        this.cardNumber = cardNumber;
        this.expDate = expDate;
        this.customersID = customersID;
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

    public String getCustomersID() {
        return customersID;
    }

    public void setCustomersID(String customersID) {
        this.customersID = customersID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCard card = (CreditCard) o;
        return cardNumber.equals(card.cardNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber);
    }

    public String toString(){
        return "[ "+ " Card Number: " + cardNumber +"\nExp Date: "+ expDate;
    }
}
