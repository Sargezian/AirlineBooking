package Bestilling_af_valgte_Flyrejser;
import client.core.ClientFactory;
import client.core.ModelFactory;
import client.views.dashboard.dashboardViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.model.database.FlightImpl;
import server.model.database.ResetDao;
import server.model.database.ResetImpl;
import shared.transferobjects.Arrival;
import shared.transferobjects.Depature;
import shared.transferobjects.Flights;
import shared.transferobjects.PlaneType;

import static org.junit.jupiter.api.Assertions.assertEquals;

class dashBoardViewmodelTest
{
  private dashboardViewModel flightViewModel;
  FlightImpl flight;
  private ResetDao resetDao;


@BeforeEach
public void setUp(){
  ClientFactory.getInstance().getClient();
  flightViewModel = new dashboardViewModel(ModelFactory.getInstance().getClientText());
  flightViewModel.loadFlights();
  flight = FlightImpl.getInstance();
  resetDao = new ResetImpl();
  resetDao.reset();
}

@Test void test_OrdreAFlight()
{

  //flightViewModel.getflight().add(new Flights("S23","Sas",new Depature(400,"Test","Test"),new Arrival(700,"Test","Test"),new PlaneType(400,"fdsd"),"200"));
 // flightViewModel.getFlightInformation(flightViewModel.getflight().get(1));



}





}