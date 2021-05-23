package client.views.myflightplan;

import client.core.ClientFactory;
import client.core.ModelFactory;
import client.model.SaveInfo;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.model.database.*;
import shared.transferobjects.*;

import javax.mail.internet.AddressException;


import static org.junit.jupiter.api.Assertions.*;

class myflightplanViewModelTest
{

  private myflightplanViewModel myflightplan;
  private MyFlightTicketDao ticketDao;
  private ResetDao resetDao;
  private StringProperty print;
  private InputUserDao loginDao;
  private FlightDao flightDao;
  private PassengerDao passengerDao;
  private SeatDao seatDao;



  @BeforeEach
  public void setUp(){
    ClientFactory.getInstance().getClient();

    myflightplan = new myflightplanViewModel(ModelFactory.getInstance().getClientText());
    ticketDao = MyFlightTicketImpl.getInstance();
    loginDao = InputUserImpl.getInstance();
    flightDao = FlightImpl.getInstance();
    passengerDao = PassengerImpl.getInstance();
    seatDao = SeatImpl.getInstance();
    resetDao = new ResetImpl();
    resetDao.reset();
    print = new SimpleStringProperty();
    print.bind(myflightplan.printProperty());


  }

  @Test
  public void TestPrintIfMyFlightTicketIsNull() throws AddressException {

    SaveInfo.getInstance().setUser(new InputUser(1,"Username","password"));

    myflightplan.loadMyFlights();
    myflightplan.getMyFlightTickets();
    myflightplan.checkIfFlightsIsNull();

    assertEquals("Vi kan desværre ikke printe din billet, husk at købe en først",print.get());

  }



  @Test
  public void TestPrintIfMyFlightTicketIsNotNull()  {


    SaveInfo.getInstance().setUser(new InputUser(1,"Username","password"));
    SaveInfo.getInstance().setFlights(new Flights("1","sas",new Depature(1,"KBH","2021-08-08 19:30:00"),new Arrival(1,"AAR","2021-09-08 19:30:00")
            ,new PlaneType(1,"Airbus7"),"200"));

    SaveInfo.getInstance().setPassenger(new Passenger(1,"bob","bib","3232323","bobbib@gmail.com"));
    SaveInfo.getInstance().setSeat(new Seat(1,"22","Business class"));

    Flights ft = SaveInfo.getInstance().getFlights();
    Passenger pg = SaveInfo.getInstance().getPassenger();
    Seat st = SaveInfo.getInstance().getSeat();
    InputUser user = SaveInfo.getInstance().getUser();


    loginDao.createUser(user.user,user.password);
    passengerDao.CreatePassengers(pg.FirstName,pg.LastName,pg.TelNumber,pg.Email);
    seatDao.CreateSeat(st.seatNumber,st.classType);
    flightDao.CreateFlights(ft.flightID,ft.flightName,ft.price,ft.getArrivalID(),ft.getDepartureID(),ft.getPlaneId());



    myFlightTicket myFlightTicket1 = new myFlightTicket(String.valueOf(1),pg,ft,st,user);


    ticketDao.createTicket(myFlightTicket1);



    myflightplan.loadMyFlights();
    myflightplan.getMyFlightTickets();

    try {
      myflightplan.checkIfFlightsIsNull();
    } catch (AddressException e) {
      e.printStackTrace();
    }


    assertEquals("The ticket has been sent to your email " + pg.getEmail(),print.get());

  }





}