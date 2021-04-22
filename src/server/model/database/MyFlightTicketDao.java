package server.model.database;

import shared.transferobjects.myFlightTicket;

import java.util.List;

public interface MyFlightTicketDao {

    List<myFlightTicket> ReadFlightList();
    void createTicket(myFlightTicket myFlightTicket);

}
