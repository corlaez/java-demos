package serialize.clase.main;

import lombok.SneakyThrows;
import lombok.experimental.var;
import serialize.clase.beans.Alumno;
import serialize.clase.beans.Grupo;

import javax.swing.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Local_admin on 4/28/2017.
 */
public class XmlMain {

    @SneakyThrows
    public static void main(String... vargs) {
        Alumno alumno = new Alumno();
        alumno.setDni("70771112");
        alumno.setNombre("JUANA");
        alumno.setSueldo(1500D);

        Marshaller marshaller = newMarshaller(Alumno.class);
        marshaller.marshal(alumno, System.out);//TO CONSOLE
        marshalToFile(marshaller, alumno);//TO FILE

        List<Alumno> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            alumno = new Alumno();
            alumno.setDni("7077111" + i);
            alumno.setNombre("JUANA " + i);
            alumno.setSueldo(1000D + i * 100);
            list.add(alumno);
        }
        Grupo grupo = new Grupo().setAlumnos(list);
        marshalToFile(newMarshaller(Grupo.class), grupo);
        var gru = unmarshalFromFile(newUnmarshaller(Grupo.class), Grupo.class);
        System.out.println(gru);
    }

    @SneakyThrows
    private static <T> T unmarshalFromFile(Unmarshaller unmarshaller, Class<T> clazz) {
        var fc = new JFileChooser();
        int code = fc.showOpenDialog(null);
        if (code == JFileChooser.APPROVE_OPTION) {
            FileReader filereader = new FileReader(fc.getSelectedFile());
            try {
                T t = (T) unmarshaller.unmarshal(filereader);
                JOptionPane.showMessageDialog(null, "Archivo leido.", "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
                return t;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "El archivo no tiene formato xml.", "Error",
                        JOptionPane.INFORMATION_MESSAGE);
                return null;
            }
        }
        return null;
    }

    @SneakyThrows
    public static void marshalToFile(Marshaller marshaller, Object bean) {
        var fc = new JFileChooser();
        int code = fc.showSaveDialog(null);
        if (code == JFileChooser.APPROVE_OPTION) {
            FileWriter fileWriter = new FileWriter(fc.getSelectedFile());
            marshaller.marshal(bean, fileWriter);
            JOptionPane.showMessageDialog(null, "Archivo guardado", "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @SneakyThrows
    public static Marshaller newMarshaller(Class<?> clazz) {
        //Define estructura
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        //Creador de xmls
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        return marshaller;
    }

    @SneakyThrows
    public static Unmarshaller newUnmarshaller(Class<?> clazz) {
        //Define estructura
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        //Creador de xmls
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return unmarshaller;
    }
}