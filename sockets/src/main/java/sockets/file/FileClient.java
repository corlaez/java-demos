package sockets.file;

import sockets.SocketUtil;

import javax.swing.*;

/**
 * Created by Local_admin on 4/21/2017.
 */
public class FileClient extends JFrame {
    JTextArea txtArea;
    JTextField txtMensaje;
    JButton btnEnviar;
    SocketUtil socketUtil = new SocketUtil();
    JFileChooser fc = new JFileChooser();

    public FileClient(int localPort, String remoteHost, int remotePort) {
        setLayout(null);
        setTitle("" + localPort);

        txtArea = new JTextArea();
        txtArea.setBounds(10,10,300,300);
        add(txtArea);


        txtMensaje = new JTextField();
        txtMensaje.setBounds(10,320,300,20);
        add(txtMensaje);

        btnEnviar = new JButton("Enviar File");
        btnEnviar.addActionListener(e -> {
            int code = fc.showOpenDialog(this);
            if(code == JFileChooser.APPROVE_OPTION) {
                socketUtil.sendFile(remoteHost, remotePort, fc.getSelectedFile(), txtArea, true);
            }
        });
        btnEnviar.setBounds(10,370,300,20);
        add(btnEnviar);

        setSize(400, 800);
        setVisible(true);
        socketUtil.listenFile(localPort, fc, this, txtArea, true);
    }

    public void handleMessage(String m){
        txtArea.append(m);
    }

    public static void main(String ...args) {
        //fgfdg
        new FileClient(9010, "127.0.0.1", 9009);
        new FileClient(9009, "127.0.0.1", 9010);
    }
}