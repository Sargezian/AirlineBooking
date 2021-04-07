package client.core;

import client.views.Loginbox.loginViewModel;
import client.views.chat.chatViewModel;
import client.views.dashboard.dashboardViewModel;
import client.views.myflightplan.myflightplanViewModel;

public class ViewModelFactory {

    private final ModelFactory mf;
    private client.views.Loginbox.loginViewModel loginViewModel;
    private chatViewModel chatViewModel;
    private client.views.dashboard.dashboardViewModel dashboardViewModel;
    private client.views.myflightplan.myflightplanViewModel myflightplanViewModel;

    public ViewModelFactory(ModelFactory mf) {
        this.mf=mf;
    }

    public client.views.Loginbox.loginViewModel getloginViewModel() {
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
}