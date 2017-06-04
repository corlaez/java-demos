package sockets.v2;

import sockets.SocketUtil;

import javax.swing.*;

/**
 * Created by Local_admin on 4/21/2017.
 */
public class TextFileClient extends JFrame {
    JTextArea txtArea;
    JTextField txtMensaje;
    JButton btnEnviar;
    SocketUtil socketUtil= new SocketUtil();
    JButton btnEnviarFile;
    JFileChooser fc = new JFileChooser();

    public TextFileClient(int localPort, int localFilePort, String remoteHost, int remotePort, int remoteFilePort) {
        setLayout(null);
        setTitle(localPort + ", file: " + localFilePort);

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
        btnEnviar.setBounds(10,370,145,20);
        add(btnEnviar);

        btnEnviarFile = new JButton("Enviar Archivo");
        btnEnviarFile.addActionListener(e -> {
            int code = fc.showOpenDialog(this);
            if(code == JFileChooser.APPROVE_OPTION) {
                socketUtil.sendFile(remoteHost, remoteFilePort, fc.getSelectedFile(), txtArea, true);
            }
        });
        btnEnviarFile.setBounds(160,370,145,20);
        add(btnEnviarFile);

        setSize(400, 800);
        setVisible(true);
        socketUtil.listen(localPort, this::handleMessage, true);
        socketUtil.listenFile(localFilePort, fc, this, txtArea, true);
    }

    public void handleMessage(String m){
        txtArea.append(m);
    }

    public static void main(String ...args) {
        new TextFileClient(9010, 9011, "192.168.0.21", 9008, 9009);
//        new TextFileClient(9008, 9009, "127.0.0.1", 9010, 9011);
    }
}