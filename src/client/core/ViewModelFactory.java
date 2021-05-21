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

    private static ViewModelFactory viewModelFactory;
    private loginViewModel loginViewModel;
    private chatViewModel chatViewModel;
    private dashboardViewModel dashboardViewModel;
    private myflightplanViewModel myflightplanViewModel;
    private seatViewModel seatViewModel;
    private passengerViewModel passengerViewModel;
    private paymentViewModel paymentViewModel;
    private createUserViewModel createUserViewModel;
    private adminFlightViewModel adminViewModel;

    public ViewModelFactory() {

    }


    public static ViewModelFactory getInstance()
    {
        if (viewModelFactory == null)
        {
            viewModelFactory = new ViewModelFactory();
        }
        return viewModelFactory;
    }

    public loginViewModel getloginViewModel() {
        if (loginViewModel == null)
            loginViewModel = new loginViewModel(ModelFactory.getInstance().getClientText());
        return loginViewModel;
    }

    public chatViewModel getchatViewModel() {
        return (chatViewModel = chatViewModel == null ?
                new chatViewModel(ModelFactory.getInstance().getClientText()) :
                chatViewModel);
    }

    public myflightplanViewModel getmyflightplanViewModel() {
        return (myflightplanViewModel = myflightplanViewModel == null ?
                new myflightplanViewModel(ModelFactory.getInstance().getClientText()) :
                myflightplanViewModel);
    }

    public dashboardViewModel getdashboardViewModel() {
        return (dashboardViewModel = dashboardViewModel == null ?
                new dashboardViewModel(ModelFactory.getInstance().getClientText()) :
                dashboardViewModel);
    }

    public seatViewModel getseatViewModel() {
        return (seatViewModel = seatViewModel == null ?
                new seatViewModel(ModelFactory.getInstance().getClientText()) :
                seatViewModel);
    }

    public passengerViewModel getPassengerViewModel() {
        return (passengerViewModel = passengerViewModel == null ?
                new passengerViewModel(ModelFactory.getInstance().getClientText()) :
                passengerViewModel);
    }

    public paymentViewModel getPaymentViewModel() {
        return (paymentViewModel = paymentViewModel == null ?
                new paymentViewModel(ModelFactory.getInstance().getClientText()) :
                paymentViewModel);
    }

    public createUserViewModel getcreateUserViewModel() {
        return (createUserViewModel = paymentViewModel == null ?
                new createUserViewModel(ModelFactory.getInstance().getClientText()) :
                createUserViewModel);
    }

    public adminFlightViewModel getadminViewModel() {
        return (adminViewModel = adminViewModel == null ?
                new adminFlightViewModel(ModelFactory.getInstance().getClientText()) :
                adminViewModel);
    }

}