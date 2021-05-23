package client.views.Payment;

import client.core.ClientFactory;
import client.core.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.model.database.*;

import static org.junit.jupiter.api.Assertions.*;

class paymentViewModelTest
{
private paymentViewModel paymentViewModel;
private PaymentImpl paymentimpl;
private PaymentDao paymentDao;
private ResetDao resetDao;


@BeforeEach public void setup(){
  ClientFactory.getInstance().getClient();
  paymentViewModel = new paymentViewModel(ModelFactory.getInstance()
      .getClientText());
  paymentViewModel.clearFields();
  paymentimpl = PaymentImpl.getInstance();
  resetDao = new ResetImpl();
  resetDao.reset();

  paymentViewModel.cardholderNameProperty().setValue("Mark Pedersen");
  paymentViewModel.cardNumberProperty().setValue("1234567812345678");
  paymentViewModel.CVVProperty().setValue("123");

}
  //  On boundary
@Test
  public void testIfCarNumberCanBe16(){
  paymentViewModel.validatePaymentInfo();
  assertNull(paymentViewModel.errorProperty().get());

}
  //  1 before boundary
  @Test
  public void testIfCarNumberLowerThen16(){
    paymentViewModel.clearFields();
    paymentViewModel.cardholderNameProperty().setValue("Mark Pedersen");
    paymentViewModel.cardNumberProperty().setValue("123456781234567");
    paymentViewModel.CVVProperty().setValue("123");
    paymentViewModel.validatePaymentInfo();

    assertEquals("CardNumber must contain 16 characters",paymentViewModel.errorProperty().get());
  }

  //  1 after boundary
  @Test
  public void testIfCarNumberHigherThen16(){
    paymentViewModel.clearFields();
    paymentViewModel.cardholderNameProperty().setValue("Mark Pedersen");
    paymentViewModel.cardNumberProperty().setValue("12345678123456781");
    paymentViewModel.CVVProperty().setValue("123");
    paymentViewModel.validatePaymentInfo();

    assertEquals("CardNumber must contain 16 characters",paymentViewModel.errorProperty().get());
  }

  //  On boundary
  @Test
  public void testIfCvvCanBe3(){
    paymentViewModel.validatePaymentInfo();

    assertNull(paymentViewModel.errorProperty().get());
  }

  //  1 before boundary
  @Test
  public void testIfCvvCanBeLowerThen3(){

  paymentViewModel.CVVProperty().setValue("1234");
  paymentViewModel.validatePaymentInfo();
  assertEquals("CVV must contain less than 3 characters",paymentViewModel.errorProperty().get());

  }

}