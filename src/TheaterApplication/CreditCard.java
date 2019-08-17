package TheaterApplication;
import java.io.Serializable;
import java.util.Objects;

/**
 * Author Fromssa Olana
 * A credit Card class. It will hold full card futures.
 */
public class CreditCard implements Serializable, Matchable<String> {
    private static final long serialVersionUID = 1L;
    private String cardNumber;
    private String expDate;
    private String customersID;

    CreditCard(String cardNumber, String expDate, String customersID) {
        this.cardNumber = cardNumber;
        this.expDate = expDate;
        this.customersID = customersID;
    }

    String getCardNumber() {

        return cardNumber;
    }

    String getCustomersID() {

        return customersID;
    }

    void setCustomersID(String customersID) {

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

    @Override
    public boolean matches(String cardNumber) {
        return this.cardNumber.equals(cardNumber);
    }

    public String toString() {
        return "Card Number: " + cardNumber + "  Exp Date: " + expDate;
    }
}
