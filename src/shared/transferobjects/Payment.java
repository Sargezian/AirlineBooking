package shared.transferobjects;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.Serializable;
import java.sql.Date;

public class Payment implements Serializable {

    public int PaymentID;
    public String CardholderName, CardNumber, CVV, ExpirationDate;
    private flights flights;

    public Payment(int paymentID, String cardholderName, String cardNumber, String CVV, String expirationDate) {
        this.PaymentID = paymentID;
        this.CardholderName = cardholderName;
        this.CardNumber = cardNumber;
        this.CVV = CVV;
        this.ExpirationDate = expirationDate;
    }

    public Payment(flights flights) {
        this.flights = flights;
    }

    //payment
    public int getPaymentID() {
        return PaymentID;
    }
    public String getCardholderName() {
        return CardholderName;
    }
    public String getCardNumber() {
        return CardNumber;
    }
    public String getCVV() {
        return CVV;
    }
    public String getExpirationDate() {
        return ExpirationDate;
    }

    //flight
    public int getPrice(){
        return flights.price;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "PaymentID=" + PaymentID +
                ", CardholderName='" + CardholderName + '\'' +
                ", CardNumber='" + CardNumber + '\'' +
                ", CVV='" + CVV + '\'' +
                ", ExpirationDate='" + ExpirationDate + '\'' +
                ", flights=" + flights +
                '}';
    }
}
