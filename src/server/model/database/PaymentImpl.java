package server.model.database;

import shared.transferobjects.Passenger;
import shared.transferobjects.Payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentImpl implements PaymentDao {

    private static PaymentImpl daoInstance;

    public static synchronized PaymentImpl getInstance() {

        if (daoInstance == null) {
            daoInstance = new PaymentImpl();
        }
        return daoInstance;
    }


    @Override
    public Payment CreatePayment(String cardholderName, String cardNumber, String CVV, String expirationDate) {
        try {
            try (Connection connection =  daoConnection.getConnection()) {
                PreparedStatement statement = connection.prepareStatement("INSERT INTO payment(cardholderName,cardNumber,CVV,expirationDate) VALUES (?,?,?,?) ", PreparedStatement.RETURN_GENERATED_KEYS);

                //payment
                statement.setString(1, cardholderName);
                statement.setString(2, cardNumber);
                statement.setString(3, CVV);
                statement.setString(4, expirationDate);
                statement.executeUpdate();
                ResultSet key = statement.getGeneratedKeys();

                if (key.next()) {

                    return new Payment(key.getInt(1),cardholderName,cardNumber,CVV,expirationDate);
                } else {

                    throw new SQLException("Her bliver det testet på at lave en ny passenger");

                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

@Override
    public List<Payment> ReadPayment() {
        try {
            try (Connection connection =  daoConnection.getConnection()) {

                PreparedStatement statement = connection.prepareStatement("select * from payment");



                ResultSet resultSet = statement.executeQuery();
                ArrayList<Payment> paymentList = new ArrayList<>();

                while (resultSet.next()) {

                    int PaymentID = resultSet.getInt("PaymentID");
                    String CardholderName = resultSet.getString("CardholderName");
                    String CardNumber = resultSet.getString("CardNumber");
                    String CVV = resultSet.getString("CVV");
                    String ExpirationDate = resultSet.getString("ExpirationDate");



                  Payment payment = new Payment(PaymentID,CardholderName,CardNumber,CVV,ExpirationDate);
                    paymentList.add(payment);
                }
                return paymentList;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }





    }

