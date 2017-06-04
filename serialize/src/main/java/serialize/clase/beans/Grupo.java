package serialize.clase.beans;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Local_admin on 4/28/2017.
 */
@Data
@Accessors(chain = true)
@XmlRootElement
public class Grupo {
    List<Alumno> alumnos;
}
