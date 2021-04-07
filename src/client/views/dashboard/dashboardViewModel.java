package client.views.dashboard;

import client.model.ClientText;

import java.util.ArrayList;

public class dashboardViewModel {
    private ArrayList<Flights> flightsArrayList;

    public dashboardViewModel(ClientText clientText) {
      //  this.textConverter = textConverter;

    }

    public ArrayList<Flights> addFlightsToView(){
        flightsArrayList.add(new Flights("Stor", "Til DK","A22"));
        return flightsArrayList;
    }

}
