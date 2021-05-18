package client.core;

import client.views.Payment.paymentViewController;
import client.views.Payment.paymentViewModel;
import client.views.ViewController;
import client.views.admin.Seatviewcontroller;
import client.views.chat.chatViewController;
import client.views.myflightplan.myflightplanViewController;
import client.views.passenger.passengerViewController;
import client.views.seat.seatViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler {

    private Scene chatScene, loginScene, myflightplanScene, seatScene, passengerScene, paymentScene, createuserScene, adminScene, seatAdmin, airportAdmin;
    private myflightplanViewController mfv;
    private Stage stage;
    private ViewModelFactory vmf;
    private seatViewController seatController;
    private passengerViewController passengerViewController;
    private paymentViewController paymentViewModel;
    private chatViewController chatViewController;

    private class loadFxmlresult{
        private Parent root;
        private ViewController controller;

        public loadFxmlresult(Parent root, ViewController controller)
        {
            this.root = root;
            this.controller = controller;
        }

        public Parent getRoot()
        {
            return root;
        }

        public ViewController getController()
        {
            return controller;
        }
    }

    public ViewHandler(ViewModelFactory vmf) {
        this.vmf = vmf;
    }

    public void start() {
        stage = new Stage();
        openToDashView();
    }


    public void openToDashView() {
        try {
            Parent root = loadFXML("../views/dashboard/dashboard.fxml").getRoot();
            Scene logScene = new Scene(root);
            stage.setTitle("Dashboard");
            stage.setScene(logScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openLoginView() {
        if (loginScene == null) {
            try {
                Parent root = loadFXML("../views/Loginbox/login.fxml").getRoot();

                stage.setTitle("Login");
                loginScene = new Scene(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        stage.setScene(loginScene);
        stage.show();
    }

    public void openToMyFlightPlan() {
        if (myflightplanScene == null) {
            try {
                loadFxmlresult root = loadFXML("../views/myflightplan/myflightplan.fxml");
                mfv = (myflightplanViewController) root.getController();
                stage.setTitle("MyFlightPlan");
                myflightplanScene = new Scene(root.getRoot());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        mfv.reloadvm();
        stage.setScene(myflightplanScene);
        stage.show();
    }

    public void openSeat() {
        if (seatScene == null) {
            try {
                loadFxmlresult loadFxmlresult = loadFXML(
                    "../views/seat/seat.fxml");
                Parent root = loadFxmlresult.getRoot();
                seatController = (seatViewController) loadFxmlresult.getController();

                stage.setTitle("seat");
                seatScene = new Scene(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        seatController.reloadSeats();
        stage.setScene(seatScene);
        stage.show();
    }


    public void openToChatView() {
        if (chatScene == null) {
            try {
                loadFxmlresult loadFxmlresult = loadFXML(
                    "../views/chat/chat.fxml");
                Parent root = loadFxmlresult.getRoot();
                chatViewController= (client.views.chat.chatViewController) loadFxmlresult.getController();

                stage.setTitle("Chat");
                chatScene = new Scene(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        chatViewController.reloadchatview();
        stage.setScene(chatScene);
        stage.show();
    }

    public void openPassengerView() {
        if (passengerScene == null) {
            try {
                loadFxmlresult loadFxmlresult = loadFXML(
                    "../views/passenger/passenger.fxml");
                Parent root = loadFxmlresult.getRoot();
               passengerViewController = (client.views.passenger.passengerViewController) loadFxmlresult.getController();


                stage.setTitle("passenger");
                passengerScene = new Scene(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        passengerViewController.reloadpassenger();
        stage.setScene(passengerScene);
        stage.show();
    }

    public void openAdminView() {
        if (adminScene == null) {
            try {
                Parent root = loadFXML("../views/admin/admin.fxml").getRoot();

                stage.setTitle("admin");
                adminScene = new Scene(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        stage.setScene(adminScene);
        stage.show();
    }

    public void openPaymentView() {
        if (paymentScene == null) {
            try {
                loadFxmlresult loadFxmlresult = loadFXML(
                    "../views/Payment/payment.fxml");
                Parent root = loadFxmlresult.getRoot();
                paymentViewModel = (paymentViewController) loadFxmlresult.getController();
                stage.setTitle("payment");
                paymentScene = new Scene(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        paymentViewModel.reloadpayment();
        stage.setScene(paymentScene);
        stage.show();
    }

    public void openCreateUserView() {
        if (createuserScene == null) {
            try {
                Parent root = loadFXML("../views/createUser/createUser.fxml").getRoot();

                stage.setTitle("User");
                createuserScene = new Scene(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        stage.setScene(createuserScene);
        stage.show();
    }

    public void openAdminSeat() {
        if (seatAdmin == null) {
            try {
                Parent root = loadFXML("../views/admin/SeatAdmin.fxml").getRoot();

                stage.setTitle("Admin Add Seat");
                seatAdmin = new Scene(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        stage.setScene(seatAdmin);
        stage.show();
    }

    public void openAdminAirport() {
        if (airportAdmin == null) {
            try {
                Parent root = loadFXML("../views/admin/AirportAdmin.fxml").getRoot();

                stage.setTitle("Admin Add Seat");
                airportAdmin = new Scene(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        stage.setScene(airportAdmin);
        stage.show();
    }


    private loadFxmlresult loadFXML(String path) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(path));
        Parent root = loader.load();

        ViewController vc = loader.getController();
        vc.init(this, vmf);
        return new loadFxmlresult(root,vc);
    }
}
