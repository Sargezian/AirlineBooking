package shared.transferobjects;

import javafx.beans.property.SimpleStringProperty;

public class flightlist {

    private SimpleStringProperty pla;
    private SimpleStringProperty plb;

    public flightlist(String pla, String plb) {
        this.pla = new SimpleStringProperty(pla);
        this.plb = new SimpleStringProperty(plb);
    }

    public String getPla() {
        return pla.get();
    }

    public SimpleStringProperty plaProperty() {
        return pla;
    }

    public void setPla(String pla) {
        this.pla.set(pla);
    }

    public String getPlb() {
        return plb.get();
    }

    public SimpleStringProperty plbProperty() {
        return plb;
    }

    public void setPlb(String plb) {
        this.plb.set(plb);
    }

    @Override
    public String toString() {
        return "flightlist{" +
                "pla=" + pla +
                ", plb=" + plb +
                '}';
    }
}
