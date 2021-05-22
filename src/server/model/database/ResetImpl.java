package server.model.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ResetImpl implements ResetDao
{




  public void reset() {
      try(Connection connection = daoConnection.getConnection())
      {
        PreparedStatement statement = connection.prepareStatement("DROP SCHEMA IF EXISTS Sep2 CASCADE;\n" +
                "\n" +
                "CREATE SCHEMA Sep2;\n" +
                "SET SCHEMA 'sep2';\n" +
                "\n" +
                "CREATE TABLE InputUser\n" +
                "(\n" +
                "    id       SERIAL      NOT NULL PRIMARY KEY,\n" +
                "    user_    VARCHAR(20) NOT NULL,\n" +
                "    password VARCHAR(20) NOT NULL\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE Rating\n" +
                "(\n" +
                "    star NUMERIC,\n" +
                "    primary key (star)\n" +
                ");\n" +
                "\n" +
                "\n" +
                "CREATE TABLE InputChat\n" +
                "(\n" +
                "    chat VARCHAR(3000) NOT NULL,\n" +
                "    star NUMERIC,\n" +
                "    FOREIGN KEY (star) REFERENCES Rating (star)\n" +
                ");\n" +
                "\n" +
                "\n" +
                "CREATE TABLE airport\n" +
                "(\n" +
                "    airportID CHAR(3) NOT NULL PRIMARY KEY,\n" +
                "    Name      VARCHAR(40),\n" +
                "    City      VARCHAR(40)\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE Departure\n" +
                "(\n" +
                "    DepartureID   SERIAL    NOT NULL PRIMARY KEY,\n" +
                "    departures    VARCHAR   NOT NULL,\n" +
                "    Departuredate timestamp NOT NULL,\n" +
                "    FOREIGN KEY (departures) REFERENCES airport (airportID)\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE Arrival\n" +
                "(\n" +
                "    ArrivalID   SERIAL    NOT NULL PRIMARY KEY,\n" +
                "    arrivals    VARCHAR   NOT NULL,\n" +
                "    Arrivaldate timestamp NOT NULL,\n" +
                "    FOREIGN KEY (arrivals) REFERENCES airport (airportID)\n" +
                "\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE payment\n" +
                "(\n" +
                "    PaymentID      SERIAL      NOT NULL PRIMARY KEY,\n" +
                "    CardholderName VARCHAR(20) NOT NULL,\n" +
                "    CardNumber     VARCHAR(20) NOT NULL,\n" +
                "    CVV            VARCHAR(3)  NOT NULL,\n" +
                "    ExpirationDate VARCHAR     NOT NULL\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE planeType\n" +
                "(\n" +
                "    planeID    SERIAL      NOT NULL PRIMARY KEY,\n" +
                "    planeTypes VARCHAR(50) NOT NULL\n" +
                "\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE flights\n" +
                "(\n" +
                "    flightID    VARCHAR NOT NULL PRIMARY KEY,\n" +
                "    flightName  VARCHAR NOT NULL,\n" +
                "    ArrivalID   SERIAL  NOT NULL,\n" +
                "    DepartureID SERIAL  NOT NULL,\n" +
                "    price       varchar not null,\n" +
                "    planeID     SERIAL,\n" +
                "    FOREIGN KEY (DepartureID) REFERENCES Departure (DepartureID),\n" +
                "    FOREIGN KEY (ArrivalID) REFERENCES Arrival (ArrivalID),\n" +
                "    FOREIGN KEY (planeID) REFERENCES planeType (planeID)\n" +
                ");\n" +
                "\n" +
                "\n" +
                "CREATE TABLE seat\n" +
                "(\n" +
                "    seatID     SERIAL      NOT NULL PRIMARY KEY,\n" +
                "    seatNumber VARCHAR(20) NOT NULL,\n" +
                "    classType  VARCHAR(20) NOT NULL CHECK ( classType LIKE 'Economy class' OR classType LIKE 'Business class' OR\n" +
                "                                            classType LIKE 'First class'),\n" +
                "    planeID     SERIAL,\n" +
                "    FOREIGN KEY (planeID) REFERENCES planeType (planeID)\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE passenger\n" +
                "(\n" +
                "    passengerID SERIAL      NOT NULL PRIMARY KEY,\n" +
                "    FirstName   VARCHAR(20) NOT NULL,\n" +
                "    LastName    VARCHAR(20) NOT NULL,\n" +
                "    TelNumber   VARCHAR     NOT NULL,\n" +
                "    email       VARCHAR     NOT NULL CHECK (email LIKE '%@%' )\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE myFlightTicket\n" +
                "(\n" +
                "    ticketID    SERIAL NOT NULL PRIMARY KEY,\n" +
                "    flightID    VARCHAR,\n" +
                "    passengerID INTEGER,\n" +
                "    seatID      INTEGER,\n" +
                "    id          Integer,\n" +
                "    CONSTRAINT UcTicket UNIQUE (flightID, seatID),\n" +
                "    FOREIGN KEY (id) REFERENCES InputUser (id),\n" +
                "    FOREIGN KEY (flightID) REFERENCES flights (flightID),\n" +
                "    FOREIGN KEY (passengerID) REFERENCES passenger (passengerID),\n" +
                "    FOREIGN KEY (seatID) REFERENCES seat (seatID)\n" +
                ");\n" +
                "\n" +
                "INSERT INTO airport(airportID, Name, City)\n" +
                "VALUES ('ALL', 'Aalborg Lufthavn', 'Aalborg');\n" +
                "INSERT INTO airport(airportID, Name, City)\n" +
                "VALUES ('MTJ', 'Midtjylland Lufthavn', 'Midtjylland');\n" +
                "INSERT INTO airport(airportID, Name, City)\n" +
                "VALUES ('AAR', 'Aarhus Lufthavn', 'Aarhus');\n" +
                "INSERT INTO airport(airportID, Name, City)\n" +
                "VALUES ('BIL', 'Billund Lufthavn', 'Billund');\n" +
                "INSERT INTO airport(airportID, Name, City)\n" +
                "VALUES ('SDB', 'Sønderborg Lufthavn', 'Sønderborg');\n" +
                "INSERT INTO airport(airportID, Name, City)\n" +
                "VALUES ('KBH', 'Københavns Lufthavn', 'København');\n" +
                "\n" +
                "INSERT INTO Departure(departures, Departuredate)\n" +
                "VALUES ('ALL', '2021-06-06 17:30:00');\n" +
                "INSERT INTO Departure(departures, Departuredate)\n" +
                "VALUES ('MTJ', '2021-07-07 18:30:00');\n" +
                "INSERT INTO Departure(departures, Departuredate)\n" +
                "VALUES ('AAR', '2021-08-08 19:30:00');\n" +
                "INSERT INTO Departure(departures, Departuredate)\n" +
                "VALUES ('BIL', '2021-06-06 08:30:00');\n" +
                "INSERT INTO Departure(departures, Departuredate)\n" +
                "VALUES ('SDB', '2021-07-07 09:30:00');\n" +
                "INSERT INTO Departure(departures, Departuredate)\n" +
                "VALUES ('KBH', '2021-08-08 10:30:00');\n" +
                "\n" +
                "INSERT INTO Arrival(arrivals, Arrivaldate)\n" +
                "VALUES ('BIL', '2021-06-06 18:30:00');\n" +
                "INSERT INTO Arrival(arrivals, Arrivaldate)\n" +
                "VALUES ('SDB', '2021-07-07 19:30:00');\n" +
                "INSERT INTO Arrival(arrivals, Arrivaldate)\n" +
                "VALUES ('KBH', '2021-08-08 20:30:00');\n" +
                "INSERT INTO Arrival(arrivals, Arrivaldate)\n" +
                "VALUES ('ALL', '2021-06-06 09:30:00');\n" +
                "INSERT INTO Arrival(arrivals, Arrivaldate)\n" +
                "VALUES ('MTJ', '2021-07-07 10:30:00');\n" +
                "INSERT INTO Arrival(arrivals, Arrivaldate)\n" +
                "VALUES ('AAR', '2021-08-08 11:30:00');\n" +
                "\n" +
                "INSERT INTO planeType (planeTypes)\n" +
                "VALUES ('Airbus1');\n" +
                "INSERT INTO planeType (planeTypes)\n" +
                "VALUES ('Airbus2');\n" +
                "INSERT INTO planeType (planeTypes)\n" +
                "VALUES ('Airbus3');\n" +
                "INSERT INTO planeType (planeTypes)\n" +
                "VALUES ('Airbus4');\n" +
                "INSERT INTO planeType (planeTypes)\n" +
                "VALUES ('Airbus5');\n" +
                "INSERT INTO planeType (planeTypes)\n" +
                "VALUES ('Airbus6');\n" +
                "\n" +
                "INSERT INTO flights (flightid, flightName, price)\n" +
                "VALUES ('B6624', 'SAS', 400);\n" +
                "INSERT INTO flights (flightid, flightName, price)\n" +
                "VALUES ('DL5841', 'Lufthansa', 200);\n" +
                "INSERT INTO flights (flightid, flightName, price)\n" +
                "VALUES ('DL1149', 'Air France', 500);\n" +
                "INSERT INTO flights (flightid, flightName, price)\n" +
                "VALUES ('G4529', 'JetBlue', 600);\n" +
                "INSERT INTO flights (flightid, flightName, price)\n" +
                "VALUES ('AA1522', 'RyanAir', 700);\n" +
                "INSERT INTO flights (flightid, flightName, price)\n" +
                "VALUES ('AA15D2', 'SAS', 400);\n" +
                "\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('F1', 'Business class',1);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('F2', 'Business class',2);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('F3', 'Business class',3);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('J1', 'First class',4);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('J2', 'First class',5);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('J3', 'First class',6);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('L1', 'Economy class',1);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('L2', 'Economy class',2);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('L3', 'Economy class',3);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('W1', 'Business class',4);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('W2', 'Business class',5);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('W3', 'Business class',6);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('Q1', 'First class',1);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('Q2', 'First class',2);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('Q3', 'First class',3);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('P1', 'Economy class',4);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('P2', 'Economy class',5);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('P3', 'Economy class',6);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('K1', 'Business class',1);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('K2', 'Business class',2);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('K3', 'Business class',3);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('C1', 'First class',4);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('C2', 'First class',5);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('C3', 'First class',6);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('V1', 'Economy class',1);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('V2', 'Economy class',2);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('V3', 'Economy class',3);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('X1', 'Business class',4);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('X2', 'Business class',5);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('X3', 'Business class',6);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('M1', 'First class',1);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('M2', 'First class',2);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('M3', 'First class',3);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('U1', 'Economy class',4);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('U2', 'Economy class',5);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('U3', 'Economy class',6);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('Y1', 'Business class',1);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('Y2', 'Business class',2);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('Y3', 'Business class',3);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('T1', 'First class',4);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('T2', 'First class',5);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('T3', 'First class',6);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('R1', 'Economy class',1);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('R2', 'Economy class',2);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('R3', 'Economy class',3);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('B1', 'Business class',4);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('B2', 'Business class',5);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('B3', 'Business class',6);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('A1', 'First class',1);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('A2', 'First class',2);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('A3', 'First class',3);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('E3', 'Economy class',4);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('E2', 'Economy class',5);\n" +
                "INSERT INTO seat (seatNumber, classType, planeID)\n" +
                "VALUES ('E1', 'Economy class',6);\n" +
                "\n" +
                "insert into Rating values (1);\n" +
                "insert into Rating values (2);\n" +
                "insert into Rating values (3);\n" +
                "insert into Rating values (4);\n" +
                "insert into Rating values (5);\n" +
                "\n");
        statement.execute();
      }
      catch (SQLException throwables)
      {
        throwables.printStackTrace();
      }
    }
  }

