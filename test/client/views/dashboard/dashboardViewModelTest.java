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

    SaveInfo.getInstance().setFlights(new Flights("","",new Depature(0,"",""),new Arrival(0,"","")
        ,new PlaneType(0,""),""));
    SaveInfo.getInstance().getFlights();
    viewModel.getFlightInformation()
    assertEquals("",viewModel.errorProperty().get());


  }


}