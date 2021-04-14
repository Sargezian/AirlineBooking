package shared.transferobjects;

import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class Myflightlist implements Serializable {

    private String pla;
    private String plb;

    public Myflightlist(String pla, String plb) {
        this.pla = pla;
        this.plb = plb;
    }

    public String getPla() {
        return pla;
    }

    public String getPlb() {
        return plb;
    }

    @Override
    public String toString() {
        return "flightlist{" +
                "pla='" + pla + '\'' +
                ", plb='" + plb + '\'' +
                '}';
    }
}
