package mailing.v1.adapter;

import com.sun.mail.smtp.SMTPAddressFailedException;
import lombok.SneakyThrows;

import javax.mail.Message;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.List;

/**
 * Created by jarma on 4/25/2017.
 */
public abstract class SingleTransportJavaxAdapter implements MailAdapter {
    private static final String bar = "******************************";
    private static final String before = bar + " BEFORE " + bar;
    private static final String after = bar + " AFTER  " + bar;

    protected abstract Session getSession();

    protected abstract String getFromMail();

    private Transport transport;

    @SneakyThrows
    public void sendHtml(String subject, String body, String toMail) {
        System.out.println("sending from: " + getFromMail());
        Message msg = buildMessage(subject);
        msg.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(toMail, false));
        msg.setContent(body, "text/html");
        send(msg);
    }

    @SneakyThrows
    public void sendPlain(String subject, String body, String toMail) {
        System.out.println("sending from: " + getFromMail());
        Message msg = buildMessage(subject);
        msg.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(toMail, false));
        msg.setText(body);
        send(msg);
    }

    @SneakyThrows
    private Message buildMessage(String subject) {
        Message msg = new MimeMessage(getSession());
        msg.setFrom(new InternetAddress("iaARmando"));
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        return msg;
    }

    @SneakyThrows
    public void endSession() {
        if (transport != null)
            transport.close();
    }


    @SneakyThrows
    public void sendEachHtml(String subject, String body, List<String> toMails) {
        Message msg = buildMessage(subject);
        msg.setContent(body, "text/html");
        for (String toMail : toMails) {
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toMail, false));
            msg.setSentDate(new Date());
            send(msg);
        }
        System.out.println("Done" + bar + bar);
    }

    @SneakyThrows
    public void sendEachPlain(String subject, String body, List<String> toMails) {
        if (toMails == null || toMails.isEmpty())
            return;
        int minimun = 4;
        int maxVariance = 8;
        Message msg = buildMessage(subject);
        msg.setText(body);
        for (String toMail : toMails) {
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toMail, false));
            msg.setSentDate(new Date());
            send(msg);
            long milisWait = (minimun + (System.currentTimeMillis() % (maxVariance + 1))) * 100;
            System.out.println("wait " + milisWait + " ms.");
            Thread.sleep(milisWait);
        }
        System.out.println("Done with " + toMails.size() + "elements. " + bar + bar + bar);
    }

    @SneakyThrows
    private int send(Message msg) {
        try {
            System.out.println(before);
            if (msg.getAllRecipients() == null || msg.getAllRecipients().length == 0)
                return 0;
            if (transport == null)
                transport = getSession().getTransport("smtp");
            if (!transport.isConnected())
                transport.connect();
            msg.saveChanges();
            transport.sendMessage(msg, msg.getAllRecipients());
            System.out.println(after);
            return 0;
        }
        catch (SMTPAddressFailedException sfe) {
            System.out.println("SMTPAddressFailed");
            System.out.println(after);
            return 1;
        }
        catch (Exception sfe) {
            sfe.printStackTrace();
            System.out.println(after);
            return -1;
        }
    }
}