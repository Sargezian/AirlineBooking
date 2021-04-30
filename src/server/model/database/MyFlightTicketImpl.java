package server.model.database;

import shared.transferobjects.*;

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
                PreparedStatement statement = connection.prepareStatement("select * from flights join myFlightTicket mFT on flights.flightID = mFT.flightID join passenger p on mFT.passengerid = p.passengerid join seat s on s.seatid = mFT.seatid join planeType pT on pT.planeID = flights.planeID join Departure D on D.DepartureID = flights.DepartureID join Arrival A on A.ArrivalID = flights.ArrivalID where p.passengerID = ?  ");
                statement.setInt(1,passengerID);
                ResultSet resultSet = statement.executeQuery();

                ArrayList<myFlightTicket> myFlightTickets = new ArrayList<>();
                while (resultSet.next()) {

                    int flightID = resultSet.getInt("flightid");
                    String flightName = resultSet.getString("flightName");
                    int price = resultSet.getInt("price");
                    //ny table her.
                    String planeType = resultSet.getString("planeTypes");
                    int planeID = resultSet.getInt("planeid");

                    int depatureID = resultSet.getInt("departureid");
                    String departure = resultSet.getString("departures");
                    Timestamp depatureDate = resultSet.getTimestamp("departuredate");

                    int arrivalID = resultSet.getInt("arrivalid");
                    Timestamp arrivaldate = resultSet.getTimestamp("arrivaldate");
                    String arrival = resultSet.getString("arrivals");

                    int ticketid = resultSet.getInt("ticketid");

                    String FirstName = resultSet.getString("FirstName");
                    String LastName = resultSet.getString("LastName");
                    String TelNumber = resultSet.getString("TelNumber");
                    String email = resultSet.getString("email");


                    int seatId = resultSet.getInt("seatid");
                    String seatNumber = resultSet.getString("seatNumber");
                    String classtype = resultSet.getString("classType");
                    myFlightTicket myFlightTicket = new myFlightTicket(ticketid,new Passenger(passengerID,FirstName,LastName,TelNumber,email),new flights(flightID,flightName,new Depature(depatureID,departure,depatureDate),new Arrival(arrivalID,arrival,arrivaldate),new PlaneType(planeID,planeType),price),new Seat(seatId,seatNumber,classtype));

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
                PreparedStatement statement = connection.prepareStatement(" insert into myFlightTicket(flightID, passengerID, seatID) VALUES (?,?,?)");

                System.out.println( "database connection til createticket");

                statement.setInt(1, myFlightTicket.getFlights().getFlightID());
                statement.setInt(2, myFlightTicket.getPassenger().getPassengerID());
                statement.setInt(3, myFlightTicket.getSeat().getSeatID());

                statement.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
