package shared.transferobjects;

import java.io.Serializable;

public class Seat implements Serializable {

    public int seatID;
    public String seatNumber;
    public String classType;

    public Seat(int seatID, String seatNumber, String classType) {
        this.seatID = seatID;
        this.seatNumber = seatNumber;
        this.classType = classType;
    }

    public int getSeatID() {
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
