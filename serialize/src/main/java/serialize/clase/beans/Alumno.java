package serialize.clase.beans;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Local_admin on 4/28/2017.
 */
@Data
@XmlRootElement
public class Alumno
{
    String dni;
    String nombre;
    Double sueldo;
}