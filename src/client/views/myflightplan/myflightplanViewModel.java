package client.views.myflightplan;

import client.model.ClientText;
import client.model.SaveInfo;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.transferobjects.*;
import shared.util.utils;

import javax.mail.*;
import javax.mail.internet.*;
import java.beans.PropertyChangeEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

public class myflightplanViewModel {

    private ClientText clientText;
    private ObservableList<myFlightTicket> myFlightTickets;
    private StringProperty username;
    private StringProperty print;

    public myflightplanViewModel(ClientText clientText) {
        System.out.println("myFlight view model");
        this.clientText = clientText;
        clientText.addListener(utils.NEWTICKET, this::onNewTicket);
        clientText.addListener(utils.NEWTICKET, this::setUsernameProperty);
        username = new SimpleStringProperty();
        print = new SimpleStringProperty();

    }

    public void setUsernameProperty(PropertyChangeEvent event) {
        setUsername();
    }

    public void loadMyFlights() {

        InputUser id = SaveInfo.getInstance().getUser();

        List<myFlightTicket> flight = clientText.getflightlist(id.getId());
        System.out.println("Loadmyflights " + SaveInfo.getInstance().getUser());

        myFlightTickets = FXCollections.observableArrayList(flight);
        System.out.println("loadlflights = " + flight);
        //Collections.addAll(, selectedrows);
    }

   /* public void loadPriceSUM() {
        List<myFlightTicket> pricelist = clientText.ReadPriceSUM();
        myFlightTickets = FXCollections.observableArrayList(pricelist);

    }*/




    public ObservableList<myFlightTicket> getMyFlightTickets() {
        System.out.println("myFlightTickets = " + myFlightTickets);
        return myFlightTickets;
    }



    public void onNewTicket(PropertyChangeEvent evt) {
        // getPassengerInformation(1);
        System.out.println("onNewTicket " + SaveInfo.getInstance().getUser());
        myFlightTickets.clear();
        InputUser id = SaveInfo.getInstance().getUser();

        List<myFlightTicket> getflightlist = clientText.getflightlist(id.getId());
        System.out.println("viewmodel on new passenger" + getflightlist.size());
        myFlightTickets.addAll(getflightlist);

    }

    public void setUsername(){

        InputUser user = SaveInfo.getInstance().getUser();
        clientText.readUsername(user.user);



        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                username.setValue(user.getOutput());

            }
        });


    }


    public void sendtoEmail( ) throws AddressException {

        for (myFlightTicket myFlightTicket : myFlightTickets) {

        final String username = "sep2test123@gmail.com";
        final String password = "42323087";
        String fromEmail = "sep2test123@gmail.com";
        String toEmail =  myFlightTicket.getEmail();



        System.out.println("email" );


        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");


        Session session = Session.getInstance(properties,new javax.mail.Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }
        });

        MimeMessage msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(fromEmail));
            msg.addRecipient(Message.RecipientType.TO,new InternetAddress(toEmail));
            msg.setSubject("Airline Booking");
            msg.setText("your ticket");

            Multipart emailcontent = new MimeMultipart();

            MimeBodyPart text = new MimeBodyPart();
            text.setText("Thanks for the Purchase " + myFlightTicket.getFirstName() + "!" + "\n" + "\n" + "Kære " + myFlightTicket.getFirstName() + " " + myFlightTicket.getLastName() + "\n" + "\n" +
                    "Du har succesfuldt booket en flybillet fra " + myFlightTicket.getFlightName() + ". Vi venter på dig på " + myFlightTicket.getArrivals() + " på " + myFlightTicket.getArrivalDate() + "." + "\n" +"\n" +
                    "Tak fordi du valgte os, og vi ser frem til at møde dig!" + "\n" + "\n" + "Airline booking.");




            MimeBodyPart pdf = new MimeBodyPart();
            Path relativePath1 = Paths.get("src", "myT.pdf");
            pdf.attachFile(String.valueOf(relativePath1));

            emailcontent.addBodyPart(text);
            emailcontent.addBodyPart(pdf);

            msg.setContent(emailcontent);

            Transport.send(msg);

            print.setValue("The ticket has been sent to your email " + myFlightTicket.getEmail());


            System.out.println("sent message");
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
        }

    }

    public void clearLabel(){

        print.setValue(null);

    }


    public String getPrint() {
        return print.get();
    }

    public StringProperty printProperty() {
        return print;
    }


    public String getUsername() {
        return username.get();
    }

    public StringProperty usernameProperty() {
        return username;
    }


}