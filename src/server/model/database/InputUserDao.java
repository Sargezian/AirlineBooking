package server.model.database;

import shared.transferobjects.InputUser;

import java.util.List;

public interface InputUserDao {

    InputUser createUser(String user, String password) ;
    List<InputUser> readUser();
    InputUser readUser(String user,String password);
   boolean ValidateUser(String user, String password) ;
    InputUser readUsername(String user);


}
