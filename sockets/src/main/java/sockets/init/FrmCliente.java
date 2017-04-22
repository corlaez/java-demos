package sockets.init;

import sockets.SocketUtil;

import javax.swing.*;

/**
 * Created by Local_admin on 4/21/2017.
 */
public class FrmCliente extends JFrame {
    JTextField txtMensaje;
    JButton btnEnviar;
    SocketUtil socketUtil= new SocketUtil();

    public FrmCliente(String remoteHost, int remotePort) {
        setLayout(null);
        setTitle("Cliente que envia envía> " + remoteHost + ":" + remotePort );

        txtMensaje = new JTextField();
        txtMensaje.setBounds(10,320,300,20);
        add(txtMensaje);

        btnEnviar = new JButton("Enviar");
        btnEnviar.addActionListener(e -> {
            socketUtil.send(remoteHost, remotePort, txtMensaje, null, false);
        });
        btnEnviar.setBounds(10,370,300,20);
        add(btnEnviar);

        setSize(400, 800);
        setVisible(true);
    }

    public void handleMessage(String m){

    }

    public static void main(String ...args) {
        new FrmCliente( "127.0.0.1", 9009);
    }
}