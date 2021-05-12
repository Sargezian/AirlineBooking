package client.views.admin;

import client.model.ClientText;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.transferobjects.Airport;
import shared.transferobjects.Flights;
import shared.transferobjects.Seat;
import shared.util.utils;

import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;
import java.util.List;

public class Seatviewmodel {

  private ClientText clientText;
  private IntegerProperty seatId;
  private StringProperty seatNumber;
  private StringProperty classType;
  private StringProperty error;
  private StringProperty airportId;
  private StringProperty airportName;
  private StringProperty airportCity;
  private ObservableList<Seat>seatObservableList;
  private ObservableList<Airport> airportObservableList;




  public Seatviewmodel(ClientText clientText){
    this.clientText = clientText;
    seatId = new SimpleIntegerProperty();
    seatNumber = new SimpleStringProperty();
    classType = new SimpleStringProperty();
    error = new SimpleStringProperty();
    airportId = new SimpleStringProperty();
    airportName = new SimpleStringProperty();
    airportCity = new SimpleStringProperty();
    error = new SimpleStringProperty();
    clientText.addListener(utils.NEWSEAT,this::onNewInputSeat);
    clientText.addListener(utils.NEWAIRPORT,this::onNewInputAirport);
  }

  public void onNewInputAirport(PropertyChangeEvent event) {
    airportObservableList.add((Airport) event.getNewValue());

  }

  public void onNewInputSeat(PropertyChangeEvent event) {
      seatObservableList.add((Seat) event.getNewValue());
  }



  public void InsertSeatInfomation() throws RemoteException
  {

    if (seatId.getValue() != null && !"".equals(seatId.getValue()) && seatNumber.getValue() != null && !"".equals(seatNumber.getValue()) && classType.getValue() != null && !"".equals(classType.getValue()))  {


      String SeatNumber = this.seatNumber.getValue();
      String SeatClassType = this.classType.getValue();
      clientText.CreateSeat(SeatNumber,SeatClassType);


    }

  }

  public boolean validatePassengerInformation()
  {

    if (seatId.getValue() == null)
    {
      error.set("ID cannot be empty");
      return false;
    }
    if (seatNumber.getValue() == null)
    {
      error.set("Airport Name cannot be empty");
      return false;
    }
    if (classType.getValue() == null)
    {
      error.set("Airport City cannot be empty");
      return false;
    }
    else
    {

      return true;
    }
  }

  public void InsertAirportInfomation()
  {

    if (airportId.getValue() != null && !"".equals(airportId.getValue()) && airportCity.getValue() != null && !"".equals(airportCity.getValue()) && airportName.getValue() != null && !"".equals(airportName.getValue()))  {

      String AirportID = this.airportId.getValue();
      String AirportName = this.airportName.getValue();
      String AirportCity = this.airportCity.getValue();
      clientText.CreateAirport(AirportID,AirportName,AirportCity);

    }

  }


  public void loadSeat() {
    List<Seat> seats = clientText.getSeats();
    seatObservableList = FXCollections.observableArrayList(seats);
  }


  public void loadAirport() {
    List<Airport> airportList = clientText.getAirport();
    airportObservableList = FXCollections.observableArrayList(airportList);
  }



  public ObservableList<Seat> getSeatObservableList() {
    return seatObservableList;
  }

  public ObservableList<Airport> getAirportObservableList() {
    return airportObservableList;
  }

  public String getAirportId()
  {
    return airportId.get();
  }

  public StringProperty airportIdProperty()
  {
    return airportId;
  }

  public void setAirportId(String airportId)
  {
    this.airportId.set(airportId);
  }

  public String getAirportName()
  {
    return airportName.get();
  }

  public StringProperty airportNameProperty()
  {
    return airportName;
  }

  public void setAirportName(String airportName)
  {
    this.airportName.set(airportName);
  }

  public String getAirportCity()
  {
    return airportCity.get();
  }

  public StringProperty airportCityProperty()
  {
    return airportCity;
  }

  public void setAirportCity(String airportCity)
  {
    this.airportCity.set(airportCity);
  }

  public String getError()
  {
    return error.get();
  }

  public StringProperty errorProperty()
  {
    return error;
  }

  public void setError(String error)
  {
    this.error.set(error);
  }

  public boolean validateAirportInformation()
  {

    if (airportId.getValue() == null)
    {
      error.set("ID cannot be empty");
      return false;
    }
    if (airportName.getValue() == null)
    {
      error.set("Airport Name cannot be empty");
      return false;
    }
    if (airportCity.getValue() == null)
    {
      error.set("Airport City cannot be empty");
      return false;
    }
    else
    {

      return true;
    }
  }

  public int getSeatId()
  {
    return seatId.get();
  }

  public IntegerProperty seatIdProperty()
  {
    return seatId;
  }

  public void setSeatId(int seatId)
  {
    this.seatId.set(seatId);
  }

  public String getSeatNumber()
  {
    return seatNumber.get();
  }

  public StringProperty seatNumberProperty()
  {
    return seatNumber;
  }

  public void setSeatNumber(String seatNumber)
  {
    this.seatNumber.set(seatNumber);
  }

  public String getClassType()
  {
    return classType.get();
  }

  public StringProperty classTypeProperty()
  {
    return classType;
  }

  public void setClassType(String classType)
  {
    this.classType.set(classType);
  }
}
