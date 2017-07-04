package colas;

import lombok.SneakyThrows;
import lombok.experimental.var;
import model.Pokemon;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.Serializable;

/**
 * Esta cola permite simular el envio de un objeto como mensaje a traves de apache Active MQ (encolamiento)
 * Created by Local_admin on 6/30/2017.
 * @author Armando Cordova
 */
public class ReceptorObjetos {
    static final String COLA = "colaPokemon";
    static final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
    Connection connection;
    String cola;
    Session session;

    @SneakyThrows
    public ReceptorObjetos(String cola) {
        connection = connectionFactory.createConnection();
        this.cola = cola;
    }

    @SneakyThrows
    public synchronized Serializable recieve() {
        connection.start();
        //false = non transactional
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(this.cola);
        //consume
        MessageConsumer messageConsumer = session.createConsumer(destination);
        ObjectMessage objectMessage = (ObjectMessage) messageConsumer.receive();
        System.out.println("mensaje recibido");
        return  objectMessage.getObject();
    }

    @SneakyThrows
    private synchronized void close(){
        session.close();
        connection.stop();
        connection.close();
    }

    public static void main(String[] args) {
        System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES", "*");
        raw();
        ReceptorObjetos emisor = new ReceptorObjetos(COLA);
        var pokemon = (Pokemon) emisor.recieve();
        System.out.println(pokemon);
        emisor.close();
    }

    @SneakyThrows
    private static void raw() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        //false = non transactional
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(COLA);
        //consume
        MessageConsumer messageConsumer = session.createConsumer(destination);
        ObjectMessage objectMessage = (ObjectMessage) messageConsumer.receive();
        System.out.println("mensaje recibido");
        System.out.println((Pokemon) objectMessage.getObject());
        //close
        session.close();
        connection.stop();
        connection.close();
    }
}
