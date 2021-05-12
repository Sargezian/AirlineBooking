package client.views.admin;

import client.model.ClientText;
import javafx.beans.property.*;

import java.rmi.RemoteException;

public class Seatviewmodel {

  private ClientText clientText;
  private IntegerProperty seatId;
  private StringProperty seatNumber;
  private StringProperty classType;
  private StringProperty error;



  public Seatviewmodel(ClientText clientText){
    this.clientText = clientText;
    seatId = new SimpleIntegerProperty();
    seatNumber = new SimpleStringProperty();
    classType = new SimpleStringProperty();
    error = new SimpleStringProperty();
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
