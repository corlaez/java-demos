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
public class GmailAdapter extends SingleTransportJavaxAdapter {
    public static final String SERVER_NAME = "GMAIL";

    Session session;
    String fromMail;

    public GmailAdapter(String fromMail, String password) {
        System.out.println("new GmailAdapter");
//        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
//        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        Properties props = System.getProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.debug", "true");
        props.put("mail.debug.auth", "true");

//        props.setProperty("proxySet","true");
//        props.setProperty("socksProxyHost","192.168.0.21");
//        props.setProperty("socksProxyPort","1080");
//        props.setProperty("mail.smtp.host", "smtp.gmail.com");
//        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
//        props.setProperty("mail.smtp.socketFactory.fallback", "false");
//        props.setProperty("mail.smtp.port", "465");
//        props.setProperty("mail.smtp.socketFactory.port", "465");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.debug", "true");
//        props.put("mail.store.protocol", "pop3");
//        props.put("mail.transport.protocol", "smtp");

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
