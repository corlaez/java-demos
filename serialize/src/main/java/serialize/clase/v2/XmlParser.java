package serialize.clase.v2;

import lombok.SneakyThrows;
import lombok.experimental.var;

import javax.swing.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by Arman on 4/28/2017.
 */
public class XmlParser<T> {//TODO TEST
    Marshaller marshaller;//cache
    Unmarshaller unmarshaller;//cache
    Class<T> clazz;//intanciar los marshalers y parsear

    public XmlParser(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T unmarshal(String xml) {
        try {
            return (T) newUnmarshaller().unmarshal(new StringReader(xml));
        } catch (Exception e) {
            return null;
        }
    }

    @SneakyThrows
    public String marshal(T bean) {
        var stringWriter = new StringWriter();
        newMarshaller().marshal(bean, stringWriter);
        return stringWriter.toString();
    }

    @SneakyThrows
    public T unmarshalFromFile() {
        var fc = new JFileChooser();
        int code = fc.showOpenDialog(null);
        if (code == JFileChooser.APPROVE_OPTION) {
            FileReader filereader = new FileReader(fc.getSelectedFile());
            JOptionPane.showMessageDialog(null, "Archivo leido.", "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
            try {
                return (T) newUnmarshaller().unmarshal(filereader);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    @SneakyThrows
    public void marshalToFile(Object bean) {
        var fc = new JFileChooser();
        int code = fc.showSaveDialog(null);
        if (code == JFileChooser.APPROVE_OPTION) {
            FileWriter fileWriter = new FileWriter(fc.getSelectedFile());
            newMarshaller().marshal(bean, fileWriter);
            JOptionPane.showMessageDialog(null, "Archivo guardado", "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @SneakyThrows
    private Marshaller newMarshaller() {
        if (marshaller != null)
            return marshaller;
        //Define estructura
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        //Creador de xmls
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        this.marshaller = marshaller;
        return marshaller;
    }

    @SneakyThrows
    private Unmarshaller newUnmarshaller() {
        if (unmarshaller != null)
            return unmarshaller;
        //Define estructura
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        //Creador de xmls
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        this.unmarshaller = unmarshaller;
        return unmarshaller;
    }
}