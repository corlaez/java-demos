package mailing.v1.adapter;


import lombok.AccessLevel;
import lombok.Getter;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import java.util.Properties;

/**
 * Created by jarma on 4/24/2017.
 */
@Getter(AccessLevel.PROTECTED)
public class OzuAdapter extends SingleTransportJavaxAdapter {
    public static final String SERVER_NAME = "OZUAPP";

    Session session;
    String fromMail;

    public OzuAdapter(String fromMail, String password) {
        System.out.println("new OzuAdapter");
        Properties props = System.getProperties();
        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "mail.ozuapp.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.debug", "true");
        props.put("mail.debug.auth", "true");
        props.put("mail.transport.protocol", "smtp");

        session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(fromMail, password);
                    }
                });
        this.fromMail = fromMail;
    }

    @Override
    public String getServerName() {
        return SERVER_NAME;
    }
}
