package mailing.v1.adapter;

import lombok.SneakyThrows;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.List;

/**
 * Created by jarma on 4/25/2017.
 */
public abstract class JavaxAdapter implements MailAdapter {
    private static MailAdapter lastMailAdapter;
    private static final String bar = "******************************";
    private static final String before = bar + " BEFORE " + bar;
    private static final String after = bar +  " AFTER  " + bar;

    protected abstract Session getSession();
    protected abstract String getFromMail();

    private Transport transport;

    public static MailAdapter build(String server, String email, String password){
        //end last session if any
        if(lastMailAdapter != null)
            lastMailAdapter.endSession();
        //instantiate and record
        if (server == OzuAdapter.SERVER_NAME)
            lastMailAdapter = new OzuAdapter(email, password);
        else if (server == GmailAdapter.SERVER_NAME)
            lastMailAdapter = new GmailAdapter(email, password);
        else
            throw new RuntimeException("Invalid Server Selected.");
        //return
        return lastMailAdapter;
    }

    @SneakyThrows
    public void sendHtml(String subject, String body, String toMail) {
        System.out.println("sending from: " + getFromMail());
        Message msg = buildMessage(subject, toMail);
        msg.setContent(body, "text/html");
        System.out.println(before);
        Transport.send(msg);
        System.out.println(after);
//        if(transport == null)
//            transport = getSession().getTransport("smtp");
//        if (!transport.isConnected())
//            transport.connect();
//        msg.saveChanges();
//        transport.sendMessage(msg, msg.getAllRecipients());
        System.out.println("Done");
    }

    @SneakyThrows
    public void sendPlain(String subject, String body, String toMail) {
        System.out.println("sending from: " + getFromMail());
        Message msg = buildMessage(subject, toMail);
        msg.setText(body);
        System.out.println(before);
        Transport.send(msg);
        System.out.println(after);
//        if(transport == null)
//            transport = getSession().getTransport("smtp");
//        if (!transport.isConnected())
//            transport.connect();
//        msg.saveChanges();
//        transport.sendMessage(msg, msg.getAllRecipients());
        System.out.println("Done");
    }

    @SneakyThrows
    private Message buildMessage(String subject, String toMail) {
        Message msg = new MimeMessage(getSession());
        msg.setFrom(new InternetAddress("iaARmandonoST"));
        msg.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(toMail,false));
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        return msg;
    }

    @SneakyThrows
    public void endSession(){
        if(transport != null)
            transport.close();
    }


    @SneakyThrows
    public void sendHtml(String subject, String body, List<String> toMails) {
        for (String toMail : toMails) {
            System.out.println("sending from: " + getFromMail());
            Message msg = buildMessage(subject, toMail);
            msg.setContent(body, "text/html");
            System.out.println(before);
            Transport.send(msg);
            System.out.println(after);
//        if(transport == null)
//            transport = getSession().getTransport("smtp");
//        if (!transport.isConnected())
//            transport.connect();
//        msg.saveChanges();
//        transport.sendMessage(msg, msg.getAllRecipients());
        }
        System.out.println("Done");
    }

}