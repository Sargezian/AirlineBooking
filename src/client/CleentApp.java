package client;

import client.core.ClientFactory;
import client.core.ModelFactory;
import client.core.ViewHandler;
import client.core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class CleentApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        ViewHandler vh = new ViewHandler(ViewModelFactory.getInstance());
        vh.start();
    }

}
