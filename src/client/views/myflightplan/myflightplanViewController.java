package client.views.myflightplan;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.model.SaveInfo;
import client.views.ViewController;
import client.views.passenger.passengerViewModel;
import com.pdfjet.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.transferobjects.Passenger;
import shared.transferobjects.myFlightTicket;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class myflightplanViewController implements ViewController {

    @FXML
    public TableView<myFlightTicket> flighttableview;
    @FXML
    public TableView<myFlightTicket> TicketTableview;
    @FXML
    public TableView<myFlightTicket> PassengerTableview;
   /* @FXML
    public TableView<myFlightTicket> PriceTableview;*/

    @FXML
    public TableColumn<Integer, myFlightTicket> FlightIdColumn;
    @FXML
    public TableColumn<String, myFlightTicket> FlightnameColumn;


    @FXML
    public TableColumn<String, myFlightTicket> PlanetypeColumn;


    @FXML
    public TableColumn<String, myFlightTicket> DepartureColumn;
    @FXML
    public TableColumn<Timestamp, myFlightTicket> DepartureDateColumn;

    @FXML
    public TableColumn<String, myFlightTicket> ArrivalColumn;
    @FXML
    public TableColumn<Timestamp, myFlightTicket> ArrivalDateColumn;
    @FXML
    public TableColumn<Integer, myFlightTicket> TicketIdColumn;

    @FXML
    public TableColumn<Integer, myFlightTicket> PassengerIdColumn;

    @FXML
    public TableColumn<String, myFlightTicket> NameColumn;
    @FXML
    public TableColumn<String, myFlightTicket> seat;
    @FXML
    public TableColumn<String, myFlightTicket> ClasstypeColumn;
    @FXML
    public TableColumn<String, myFlightTicket> LastNameCoulmn;
    @FXML
    public TableColumn<String, myFlightTicket> teleNumberColumn;
    @FXML
    public TableColumn<String, myFlightTicket> EmailCoulmn;

    /*@FXML public TableColumn<String,myFlightTicket> PriceSumColumn;*/

    @FXML
    private Label myName;
    private myflightplanViewModel vm;
    private ViewHandler vh;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        vm = vmf.getmyflightplanViewModel();

        vm.loadMyFlights();
        reloadvm();
        //vm.loadPriceSUM();
        myName.textProperty().bind(vm.usernameProperty());
    }

    public void reloadvm() {
        vm.loadMyFlights();
        vm.setUsername();
        FlightIdColumn.setCellValueFactory(new PropertyValueFactory<>("flightID"));
        FlightnameColumn.setCellValueFactory(new PropertyValueFactory<>("flightName"));
        PlanetypeColumn.setCellValueFactory(new PropertyValueFactory<>("planeTypes"));
        DepartureColumn.setCellValueFactory(new PropertyValueFactory<>("Departure"));
        ArrivalColumn.setCellValueFactory(new PropertyValueFactory<>("Arrivals"));
        DepartureDateColumn.setCellValueFactory(new PropertyValueFactory<>("DepartureDate"));
        ArrivalDateColumn.setCellValueFactory(new PropertyValueFactory<>("ArrivalDate"));
        TicketIdColumn.setCellValueFactory(new PropertyValueFactory<>("ticketID"));

        PassengerIdColumn.setCellValueFactory(new PropertyValueFactory<>("passengerID"));
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        seat.setCellValueFactory(new PropertyValueFactory<>("seatNumber"));
        ClasstypeColumn.setCellValueFactory(new PropertyValueFactory<>("ClassType"));
        LastNameCoulmn.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        teleNumberColumn.setCellValueFactory(new PropertyValueFactory<>("TelNumber"));
        EmailCoulmn.setCellValueFactory(new PropertyValueFactory<>("Email"));
        //  PriceSumColumn.setCellValueFactory(new PropertyValueFactory<>("PriceSum"));
        flighttableview.setItems(vm.getMyFlightTickets());
        TicketTableview.setItems(vm.getMyFlightTickets());
        PassengerTableview.setItems(vm.getMyFlightTickets());
        // PriceTableview.setItems(vm.getMyFlightTickets());

    }

    public void onBackDashboard(ActionEvent actionEvent) {
        vh.openToDashView();
    }

    public void onChat(ActionEvent actionEvent) {
        vh.openToChatView();
    }


    public void printbillet(ActionEvent actionEvent) throws Exception {

        File out = new File("myT.pdf");
        FileOutputStream fos = new FileOutputStream(out);
        PDF pdf = new PDF(fos);

        Page page = new Page(pdf, A4.LANDSCAPE);

        Font f1 = new Font(pdf, CoreFont.HELVETICA_BOLD);

        Font f2 = new Font(pdf, CoreFont.HELVETICA);

        Table table = new Table();
        List<List<Cell>> tabledata = new ArrayList<>();

        List<Cell> tablerow = new ArrayList<Cell>();

        Cell cell = new Cell(f1, FlightIdColumn.getText());
        tablerow.add(cell);
        cell = new Cell(f1, FlightnameColumn.getText());
        tablerow.add(cell);
        cell = new Cell(f1, PlanetypeColumn.getText());
        tablerow.add(cell);
        cell = new Cell(f1, DepartureColumn.getText());
        tablerow.add(cell);
        cell = new Cell(f1, ArrivalColumn.getText());
        tablerow.add(cell);
   /*     cell = new Cell(f1, DepartureDateColumn.getText());
        tablerow.add(cell);
        cell = new Cell(f1, ArrivalDateColumn.getText());
        tablerow.add(cell);
        cell = new Cell(f1, PassengerIdColumn.getText());*/
       // tablerow.add(cell);
        cell = new Cell(f1, NameColumn.getText());
        tablerow.add(cell);
        cell = new Cell(f1, seat.getText());
        tablerow.add(cell);
        cell = new Cell(f1, ClasstypeColumn.getText());
        tablerow.add(cell);
        cell = new Cell(f1, LastNameCoulmn.getText());
        tablerow.add(cell);
        cell = new Cell(f1, teleNumberColumn.getText());
        tablerow.add(cell);

        tabledata.add(tablerow);


        List<myFlightTicket> items = flighttableview.getItems();



        for (myFlightTicket item : items) {
            Cell FlightId = new Cell(f2, item.getFlightID());
            Cell Flightname = new Cell(f2, item.getFlightName());
            Cell planetype = new Cell(f2, item.getPlaneTypes());
            Cell Departure = new Cell(f2, item.getDeparture());
            Cell Arrival = new Cell(f2, item.getArrivals());
           // Cell departureDate = new Cell(f2, item.getDepartureDate());
           // Cell ArrivalDate = new Cell(f2, item.getArrivalDate());
            Cell seat = new Cell(f2, item.getSeatNumber());
            Cell Firstname = new Cell(f2, item.getFirstName());
            Cell lastname = new Cell(f2, item.getLastName());
            Cell telNumber = new Cell(f2, item.getTelNumber());
            Cell email = new Cell(f2, item.getEmail());

            tablerow = new ArrayList<Cell>();
            tablerow.add(FlightId);
            tablerow.add(Flightname);
            tablerow.add(planetype);
            tablerow.add(Departure);
            tablerow.add(Arrival);
            tablerow.add(seat);
            tablerow.add(Firstname);
            tablerow.add(lastname);
            tablerow.add(telNumber);
            tablerow.add(email);


            tabledata.add(tablerow);


        }

        table.setData(tabledata);
        table.setPosition(100f, 60f);
        table.setColumnWidth(0, 100f);
        table.setColumnWidth(1, 100f);



        while (true) {

            table.drawOn(page);
            if (!table.hasMoreData()) {
                table.resetRenderedPagesCount();
                break;
            }
            page = new Page(pdf, A4.LANDSCAPE);

        }

        pdf.close();
        fos.close();
        vm.sendtoEmail();

        System.out.println("Saved to " + out.getAbsolutePath());


    }









}
