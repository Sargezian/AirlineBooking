package client.views.createUser;

import client.core.ClientFactory;
import client.core.ModelFactory;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.model.database.InputUserDao;
import server.model.database.InputUserImpl;
import server.model.database.ResetDao;
import server.model.database.ResetImpl;
import shared.transferobjects.InputUser;

import static org.junit.jupiter.api.Assertions.assertEquals;

 public class createUserViewModelTest
{

    private createUserViewModel createUserViewModel;
    private InputUserDao CreateDao;
    private ResetDao resetDao;
    private StringProperty username;
    private StringProperty password;
    private StringProperty label;

    @BeforeEach
    public void setUp(){
        ClientFactory.getInstance().getClient();
        createUserViewModel = new createUserViewModel(ModelFactory.getInstance().getClientText());
        CreateDao = InputUserImpl.getInstance();
        resetDao = new ResetImpl();
        resetDao.reset();
        username = new SimpleStringProperty();
        password = new SimpleStringProperty();
        label = new SimpleStringProperty();
        username.bindBidirectional(createUserViewModel.createUserProperty());
        password.bindBidirectional(createUserViewModel.createPasswordProperty());
        label.bindBidirectional(createUserViewModel.errorProperty());

    }

    @Test
    public void testCreateUserWithLessThen3characters(){

        username.setValue("Usw");
        password.setValue("password1");

        createUserViewModel.validateSignUp();

        assertEquals("Username must contain more than 3 characters",label.get());
    }


    @Test
    public void testCreateUserWithMoreThen15characters(){

        username.setValue("sdsasdsasdsasdsa");
        password.setValue("password1");

        createUserViewModel.validateSignUp();

        assertEquals("Username must contain less than 15 characters",label.get());
    }

    @Test
    public void testCreatePasswordWith7characters(){

        username.setValue("User");
        password.setValue("pass123");

        createUserViewModel.validateSignUp();

        assertEquals("Password length must be 8 or more",label.get());
    }


    @Test
    public void testCreatePasswordWith15characters(){

        username.setValue("User");
        password.setValue("pass12345678912");

        createUserViewModel.validateSignUp();

        assertEquals("Password length must be 14 or less",label.get());
    }

    @Test
    public void testCreatePasswordWithNoNumbers(){

        username.setValue("User");
        password.setValue("password");

        createUserViewModel.validateSignUp();

        assertEquals("Password must contain at least one number",label.get());


    }

    @Test
    public void testIfCreateUserAndCreatePasswordCanContainASymbols(){

        username.setValue("User#");
        password.setValue("password1#");

        createUserViewModel.validateSignUp();

        assertEquals("Username cannot contain #",label.get());


    }

    @Test
    public void testIfCreateUserAndPasswordCanBeNull(){
        username.setValue(null);
        password.setValue(null);

        createUserViewModel.validateSignUp();



        assertEquals("Username cannot be empty",label.get());

    }

    @Test
    public void testIfCreateUserAlreadyExists(){
        username.setValue("Test");
        password.setValue("Test1234");

        InputUser test = new InputUser("Test","Test1234");
        CreateDao.createUser(test.getOutput(), test.getPassword());

        createUserViewModel.validateSignUp();


        assertEquals("Username already exist",label.get());



    }


    @Test
    public void testIfYouCanSignUpSuccessfully(){
        username.setValue("Test");
        password.setValue("Test1234");


        createUserViewModel.validateSignUp();


        assertEquals("successful",label.get());



    }



















}