package shared.transferobjects;

import java.io.Serializable;

public class Seat implements Serializable {

    public String seatID;
    public String seatNumber;
    public String classType;

    public Seat(String seatID, String seatNumber, String classType) {
        this.seatID = seatID;
        this.seatNumber = seatNumber;
        this.classType = classType;
    }

    public Seat(String seatNumber, String classType) {

        this.seatNumber = seatNumber;
        this.classType = classType;
    }

    public String getSeatID() {
        return seatID;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public String getClassType() {
        return classType;
    }

    @Override
    public String toString() {
        return "seat{" +
                "seatID='" + seatID + '\'' +
                ", seatNumber='" + seatNumber + '\'' +
                ", classType='" + classType + '\'' +
                '}';
    }

}
