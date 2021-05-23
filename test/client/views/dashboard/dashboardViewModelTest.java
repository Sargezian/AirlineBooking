package client.views.dashboard;

import client.core.ClientFactory;
import client.core.ModelFactory;
import client.model.SaveInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.model.database.FlightDao;
import server.model.database.FlightImpl;
import server.model.database.adminDao;
import server.model.database.adminImpl;
import shared.transferobjects.Arrival;
import shared.transferobjects.Depature;
import shared.transferobjects.Flights;
import shared.transferobjects.PlaneType;

import static org.junit.jupiter.api.Assertions.*;

class dashboardViewModelTest
{
  private adminDao adminDao;
  private FlightDao flightDao;
  private dashboardViewModel viewModel;


  @BeforeEach public void setup(){
    flightDao = FlightImpl.getInstance();
    ClientFactory.getInstance().getClient();
    viewModel = new dashboardViewModel(ModelFactory.getInstance()
        .getClientText());
  }

  @Test void testNoSelectedFlight()
  {
    Flights flights = SaveInfo.getInstance().getFlights();
    viewModel.getFlightInformation(flights);
    assertEquals("Please choose a flight for continue ",viewModel.errorProperty().get());


  }

  @Test void testSelectedFlight()
  {
    SaveInfo.getInstance().setFlights(new Flights("1","sas",new Depature(1,"KBH","2021-08-08 19:30:00"),new Arrival(1,"AAR","2021-09-08 19:30:00")
        ,new PlaneType(1,"Airbus7"),"200"));
    Flights flights = SaveInfo.getInstance().getFlights();
    viewModel.getFlightInformation(flights);

    assertNull(viewModel.errorProperty().get());
  }


  @Test void testSearchFlightIfValidInput(){

    SaveInfo.getInstance().setFlights(new Flights("1","sas",new Depature(1,"KBH","2021-08-08 19:30:00"),new Arrival(1,"AAR","2021-09-08 19:30:00")
        ,new PlaneType(1,"Airbus7"),"200"));
    SaveInfo.getInstance().getFlights();
    viewModel.loadFlights();
    viewModel.searchProperty().setValue("sas");
    viewModel.search();
    assertEquals("",viewModel.getflight());
  }



  @Test void testSearchFlightIfInvalidInput(){

    SaveInfo.getInstance().setFlights(new Flights("1","sas",new Depature(1,"KBH","2021-08-08 19:30:00"),new Arrival(1,"AAR","2021-09-08 19:30:00")
        ,new PlaneType(1,"Airbus7"),"200"));
    SaveInfo.getInstance().getFlights();
    viewModel.loadFlights();
    viewModel.searchProperty().setValue("ÅÅÅÅÅ");
    viewModel.search();
    assertEquals("",viewModel.getflight());
  }


}