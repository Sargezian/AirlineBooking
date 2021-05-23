package client.views.passenger;

import client.core.ClientFactory;
import client.core.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.model.database.PassengerDao;
import server.model.database.PassengerImpl;
import server.model.database.ResetDao;
import shared.transferobjects.Flights;
import shared.transferobjects.Passenger;
import shared.transferobjects.Seat;

import java.security.PublicKey;

import static org.junit.jupiter.api.Assertions.*;

class passengerDaoTest
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

    @Test
    public void testIfTelefonWorksAt8Chars(){

        assertNull(passengerViewModel.errorProperty().get());
    }

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
    @Test
    public void testIfTelefonWorksAt9Chars(){
        passengerViewModel.clearFields();
        passengerViewModel.firstNameProperty().setValue("Mark");
        passengerViewModel.lastNameProperty().setValue("Pedersen");
        passengerViewModel.emailProperty().setValue("Mark@test.com");
        passengerViewModel.telNumberProperty().setValue("123456789");
        passengerViewModel.validatePassengerInformation();
        assertEquals("",passengerViewModel.errorProperty().get());
    }

    @Test
    public void testIfEmailworkwitha(){
        passengerViewModel.clearFields();
        passengerViewModel.firstNameProperty().setValue("Mark");
        passengerViewModel.lastNameProperty().setValue("Pedersen");
        passengerViewModel.emailProperty().setValue("Mark@test.com");
        passengerViewModel.telNumberProperty().setValue("1234567");
        passengerViewModel.validatePassengerInformation();
        assertEquals("",passengerViewModel.errorProperty().get());
    }
    @Test
    public void testIfEmailworkwithouta(){
        passengerViewModel.clearFields();
        passengerViewModel.firstNameProperty().setValue("Mark");
        passengerViewModel.lastNameProperty().setValue("Pedersen");
        passengerViewModel.emailProperty().setValue("Marktest.com");
        passengerViewModel.telNumberProperty().setValue("1234567");
        passengerViewModel.validatePassengerInformation();
        assertEquals("",passengerViewModel.errorProperty().get());
    }


}