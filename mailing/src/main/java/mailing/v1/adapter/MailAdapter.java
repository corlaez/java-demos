package mailing.v1.adapter;

import java.util.List;

/**
 * Created by jarma on 4/24/2017.
 */
public interface MailAdapter {
    void sendPlain(String subject, String body, String toMail);
    void sendHtml(String subject, String body, String toMail);
    void sendEachPlain(String subject, String body, List<String> toMails);
    void sendEachHtml(String subject, String body, List<String> toMails);
    String getServerName();
    void endSession();
}
