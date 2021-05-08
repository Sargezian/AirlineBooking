package client.core;

import client.views.ViewController;
import client.views.myflightplan.myflightplanViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler {

    private Scene chatScene, loginScene, myflightplanScene, seatScene, passengerScene, paymentScene, createuserScene, adminScene;
    private myflightplanViewController mfv;
    private Stage stage;
    private ViewModelFactory vmf;
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
                Parent root = loadFXML("../views/seat/seat.fxml").getRoot();

                stage.setTitle("seat");
                seatScene = new Scene(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        stage.setScene(seatScene);
        stage.show();
    }


    public void openToChatView() {
        if (chatScene == null) {
            try {
                Parent root = loadFXML("../views/chat/chat.fxml").getRoot();

                stage.setTitle("Chat");
                chatScene = new Scene(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        stage.setScene(chatScene);
        stage.show();
    }

    public void openPassengerView() {
        if (passengerScene == null) {
            try {
                Parent root = loadFXML("../views/passenger/passenger.fxml").getRoot();

                stage.setTitle("passenger");
                passengerScene = new Scene(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
                Parent root = loadFXML("../views/Payment/payment.fxml").getRoot();
                stage.setTitle("payment");
                paymentScene = new Scene(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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



    private loadFxmlresult loadFXML(String path) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(path));
        Parent root = loader.load();

        ViewController vc = loader.getController();
        vc.init(this, vmf);
        return new loadFxmlresult(root,vc);
    }
}
