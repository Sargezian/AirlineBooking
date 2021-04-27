package server.model.database;

import shared.transferobjects.InputUser;

import java.util.List;

public interface InputUserDao {

    InputUser createUser(String user, String password) ;
    List<InputUser> readUser();

   boolean ValidateUser(String user, String password) ;


}
