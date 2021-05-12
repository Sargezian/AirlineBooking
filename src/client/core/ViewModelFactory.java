package client.core;

import client.views.Loginbox.loginViewModel;
import client.views.Payment.paymentViewModel;
import client.views.admin.*;
import client.views.chat.chatViewModel;
import client.views.createUser.createUserViewModel;
import client.views.dashboard.dashboardViewModel;
import client.views.myflightplan.myflightplanViewModel;
import client.views.passenger.passengerViewModel;
import client.views.seat.seatViewModel;

public class ViewModelFactory {

    private final ModelFactory mf;
    private loginViewModel loginViewModel;
    private chatViewModel chatViewModel;
    private dashboardViewModel dashboardViewModel;
    private myflightplanViewModel myflightplanViewModel;
    private seatViewModel seatViewModel;
    private passengerViewModel passengerViewModel;
    private paymentViewModel paymentViewModel;
    private createUserViewModel createUserViewModel;
    private adminFlightViewModel adminViewModel;
    private Seatviewmodel seatviewmodel1;
    //private DepartureViewmodel departureViewmodel;
    //private Arrivalviewmodel arrivalviewmodel;
   private AirportViewmodel airportViewmodel;

    public ViewModelFactory(ModelFactory mf) {
        this.mf=mf;
    }

    public loginViewModel getloginViewModel() {
        if (loginViewModel == null)
            loginViewModel = new loginViewModel(mf.getClientText());
        return loginViewModel;
    }

    public chatViewModel getchatViewModel() {
        return (chatViewModel = chatViewModel == null ?
                new chatViewModel(mf.getClientText()) :
                chatViewModel);
    }

    public myflightplanViewModel getmyflightplanViewModel() {
        return (myflightplanViewModel = myflightplanViewModel == null ?
                new myflightplanViewModel(mf.getClientText()) :
                myflightplanViewModel);
    }

    public dashboardViewModel getdashboardViewModel() {
        return (dashboardViewModel = dashboardViewModel == null ?
                new dashboardViewModel(mf.getClientText()) :
                dashboardViewModel);
    }

    public seatViewModel getseatViewModel() {
        return (seatViewModel = seatViewModel == null ?
                new seatViewModel(mf.getClientText()) :
                seatViewModel);
    }

    public passengerViewModel getPassengerViewModel() {
        return (passengerViewModel = passengerViewModel == null ?
                new passengerViewModel(mf.getClientText()) :
                passengerViewModel);
    }

    public paymentViewModel getPaymentViewModel() {
        return (paymentViewModel = paymentViewModel == null ?
                new paymentViewModel(mf.getClientText()) :
                paymentViewModel);
    }

    public createUserViewModel getcreateUserViewModel() {
        return (createUserViewModel = paymentViewModel == null ?
                new createUserViewModel(mf.getClientText()) :
                createUserViewModel);
    }

    public adminFlightViewModel getadminViewModel() {
        return (adminViewModel = adminViewModel == null ?
                new adminFlightViewModel(mf.getClientText()) :
                adminViewModel);
    }

  public Seatviewmodel getSeatViewModel() {
        return (seatviewmodel1 = seatViewModel == null ?
            new Seatviewmodel(mf.getClientText()) :
            seatviewmodel1);
    }
/*
    public DepartureViewmodel getDepartureViewModel() {
        return (departureViewmodel = departureViewmodel == null ?
            new DepartureViewmodel(mf.getClientText()) :
            departureViewmodel);
    }

    public Arrivalviewmodel getArrivalviewmodel() {
        return (arrivalviewmodel = arrivalviewmodel == null ?
            new Arrivalviewmodel(mf.getClientText()) :
            arrivalviewmodel);
    }
*/

    public AirportViewmodel getAirportviewmodel() {
        return (airportViewmodel = airportViewmodel == null ?
            new AirportViewmodel(mf.getClientText()) :
            airportViewmodel);


}


}