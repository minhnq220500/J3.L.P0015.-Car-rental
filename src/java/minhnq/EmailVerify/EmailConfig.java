/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhnq.EmailVerify;

import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import minhnq.dtos.UserDTO;

/**
 *
 * @author Ticket 1
 */
public class EmailConfig {

    public String genCode() {
        String SALTCHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 6) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

    public void sendEmail(String email, String code) throws AddressException, MessagingException {
        Properties pr = new Properties();
        pr.setProperty("mail.smtp.host", "smtp.gmail.com");
        pr.setProperty("mail.smtp.port", "587");
        pr.setProperty("mail.smtp.auth", "true");
        pr.setProperty("mail.smtp.starttls.enable", "true");
        pr.put("mail.smtp.socketFactory.port", "587");
        pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        //get session to authenticate the host email address and password
        Session session = Session.getInstance(pr, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("minhdragon225@gmail.com", "peternguyen2205");
            }
        });

        Message mess = new MimeMessage(session);

        //set from email address
        mess.setFrom(new InternetAddress("minhdragon225@gmail.com"));
        //set to email address or destination email address
        mess.setRecipient(Message.RecipientType.TO, new InternetAddress(email));

        //set email subject
        mess.setSubject("User Email Verification");

        //set message text
        mess.setText("Registered successfully.Please verify your account using this code: " + code);
        //send the message
        Transport.send(mess);
    }
}
