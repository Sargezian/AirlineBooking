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
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    @FXML
    public Label printBIllet;
    public TableColumn<String,myFlightTicket> Price;

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
        Price.setCellValueFactory(new PropertyValueFactory<>("Prices"));



        //  PriceSumColumn.setCellValueFactory(new PropertyValueFactory<>("PriceSum"));
        flighttableview.setItems(vm.getMyFlightTickets());
        TicketTableview.setItems(vm.getMyFlightTickets());
        PassengerTableview.setItems(vm.getMyFlightTickets());
        printBIllet.textProperty().bind(vm.printProperty());


        // PriceTableview.setItems(vm.getMyFlightTickets());

    }

    public void onBackDashboard(ActionEvent actionEvent) {
        vh.openToDashView();
    }

    public void onChat(ActionEvent actionEvent) {
        vh.openToChatView();
    }


    public void printbillet(ActionEvent actionEvent) throws Exception {

        Path relativePath1 = Paths.get("src","myT.pdf");



        File out = new File("myT.pdf");
        FileOutputStream fos = new FileOutputStream(String.valueOf(relativePath1));
        PDF pdf = new PDF(fos);
        String fileName = "src/Billeder/flight.jpg";


       InputStream inputStream = new FileInputStream(fileName);
        Image image1 = new Image(pdf, inputStream, ImageType.JPG);

        Page page = new Page(pdf, A4.LANDSCAPE);

        Font f1 = new Font(pdf, CoreFont.HELVETICA_BOLD);
        Font f3 = new Font(pdf, CoreFont.TIMES_ROMAN);
        Font f4 = new Font(pdf, CoreFont.HELVETICA);

        Font f2 = new Font(pdf, CoreFont.HELVETICA);

        Table table = new Table();

        Table table1 = new Table();

        Table table2 = new Table();



        image1.setPosition(-311f,0f);
        image1.drawOn(page);


        TextLine text = new TextLine(f3,
                "Airline Booking");


        text.setFontSize(24);

        text.setPosition(330f,45f);

        text.drawOn(page);



        List<List<Cell>> tabledata = new ArrayList<>();
        List<List<Cell>> tabledata1 = new ArrayList<>();
        List<List<Cell>> tabledata2 = new ArrayList<>();

        List<Cell> tablerow = new ArrayList<Cell>();
        List<Cell> tablerow1 = new ArrayList<Cell>();
        List<Cell> tablerow2 = new ArrayList<Cell>();


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
        cell = new Cell(f1, DepartureDateColumn.getText());
        tablerow.add(cell);
        cell = new Cell(f1, ArrivalDateColumn.getText());
        tablerow.add(cell);
        cell = new Cell(f1, PassengerIdColumn.getText());
       // tablerow.add(cell);

        // passenger
       Cell cell1 = new Cell(f1, NameColumn.getText());
        tablerow1.add(cell1);

        cell1 = new Cell(f1, LastNameCoulmn.getText());
        tablerow1.add(cell1);

        cell1 = new Cell(f1, teleNumberColumn.getText());
        tablerow1.add(cell1);

        cell1 = new Cell(f1, EmailCoulmn.getText());
        tablerow1.add(cell1);

        //.-----------------------------------




         Cell cell4 = new Cell(f1, TicketIdColumn.getText());
        tablerow2.add(cell4);

        cell4 = new Cell(f1, seat.getText());
        tablerow2.add(cell4);


        cell4 = new Cell(f1, ClasstypeColumn.getText());
        tablerow2.add(cell4);


        tabledata.add(tablerow);
        tabledata1.add(tablerow1);
        tabledata2.add(tablerow2);


        List<myFlightTicket> items = flighttableview.getItems();



        for (myFlightTicket item : items) {
            Cell FlightId = new Cell(f2, item.getFlightID());
            Cell Flightname = new Cell(f2, item.getFlightName());
            Cell planetype = new Cell(f2, item.getPlaneTypes());
            Cell Departure = new Cell(f2, item.getDeparture());
            Cell Arrival = new Cell(f2, item.getArrivals());
            Cell departureDate = new Cell(f2, item.getDepartureDate());
            Cell ArrivalDate = new Cell(f2, item.getArrivalDate());
            Cell ticketId = new Cell(f2,item.getTicketID());
            Cell seat = new Cell(f2, item.getSeatNumber());
            Cell classType = new Cell(f2,item.getClassType());
            Cell Firstname = new Cell(f2, item.getFirstName());
            Cell lastname = new Cell(f2, item.getLastName());
            Cell telNumber = new Cell(f2, item.getTelNumber());
            Cell email = new Cell(f2, item.getEmail());

            tablerow = new ArrayList<Cell>();
            tablerow1 = new ArrayList<Cell>();
            tablerow2 = new ArrayList<Cell>();

            tablerow.add(FlightId);
            tablerow.add(Flightname);
            tablerow.add(planetype);
            tablerow.add(Departure);
            tablerow.add(Arrival);
            tablerow.add(departureDate);
            tablerow.add(ArrivalDate);

            tablerow2.add(ticketId);
            tablerow2.add(seat);
            tablerow2.add(classType);


            tablerow1.add(Firstname);
            tablerow1.add(lastname);
            tablerow1.add(telNumber);
            tablerow1.add(email);


            tabledata.add(tablerow);
            tabledata1.add(tablerow1);
            tabledata2.add(tablerow2);



        }

        table.setData(tabledata);
        table1.setData(tabledata1);
        table2.setData(tabledata2);



        table.setPosition(20f, 80f);
        table.setColumnWidth(0, 100f);
        table.setColumnWidth(1, 100f);
        table.setColumnWidth(2, 100f);
        table.setColumnWidth(3, 100f);
        table.setColumnWidth(4, 100f);
        table.setColumnWidth(5, 160f);
        table.setColumnWidth(6, 160f);


        table1.setPosition(20f, 130f);


        table1.setColumnWidth(0, 100f);
        table1.setColumnWidth(1, 100f);
        table1.setColumnWidth(2, 100f);
        table1.setColumnWidth(3, 170f);



        table2.setPosition(20f, 190f);


        table2.setColumnWidth(0, 100f);
        table2.setColumnWidth(1, 120f);
        table2.setColumnWidth(2, 150f);






        while (true) {

            table.drawOn(page);
            table1.drawOn(page);
            table2.drawOn(page);
            if (!table.hasMoreData()) {
                table.resetRenderedPagesCount();
                break;
            }
            page = new Page(pdf, A4.LANDSCAPE);

        }



        pdf.close();
        fos.close();


        vm.sendtoEmail();


        System.out.println("Saved");


    }









}
