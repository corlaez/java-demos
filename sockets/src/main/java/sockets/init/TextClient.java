package sockets.init;

import sockets.SocketUtil;

import javax.swing.*;

/**
 * Created by Local_admin on 4/21/2017.
 */
public class TextClient extends JFrame {
    JTextArea txtArea;
    JTextField txtMensaje;
    JButton btnEnviar;
    JButton btnEnviarFile;
    SocketUtil socketUtil= new SocketUtil();

    public TextClient(int localPort, String remoteHost, int remotePort) {
        setLayout(null);
        setTitle("" + localPort);

        txtArea = new JTextArea();
        txtArea.setBounds(10,10,300,300);
        add(txtArea);


        txtMensaje = new JTextField();
        txtMensaje.setBounds(10,320,300,20);
        add(txtMensaje);

        btnEnviar = new JButton("Enviar");
        btnEnviar.addActionListener(e -> {
            socketUtil.send(remoteHost, remotePort, txtMensaje, txtArea, false);
        });
        btnEnviar.setBounds(10,370,300,20);
        add(btnEnviar);

        setSize(400, 600);
        setVisible(true);
        socketUtil.listen(localPort, this::handleMessage, true);
    }

    public void handleMessage(String m){
        txtArea.append(m);
    }

    public static void main(String ...args) {
        new TextClient(9010, "127.0.0.1", 9009);
        new TextClient(9009, "127.0.0.1", 9010);
    }
}