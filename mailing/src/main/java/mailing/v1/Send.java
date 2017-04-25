package mailing.v1;

import lombok.experimental.var;
import serialize.csv.CSVApi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by jarma on 4/24/2017.
 */
public class Send extends JFrame {
    JTextArea sendToArea;
    JButton sendButton;
    CSVApi csvApi = new CSVApi(this);

    public Send(Consumer<ActionEvent> sendAction) {
        System.out.println("new Send");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                setVisible(false);
            }
        });
        setTitle("Send To");

        add(Box.createRigidArea(new Dimension(200, 10)));

        add(new JLabel("One mail per line"));
        sendToArea = new JTextArea();
        var textArea = new JScrollPane(sendToArea);
        textArea.setPreferredSize(new Dimension(200, 300));
        add(textArea);

        sendButton = new JButton("Import");
        sendButton.addActionListener(ae -> this.importCSV());
        add(sendButton);

        sendButton = new JButton("Send");
        sendButton.addActionListener(ae -> sendAction.accept(ae));
        add(sendButton);

        setSize(new Dimension(250, 450));
        setResizable(false);
        setVisible(false);
    }

    public void importCSV(){
        var list = csvApi.simpleReadFromFile();
        if(list == null)
            return;
        for (String e: list) {
            sendToArea.append("\n" + e);
        }
    }

    public List<String> buildAddressList() {
        var list = Arrays.asList(sendToArea.getText().split("\n"));
        System.out.println(list);
        return list;
    }
}
