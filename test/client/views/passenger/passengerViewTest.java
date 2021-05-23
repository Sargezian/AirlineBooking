package client.views.passenger;

import client.core.ClientFactory;
import client.core.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.model.database.PassengerDao;
import server.model.database.PassengerImpl;
import server.model.database.ResetDao;

import static org.junit.jupiter.api.Assertions.assertEquals;

class passengerViewTest
{
    private passengerViewModel passengerViewModel;
    private PassengerImpl passengerimpl;
    private PassengerDao passengerDao;
    private ResetDao resetDao;

    @BeforeEach public void setup()
    {
        ClientFactory.getInstance().getClient();
        passengerViewModel = new passengerViewModel(ModelFactory.getInstance()
            .getClientText());
        passengerViewModel.clearFields();
        passengerimpl = PassengerImpl.getInstance();




        passengerViewModel.telNumberProperty().setValue("51408516");
        passengerViewModel.firstNameProperty().setValue("Mark");
        passengerViewModel.lastNameProperty().setValue("Pedersen");
        passengerViewModel.emailProperty().setValue("Mark@test.com");

    }
    //  On boundary
    @Test
    public void testIfTelefonWorksAt8Chars(){

        assertEquals("",passengerViewModel.errorProperty().get());
    }
    //  1 before boundary
    @Test
    public void testIfTelefonWorksAt7Chars(){
        passengerViewModel.clearFields();
        passengerViewModel.firstNameProperty().setValue("Mark");
        passengerViewModel.lastNameProperty().setValue("Pedersen");
        passengerViewModel.emailProperty().setValue("Mark@test.com");
        passengerViewModel.telNumberProperty().setValue("1234567");
        passengerViewModel.validatePassengerInformation();
        assertEquals("",passengerViewModel.errorProperty().get());
    }

    //  1 after boundary
    @Test
    public void testIfTelefonWorksAt9Chars(){
        passengerViewModel.clearFields();
        passengerViewModel.firstNameProperty().setValue("Mark");
        passengerViewModel.lastNameProperty().setValue("Pedersen");
        passengerViewModel.emailProperty().setValue("Mark@test.com");
        passengerViewModel.telNumberProperty().setValue("123456789");
        passengerViewModel.validatePassengerInformation();
        assertEquals("TelNumber must be 8 digits",passengerViewModel.errorProperty().get());
    }

    @Test
    public void testIfEmailworkwithSymbol(){
        passengerViewModel.clearFields();
        passengerViewModel.firstNameProperty().setValue("Mark");
        passengerViewModel.lastNameProperty().setValue("Pedersen");
        passengerViewModel.emailProperty().setValue("Mark@test.com");
        passengerViewModel.telNumberProperty().setValue("16781234");
        passengerViewModel.validatePassengerInformation();
        assertEquals("",passengerViewModel.errorProperty().get());
    }
    @Test
    public void testIfEmailworkwithoutSymbol(){
        passengerViewModel.clearFields();
        passengerViewModel.firstNameProperty().setValue("Mark");
        passengerViewModel.lastNameProperty().setValue("Pedersen");
        passengerViewModel.emailProperty().setValue("Marktest.com");
        passengerViewModel.telNumberProperty().setValue("12341234");
        passengerViewModel.validatePassengerInformation();
        assertEquals("Email must contain '@' ",passengerViewModel.errorProperty().get());
    }


}