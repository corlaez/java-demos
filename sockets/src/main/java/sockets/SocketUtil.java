package sockets;

import lombok.experimental.var;
import org.jooq.lambda.Unchecked;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

/**
 * Created by Local_admin on 4/21/2017.
 */
public class SocketUtil {

    public void listen(int localPort, Consumer<String> handleMessage, boolean prefixAddress){
        new Thread(Unchecked.runnable(() -> {
            var serverSocket = new ServerSocket(localPort);
            Socket socket;
            while(true){
                socket = serverSocket.accept();
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                String mensaje = inputStream.readUTF();
                handleMessage.accept("\nOtro " + (prefixAddress ? socket.getInetAddress().toString() : "")  +  ":" + mensaje);
                inputStream.close();
                socket.close();
            }
        })).start();
    }

    public void send(String remoteHost, int remotePort, JTextField txtMensaje, JTextArea txtArea, boolean prefixAddress) {
        String prefix = "";
        try {
            var socket = new Socket(remoteHost, remotePort);
            var outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.writeUTF(txtMensaje.getText());
            outputStream.close();
            socket.close();
            prefix = " " + (prefixAddress ? socket.getInetAddress().toString() : "");
            if(txtArea != null)
                txtArea.append("\nYo " + prefix +  ":" + txtMensaje.getText());
            txtMensaje.setText("");
        }
        catch(ConnectException ex) {
            if(txtArea != null)
                txtArea.append("\nError de envío " + prefix +  ":" + txtMensaje.getText());
            txtMensaje.setText("");
        }
        catch (Exception ex) { throw new RuntimeException(ex); }
    }

    public void listenFile(int localPort, JFileChooser fc, Component parent, JTextArea txtArea, boolean prefixAddress){
        new Thread(Unchecked.runnable(() -> {
            var serverSocket = new ServerSocket(localPort);
            Socket socket;
            while(true){
                socket = serverSocket.accept();
                txtArea.append("\nOtro " + (prefixAddress ? socket.getInetAddress().toString() : "")  +  ":" + "Te envio un archivo. Cargando...");
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                int code = fc.showSaveDialog(parent);
                if(code == JFileChooser.APPROVE_OPTION) {
                    File newFile = fc.getSelectedFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(newFile);
                    int b;
                    while ( (b = inputStream.read()) != -1) {
                        fileOutputStream.write(b);
                    }
                    txtArea.append("\nOtro " + (prefixAddress ? socket.getInetAddress().toString() : "") +  ":" + "Archivo finalizo descarga.");
                }
                else {
                    txtArea.append("\nOtro " + (prefixAddress ? socket.getInetAddress().toString() : "") + ":" + "El archivo no se descargó.");
                }
                inputStream.close();
                socket.close();
            }
        })).start();
    }

    public void sendFile(String remoteHost, int remotePort, File f, JTextArea txtArea, boolean prefixAddress) {
        String prefix = "";
        try {
            var socket = new Socket(remoteHost, remotePort);
            var outputStream = new DataOutputStream(socket.getOutputStream());
            FileInputStream flujoFile = new FileInputStream(f);
            int b;
            while ( (b = flujoFile.read()) != -1) {
                outputStream.write(b);
            }
            flujoFile.close();
            outputStream.close();
            socket.close();
            prefix = " " + (prefixAddress ? socket.getInetAddress().toString() : "");
            txtArea.append("\nYo " + prefix +  ": " + "Archivo enviado");
        }
        catch(ConnectException ex) {
            txtArea.append("\nError de envío" + prefix +  ":" + f.getName());
        }
        catch (Exception ex) { throw new RuntimeException(ex); }
    }

    public static String getExtension(final String filename) {
        if (filename == null) {
            return null;
        }
        final int index = indexOfExtension(filename);
        if (index == -1) {
            return "";
        } else {
            return filename.substring(index + 1);
        }
    }

    public static int indexOfExtension(final String filename) {
        if (filename == null) {
            return -1;
        }
        final int extensionPos = filename.lastIndexOf('.');
        final int lastSeparator = indexOfLastSeparator(filename);
        return lastSeparator > extensionPos ? -1 : extensionPos;
    }

    public static int indexOfLastSeparator(final String filename) {
        if (filename == null) {
            return -1;
        }
        final int lastUnixPos = filename.lastIndexOf('/');
        final int lastWindowsPos = filename.lastIndexOf('\\');
        return Math.max(lastUnixPos, lastWindowsPos);
    }
}
