package shared.transferobjects;

import java.io.Serializable;

public class PlaneType implements Serializable {

    public int planeId;
    public String planeType;

    public PlaneType(int planeId, String planeType) {
        this.planeId = planeId;
        this.planeType = planeType;

    }

    public int getPlaneId() {
        return planeId;
    }

    public String getPlaneType() {
        return planeType;
    }


    @Override
    public String toString() {
        return "PlaneType{" +
                "planeId=" + planeId +
                ", planeType='" + planeType + '\'' +
                '}';
    }
}
