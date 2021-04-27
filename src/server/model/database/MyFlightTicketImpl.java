package server.model.database;

import shared.transferobjects.Passenger;
import shared.transferobjects.flights;
import shared.transferobjects.myFlightTicket;
import shared.transferobjects.Seat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyFlightTicketImpl implements MyFlightTicketDao {

    private static MyFlightTicketImpl daoInstance;

    public static synchronized MyFlightTicketImpl getInstance(){

        if (daoInstance == null){
            daoInstance = new MyFlightTicketImpl();
        }
        return daoInstance;
    }

/*

    @Override
    public List<myFlightTicket> ReadPriceSUM() {
        try{

            try (Connection connection = daoConnection.getConnection()) {
                PreparedStatement statement = connection.prepareStatement("select SUM(price) from myFlightTicket ");
                ResultSet resultSet = statement.executeQuery();

                ArrayList<myFlightTicket> PriceSUM = new ArrayList<>();
                while (resultSet.next()) {

                    int price = resultSet.getInt("price");

                    myFlightTicket Ticket = new myFlightTicket(price);

                    PriceSUM.add(Ticket);
                }
                return PriceSUM;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
*/


    @Override
    public List<myFlightTicket> ReadFlightList(int passengerID)  {

        try{

            try (Connection connection = daoConnection.getConnection()) {
                PreparedStatement statement = connection.prepareStatement("select * from flights join myFlightTicket mFT on flights.flightID = mFT.flightID join passenger p on mFT.passengerid = p.passengerid join seat s on s.seatid = mFT.seatid where p.passengerID = ?  ");
                statement.setInt(1,passengerID);
                ResultSet resultSet = statement.executeQuery();

                ArrayList<myFlightTicket> myFlightTickets = new ArrayList<>();
                while (resultSet.next()) {
                    int FlightId = resultSet.getInt("flightid");
                    String Flightname = resultSet.getString("flightname");
                    String planeType = resultSet.getString("planeType");
                    Timestamp departure = resultSet.getTimestamp("departure");
                    Timestamp arrival = resultSet.getTimestamp("arrival");
                    String from = resultSet.getString("from_");
                    String to = resultSet.getString("to_");
                    int ticketid = resultSet.getInt("ticketid");
                    int price = resultSet.getInt("price");
                    String seatId = resultSet.getString("seatid");
                    String FirstName = resultSet.getString("FirstName");
                    String LastName = resultSet.getString("LastName");
                    String TelNumber = resultSet.getString("TelNumber");
                    String email = resultSet.getString("email");
                    String seatNumber = resultSet.getString("seatNumber");
                    String classtype = resultSet.getString("classType");
                    myFlightTicket myFlightTicket = new myFlightTicket(ticketid,price,new Passenger(passengerID,TelNumber,FirstName,LastName,email),new flights(FlightId,Flightname,planeType,departure,arrival,from,to,price),new Seat(seatId,seatNumber,classtype));

                    myFlightTickets.add(myFlightTicket);
                }
                return myFlightTickets;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void createTicket(myFlightTicket myFlightTicket) {
        try {
            try (Connection connection =  daoConnection.getConnection()) {
                PreparedStatement statement = connection.prepareStatement(" insert into myFlightTicket(flightID, passengerID, seatID,price) VALUES (?,?,?,?)");

                System.out.println( "database connection til createticket");

                statement.setInt(1, myFlightTicket.getFlights().getFlightID());
                statement.setInt(2, myFlightTicket.getPassenger().getPassengerID());
                statement.setString(3, myFlightTicket.getSeat().getSeatID());
                statement.setInt(4, myFlightTicket.getPrice());

                statement.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
