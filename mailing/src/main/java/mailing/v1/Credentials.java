package mailing.v1;

import mailing.v1.adapter.GmailAdapter;
import mailing.v1.adapter.JavaxAdapter;
import mailing.v1.adapter.OzuAdapter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by jarma on 4/24/2017.
 */
public class Credentials extends JFrame {
    //todo save Preferences *(API)
    //todo config ozuAdaper
    //todo check why google doesnt work
    JComboBox smtpServer;
    JTextField mail;
    JPasswordField password;
    JButton login;
    Compose mailFrame;

    public Credentials(){
        System.out.println("new Credentials");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                if(mailFrame == null || !mailFrame.isVisible()){
                    System.exit(0);
                }
            }
        });
        setTitle("Enter Credentials");

        add(Box.createRigidArea(new Dimension(200,10)));

        add(new JLabel("Server"));
        smtpServer = new JComboBox(
                new String [] {OzuAdapter.SERVER_NAME, GmailAdapter.SERVER_NAME});
        smtpServer.setPreferredSize(new Dimension(200,20));
        add(smtpServer);

        add(new JLabel("Email address"));
        mail = new JTextField();
        mail.setPreferredSize(new Dimension(200,20));
        add(mail);

        add(new JLabel("Password"));
        password = new JPasswordField();
        password.setPreferredSize(new Dimension(200,20));
        add(password);

        login = new JButton("Login");
        login.addActionListener(this::login);
        add(login);


        setSize(new Dimension(250, 250));
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void login(ActionEvent actionEvent) {
        String email = mail.getText();
        String password = new String(this.password.getPassword());
        if(email.isEmpty() || password.isEmpty() )
            return;
        //frame handling
        if (mailFrame == null)
            mailFrame = new Compose(this);
        mailFrame.setLocation(getX(), getY());
        mailFrame.setVisible(true);
        setVisible(false);
        //instantiate email
        String server = smtpServer.getSelectedItem().toString();
        mailFrame.setMailAdapter(JavaxAdapter.build(server, email, password));
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        password.setText("");
    }

    public static void main(String ... vargs) {
        System.out.println("v1 init");
        new Credentials();
    }
}
