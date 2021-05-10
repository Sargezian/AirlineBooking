package client.core;

import client.views.Loginbox.loginViewModel;
import client.views.Payment.paymentViewModel;
import client.views.admin.adminFlightViewModel;
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


}