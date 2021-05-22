package shared.transferobjects;

import java.io.Serializable;

public class Seat implements Serializable {

    public int seatID;
    public String seatNumber;
    public String classType;
    public PlaneType planeType;

    public Seat(int seatID, String seatNumber, String classType)
    {
        this.seatID = seatID;
        this.seatNumber = seatNumber;
        this.classType = classType;


    }

    public Seat(String seatNumber, String classType) {
        this.seatNumber = seatNumber;
        this.classType = classType;
    }


    public Seat(int seatID, String seatNumber, String classType,
        PlaneType planeType)
    {
        this.seatID = seatID;
        this.seatNumber = seatNumber;
        this.classType = classType;
        this.planeType = planeType;
    }

    //seat
    public int getSeatID() {
        Seat seat = new Seat(1,"22","Business class");
        return seatID;
    }
    public String getSeatNumber() {
        return seatNumber;
    }
    public String getClassType() {
        return classType;
    }
//fkey fra planetype til at udfører at været fly har forskeliige sæder
    public PlaneType getPlaneType() { return planeType; }


    public int getPlaneId(){
        return planeType.planeId;
    }

    @Override public String toString()
    {
        return "Seat{" + "seatID=" + seatID + ", seatNumber='" + seatNumber
            + '\'' + ", classType='" + classType + '\'' + ", planeType="
            + planeType + '}';
    }
}
