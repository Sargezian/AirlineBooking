package server.model.database;

import shared.transferobjects.Arrival;
import shared.transferobjects.Depature;
import shared.transferobjects.Flights;
import shared.transferobjects.PlaneType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class adminImpl implements adminDao {

    private static adminImpl daoInstance;
    private daoConnection daoconnection;


    public static synchronized adminImpl getInstance(){

        if (daoInstance == null){
            daoInstance = new adminImpl();
        }
        return daoInstance;
    }



    @Override
    public Flights CreateFlights(String flightID, String flightName, String price ) {
        try {
            try (Connection connection = daoConnection.getConnection()) {
                PreparedStatement statement = connection.prepareStatement("INSERT INTO flights(flightID,flightName,price) VALUES (?,?,?)");

                //flights


                statement.setString(1,flightID);
                statement.setString(2,flightName);
                statement.setString(3,price);

                statement.executeUpdate();
                return new Flights(flightID,flightName,price);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteFlight(Flights flights) {
        try {
            try (Connection connection = daoConnection.getConnection()) {
                PreparedStatement statement = connection.prepareStatement("DELETE From flights WHERE flightID = ? ");
                statement.setString(1,flights.getFlightID());
                statement.executeUpdate();

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



    @Override
    public List<Flights> getAllTheFLights() {
        try {

            try (Connection connection = daoConnection.getConnection()) {
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM flights");
                ResultSet resultSet = statement.executeQuery();

                ArrayList<Flights> flightlist = new ArrayList<>();
                while (resultSet.next()) {

                    //flight
                    String flightID = resultSet.getString("flightID");
                    String flightName = resultSet.getString("flightName");
                    String price = resultSet.getString("price");



                    Flights flights = new Flights(flightID, flightName,price);
                    flightlist.add(flights);
                }
                return flightlist;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<Arrival> getAllArrival() {
        try {

            try (Connection connection = daoConnection.getConnection()) {
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM Arrival");
                ResultSet resultSet = statement.executeQuery();

                ArrayList<Arrival> Arrivallist = new ArrayList<>();
                while (resultSet.next()) {

                    //flight
                    int arrivalId = resultSet.getInt("ArrivalID");
                    String arrivals = resultSet.getString("arrivals");
                    String arrivalDate = resultSet.getString("Arrivaldate");


                    Arrival arrival = new Arrival(arrivalId,arrivals,arrivalDate);

                    Arrivallist.add(arrival);
                }
                return Arrivallist;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<Depature> getAllDeparture() {
        try {

            try (Connection connection = daoConnection.getConnection()) {
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM Departure");
                ResultSet resultSet = statement.executeQuery();

                ArrayList<Depature> depatureArrayList = new ArrayList<>();
                while (resultSet.next()) {

                    //flight
                    int departureId = resultSet.getInt("DepartureID");
                    String departures = resultSet.getString("departures");
                    String departuredate = resultSet.getString("Departuredate");


                    Depature depature = new Depature(departureId,departures,departuredate);

                    depatureArrayList.add(depature);
                }
                return depatureArrayList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<PlaneType> getAllPlaneType() {
        try {

            try (Connection connection = daoConnection.getConnection()) {
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM planeType");
                ResultSet resultSet = statement.executeQuery();

                ArrayList<PlaneType> planeArrayList = new ArrayList<>();
                while (resultSet.next()) {

                    //flight
                    int planeID = resultSet.getInt("planeID");
                    String planeTypes = resultSet.getString("planeTypes");



                    PlaneType planeType = new PlaneType(planeID,planeTypes);

                    planeArrayList.add(planeType);
                }
                return planeArrayList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    public Arrival CreateArrival(String Arrival, String Arrivaldate) {
        try {
            try (Connection connection =  daoConnection.getConnection()) {
                PreparedStatement statement = connection.prepareStatement("INSERT INTO Arrival(arrivals,Arrivaldate) VALUES (?,?) ", PreparedStatement.RETURN_GENERATED_KEYS);

                //payment
                statement.setString(1, Arrival);
                statement.setString(2, Arrivaldate);

                statement.executeUpdate();
                ResultSet key = statement.getGeneratedKeys();

                if (key.next()) {

                    return new Arrival(key.getInt(1),Arrival,Arrivaldate);
                } else {

                    throw new SQLException("Her bliver det testet på at lave en ny passenger");

                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Depature CreateDeparture(String Departure, String DepartureDate) {
        try {
            try (Connection connection =  daoConnection.getConnection()) {
                PreparedStatement statement = connection.prepareStatement("INSERT INTO Departure(departures,Departuredate) VALUES (?,?) ", PreparedStatement.RETURN_GENERATED_KEYS);

                //payment
                statement.setString(1, Departure);
                statement.setString(2, DepartureDate);

                statement.executeUpdate();
                ResultSet key = statement.getGeneratedKeys();

                if (key.next()) {

                    return new Depature(key.getInt(1),Departure,DepartureDate);
                } else {

                    throw new SQLException("Her bliver det testet på at lave en ny passenger");

                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    @Override
    public PlaneType CreatePlane(String PlaneTypes) {
        try {
            try (Connection connection =  daoConnection.getConnection()) {
                PreparedStatement statement = connection.prepareStatement("INSERT INTO planeType(planeTypes) VALUES (?) ", PreparedStatement.RETURN_GENERATED_KEYS);

                //payment
                statement.setString(1, PlaneTypes);


                statement.executeUpdate();
                ResultSet key = statement.getGeneratedKeys();

                if (key.next()) {

                    return new PlaneType(key.getInt(1),PlaneTypes);
                } else {

                    throw new SQLException("Her bliver det testet på at lave en ny passenger");

                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

}
