package server.model.database;

import shared.transferobjects.InputUser;

import java.util.List;

public interface InputUserDao {

    InputUser createUser(String txt) ;
    List<InputUser> readUser();


}
