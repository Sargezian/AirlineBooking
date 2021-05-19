package server.model.database;

import shared.transferobjects.InputUser;

import java.util.List;

public interface InputUserDao {

    List<InputUser> readUser();

    InputUser createUser(String user, String password) ;
    InputUser readUser(String user,String password);
    InputUser readUsername(String user);

    boolean ValidateUser(String user, String password) ;


}
