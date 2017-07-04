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
public class EmisorObjetos {
    static final String COLA = "colaPokemon";
    static final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
    Connection connection;
    String cola;
    Session session;

    @SneakyThrows
    public EmisorObjetos(String cola) {
        connection = connectionFactory.createConnection();
        this.cola = cola;
    }

    @SneakyThrows
    public synchronized void send(Serializable serializable) {
        connection.start();
        //false = non transactional
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(this.cola);
        MessageProducer messageProducer = session.createProducer(destination);
        Message message = session.createObjectMessage(serializable);
        messageProducer.send(message);
        System.out.println("mensaje enviado");
    }

    @SneakyThrows
    private synchronized void close(){
        session.close();
        connection.stop();
        connection.close();
    }

    public static void main(String[] args) {
        raw();
        EmisorObjetos emisor = new EmisorObjetos(COLA);
        var pokemon = new Pokemon(9, "Blastoise", new String[]{"Agua"});
        emisor.send(pokemon);
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
        MessageProducer messageProducer = session.createProducer(destination);
        Pokemon pokemon = new Pokemon(6, "Charizard", new String[]{"Fuego","Volador"});
        Message message = session.createObjectMessage(pokemon);
        messageProducer.send(message);
        System.out.println("mensaje enviado");
        session.close();
        connection.stop();
        connection.close();
    }
}
