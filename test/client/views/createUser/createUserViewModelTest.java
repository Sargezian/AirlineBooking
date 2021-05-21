package client.views.createUser;

import client.core.ClientFactory;
import client.core.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import server.model.database.InputUserDao;
import server.model.database.InputUserImpl;

public class createUserViewModelTest
{
    private createUserViewModel createUserVM;
    private InputUserDao inputUserDao;

    @BeforeEach
    public void setup(){
        ClientFactory.getInstance().getClient();
        createUserVM = new createUserViewModel(ModelFactory.getInstance().getClientText());
        inputUserDao = InputUserImpl.getInstance();
    }











}