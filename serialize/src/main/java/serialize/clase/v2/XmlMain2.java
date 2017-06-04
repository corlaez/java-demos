package serialize.clase.v2;

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
public class XmlMain2 {

    public static void main(String... vargs) {
        XmlParser alumnoXml = new XmlParser(Alumno.class);
        XmlParser grupoXml = new XmlParser(Grupo.class);

        Alumno alumno = new Alumno();
        alumno.setDni("70771112");
        alumno.setNombre("JUANA");
        alumno.setSueldo(1500D);

        String alumnoString = alumnoXml.marshal(alumno);
        System.out.println(alumnoString);
        alumnoXml.marshalToFile(alumno);//TO FILE

        List<Alumno> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            alumno = new Alumno();
            alumno.setDni("7077111" + i);
            alumno.setNombre("JUANA " + i);
            alumno.setSueldo(1000D + i * 100);
            list.add(alumno);
        }
        Grupo grupo = new Grupo().setAlumnos(list);
        grupoXml.marshalToFile(grupo);
        var gru = grupoXml.unmarshalFromFile();
        System.out.println(gru);
    }

}