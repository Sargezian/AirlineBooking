package server.model.database;

import shared.transferobjects.Passenger;
import shared.transferobjects.Payment;

import java.sql.Date;

public interface PaymentDao {

    Payment CreatePayment(String cardholderName, String cardNumber, String CVV, String expirationDate);

}
