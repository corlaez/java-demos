package sockets.init;

import sockets.SocketUtil;

import javax.swing.*;

/**
 * Created by Local_admin on 4/21/2017.
 */
public class FrmServidor extends JFrame {
    JTextArea txtArea;
    SocketUtil socketUtil= new SocketUtil();

    public FrmServidor(int localPort) {
        setLayout(null);
        setTitle("escucha local: " + localPort);

        txtArea = new JTextArea();
        txtArea.setBounds(10,10,300,300);
        add(txtArea);

        setSize(400, 800);
        setVisible(true);
        socketUtil.listen(localPort, this::handleMessage, true);
    }

    public void handleMessage(String m){
        txtArea.append(m);
    }

    public static void main(String ...args) {
        new FrmServidor(9009);
    }
}