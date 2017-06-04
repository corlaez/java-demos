package v0.serv;

import lombok.SneakyThrows;
import lombok.experimental.var;
import org.jooq.lambda.Unchecked;
import v0.bean.Auto;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Esta clase permite crear servidores que procesan objetos de tipo "Auto"
 * Created by Jarman on 5/5/2017.
 *
 * @author JArmando Cordova
 */
public class ObjectServer {
    private int puerto;
    private ServerSocket serverSocket;
    private boolean prendido;

    /**
     * Constructor básico para un servidor de objetos.
     *
     * @param puerto a asignar al servidor
     */
    public ObjectServer(int puerto) throws IOException {
        this.puerto = puerto;
        serverSocket = new ServerSocket(puerto);
        System.err.println("Servidor creado en :" + puerto);
    }

    @SneakyThrows
    public void turnOn() {
        prendido = true;
        System.err.println("Servidor iniciado");
        System.err.println("Fecha y hora: " + new Date());

        new Thread(Unchecked.runnable(() -> {
                    while (prendido) {
                        Socket socketIncommingData = serverSocket.accept();
                        long init = System.nanoTime();
                        String hostNameClient = socketIncommingData.getInetAddress().getHostName();
                        String hostDirClient = socketIncommingData.getInetAddress().getHostName();
                        System.err.println("Conexión recibida desde: " + hostNameClient + "-" + hostDirClient);
                        //interprete del flujo
                        var objectinputStream = new ObjectInputStream(socketIncommingData.getInputStream());
                        Auto recibido = (Auto) objectinputStream.readObject();
                        System.err.println(recibido);
                        long end = System.nanoTime();
                        System.err.println((end - init)/1_000_000_000D);
                        objectinputStream.close();
                        socketIncommingData.close();
                    }
                }
        )).start();
    }

    @SneakyThrows
    public static void main(String[] args) {
        ObjectServer server = new ObjectServer(9898);
        server.turnOn();
        Thread.sleep(1000);
        Socket socketCliente = new Socket("127.0.0.1", 9898);
        var objectOut = new ObjectOutputStream(socketCliente.getOutputStream());
        Auto auto = new Auto("AIJ579", "kia", "Pride", 1500);
        objectOut.writeObject(auto);
        Thread.sleep(1000);
        System.out.println("end");
        System.exit(0);
    }

}
