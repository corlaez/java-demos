package colas;

import lombok.SneakyThrows;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.Serializable;

/**
 * Created by Local_admin on 6/30/2017.
 */
public class JmsMessenger<T extends Serializable> {
    static final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
    static {
        System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES", "*");
    }

    private Connection connection;
    private String cola;
    private Session session;
    private Boolean on = false;

    @SneakyThrows
    public JmsMessenger(String cola) {
        connection = connectionFactory.createConnection();
        this.cola = cola;
    }

    @SneakyThrows
    public synchronized void send(T serializable) {
        if(!on) {
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        }
        Destination destination = session.createQueue(cola);
        MessageProducer messageProducer = session.createProducer(destination);
        Message message = session.createObjectMessage(serializable);
        messageProducer.send(message);
        System.out.println("mensaje enviado");
    }

    @SneakyThrows
    public synchronized T recieve() {
        if(!on) {
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        }
        Destination destination = session.createQueue(this.cola);
        //consume
        MessageConsumer messageConsumer = session.createConsumer(destination);
        ObjectMessage objectMessage = (ObjectMessage) messageConsumer.receive();
        System.out.println("mensaje recibido");
        return  (T) objectMessage.getObject();
    }

    @SneakyThrows
    public synchronized void close(){
        on = null;
        session.close();
        connection.stop();
        connection.close();
    }

    public boolean isAveliable(){
        return on != null;
    }
}