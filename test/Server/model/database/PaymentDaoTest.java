package Server.model.database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.model.database.PaymentDao;
import server.model.database.PaymentImpl;
import server.model.database.ResetDao;
import server.model.database.ResetImpl;
import shared.transferobjects.Payment;

import static org.junit.jupiter.api.Assertions.*;

class PaymentDaoTest {



    private PaymentDao paymentDao;
    private ResetDao resetDao;


    @BeforeEach
    public void setUp()  {
        paymentDao = PaymentImpl.getInstance();
        resetDao = new ResetImpl();
        resetDao.reset();

    }

    @Test
    public void TestIfWeCanCreateAndRead(){

        Payment payment = new Payment(1,"test","43234323432343234","432","12/06/2022");

        paymentDao.CreatePayment(payment.getCardholderName(),payment.getCardNumber(),payment.getCVV(),payment.getExpirationDate());

        assertEquals("432",paymentDao.ReadPayment().get(0).getCVV());


    }






}