package client.views.dashboard;

import client.model.ClientText;
import client.model.SaveInfo;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.transferobjects.Flights;
import shared.util.utils;
import java.beans.PropertyChangeEvent;
import java.util.Date;
import java.util.List;

public class dashboardViewModel {

    // TODO: 04/05/2021 lave evt. en klokke til foside

    // TODO: 04/05/2021 lave admin side

    // TODO: 04/05/2021 print billet ud når ticket er lavet

    private ClientText clientText;
    private ObservableList<Flights> flights;
    private StringProperty search;
    private StringProperty error;
    private StringProperty clock;



    public dashboardViewModel(ClientText clientText) {
        this.clientText = clientText;
        search = new SimpleStringProperty();
        error = new SimpleStringProperty();
        clock = new SimpleStringProperty();
        clientText.addListener(utils.NEWFLIGHT, this::onNewInputflight);
        startClock();
    }

    public void loadFlights() {
        List<Flights> flight = clientText.getflights();
        flights = FXCollections.observableArrayList(flight);
    }

    public boolean getFlightInformation(Flights flights) {

        if (flights != null) {
            SaveInfo.getInstance().setFlights(flights);
            System.out.println("Save flightInformation  = " + SaveInfo.getInstance());
            return true;
        }else {
            error.set("Please choose a flight for continue ");
            return false;
        }
    }

    public void search(){
        flights.setAll(clientText.readByName(search.getValue()));
    }

    public String getSearch() {
        return search.get();
    }

    public StringProperty searchProperty() {
        return search;
    }

    public void onNewInputflight(PropertyChangeEvent  evt) {
        flights.add((Flights) evt.getNewValue());
    }

    public ObservableList<Flights> getflight() {
        return flights;
    }

    public String getError() {
        return error.get();
    }

    public StringProperty errorProperty() {
        return error;
    }

    public StringProperty clockProperty(){return clock;}

    public void startClock(){
        new Thread(new Runnable()
        {
            @Override public void run()
            {
                while (true){
                Date myDate=new Date();

                System.out.println(myDate);

                int currentHour;
                int currentMinute;
                int currentSecond;
                currentHour=myDate.getHours();
                currentMinute=myDate.getMinutes();
                currentSecond=myDate.getSeconds();

                clock.setValue("clock"+currentHour+currentMinute+currentSecond);
            }}
        }).start();
    }
}
