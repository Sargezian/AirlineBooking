package Server.model.database;


import org.junit.jupiter.api.Test;
import server.model.database.daoConnection;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class daoConnectionTest {


    @Test
    public void testDatabaseConnection() throws SQLException {

        Connection connection = daoConnection.getConnection();
        assertTrue(connection.isValid(0));
        connection.close();
    }


}