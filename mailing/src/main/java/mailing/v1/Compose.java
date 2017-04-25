package mailing.v1;

import mailing.v1.adapter.MailAdapter;

import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

/**
 * Created by jarma on 4/24/2017.
 */
public class Compose extends JFrame {
    JTextField subject;
    JTextArea body;
    JComboBox contentType;
    JButton send;
    MailAdapter mailAdapter;
    Send sendFrame;

    public Compose(JFrame parent) {
        System.out.println("new Compose");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                askToSaveState();
                if(mailAdapter != null)
                    mailAdapter.endSession();
                parent.setLocation(getX(), getY());
                parent.setVisible(true);
                if(sendFrame != null)
                    sendFrame.setVisible(false);
                super.windowClosing(e);
            }
        });
        setTitle("Compose Mail");

        add(Box.createRigidArea(new Dimension(200, 10)));

        add(new JLabel("Subject"));
        subject = new JTextField();
        subject.setPreferredSize(new Dimension(200, 20));
        add(subject);

        add(new JLabel("Message"));
        body = new JTextArea();
        body.setPreferredSize(new Dimension(200, 300));
        add(body);

        contentType = new JComboBox(new String[]{"TEXTO PLANO", "TEXTO HTML"});
        add(contentType);

        send = new JButton("Send To");
        send.addActionListener(ae -> sendFrame());
        add(send);

        setSize(new Dimension(250, 500));
        setResizable(false);
    }

    private void sendFrame() {
        if(this.sendFrame == null)
            sendFrame = new Send(ae -> sendList());
        sendFrame.setLocation(getX() + getWidth() - 5, getY());
        sendFrame.setVisible(true);
    }

    private void sendList() {
        List<String> toMails = sendFrame.buildAddressList();
        String subject = this.subject.getText();
        String body = this.body.getText();
        if (contentType.getSelectedIndex() == 0) {
            mailAdapter.sendEachPlain(subject, body, toMails);
        } else {
            mailAdapter.sendEachHtml(subject, body, toMails);
        }
    }

    private void send(ActionEvent actionEvent) {
        String subject = this.subject.getText();
        String body = this.body.getText();
        String toMail = "armanpela@gmail.com";
        if (contentType.getSelectedIndex() == 0) {
            mailAdapter.sendPlain(subject, body, toMail);
        } else {
            mailAdapter.sendHtml(subject, body, toMail);
        }
    }

    public void setMailAdapter(MailAdapter mailAdapter) {
        if(this.mailAdapter != null)
            mailAdapter.endSession();
        this.mailAdapter = mailAdapter;
        setTitle("Send " + mailAdapter.getServerName());
    }

    private void askToSaveState() {
        int reply = JOptionPane.showConfirmDialog(
                Compose.this,
                "Do you want to save this message and senders?",
                "Save",
                JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {}
        else {
            body.setText("");
            subject.setText("");
            contentType.setSelectedIndex(0);
            if(sendFrame != null)
                sendFrame.sendToArea.setText("");
        }
    }
}
