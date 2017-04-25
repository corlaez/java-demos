package sockets.v3;

import lombok.experimental.var;
import org.jooq.lambda.tuple.Tuple3;
import sockets.MyComboBoxModel;
import sockets.SocketUtil;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Local_admin on 4/21/2017.
 */
public class TextFileMultiClient extends JFrame {
    static final DefaultComboBoxModel<Tuple3<String, Integer, Integer>> staticConnections = new DefaultComboBoxModel<>();
    MutableComboBoxModel<Tuple3<String, Integer, Integer>> localConnections;
    JTextArea txtArea;
    JTextField txtMensaje;
    JButton btnEnviar;
    SocketUtil socketUtil= new SocketUtil();
    JButton btnEnviarFile;
    JFileChooser fc = new JFileChooser();
    JComboBox cboConnections;

    public TextFileMultiClient(String localhost, int localPort, int localFilePort) {
        setLayout(null);
        setTitle(localPort + ", file: " + localFilePort);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        txtArea = new JTextArea();
        txtArea.setBounds(10,10,300,300);
        add(txtArea);

        txtMensaje = new JTextField();
        txtMensaje.setBounds(10,320,300,20);
        add(txtMensaje);

        btnEnviar = new JButton("Enviar");
        btnEnviar.addActionListener(e -> {
            String remoteHost = getCurrentHost();
            int remotePort = getCurrentPort();
            socketUtil.send(remoteHost, remotePort, txtMensaje, txtArea, false);
        });
        btnEnviar.setBounds(10,370,145,20);
        add(btnEnviar);

        btnEnviarFile = new JButton("Enviar Archivo");
        btnEnviarFile.addActionListener(e -> {
            int code = fc.showOpenDialog(this);
            if(code == JFileChooser.APPROVE_OPTION) {
                String remoteHost = getCurrentHost();
                int remoteFilePort = getCurrentFilePort();
                socketUtil.sendFile(remoteHost, remoteFilePort, fc.getSelectedFile(), txtArea, true);
            }
        });
        btnEnviarFile.setBounds(160,370,145,20);
        add(btnEnviarFile);

        cboConnections = new JComboBox();
        cboConnections.setBounds(10,430,300,20);
        localConnections = new MyComboBoxModel(staticConnections);
        cboConnections.setModel(localConnections);
        add(cboConnections);

        setSize(400, 800);
        setVisible(true);
        socketUtil.listen(localPort, this::handleMessage, true);
        socketUtil.listenFile(localFilePort, fc, this, txtArea, true);

        var myTuple = new Tuple3<>(localhost, localPort, localFilePort);
        staticConnections.addElement(myTuple);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosed(e);
                System.out.println("removed "  + myTuple);
                setVisible(false);
                staticConnections.removeElement(myTuple);
                if(staticConnections.getSize() == 0){
                    System.exit(0);
                }
            }
        });
        //JDialog.setDefaultLookAndFeelDecorated(true);
        cboConnections.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.DESELECTED){
                if(isVisible()) {
                    System.out.println("deseleccionado " + getTitle());
                    if(!"".equals(txtArea.getText()))
                        JOptionPane.showConfirmDialog(this, "Limpiando mensajes.", "Desconectado",
                            JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE);
                    txtArea.setText("");
                }
            }
        });
    }

    private Tuple3<String, Integer, Integer> getCurrentTuple() {
        return ((Tuple3<String, Integer, Integer>) cboConnections.getSelectedItem());
    }

    private int getCurrentFilePort() {
        return getCurrentTuple().v3;
    }

    private int getCurrentPort() {
        return getCurrentTuple().v2;
    }

    private String getCurrentHost() {
        return getCurrentTuple().v1;
    }

    public void handleMessage(String m){
        txtArea.append(m);
    }

    public static void main(String ...args) {
        new TextFileMultiClient("127.0.0.1", 9012, 9013);
        new TextFileMultiClient("127.0.0.1", 9010, 9011);
        new TextFileMultiClient("127.0.0.1", 9008, 9009);
    }
}