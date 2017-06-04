package file.process;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by arman on 5/19/2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class SerializableMock implements Serializable {
    private int id;
    private String name;
    private double salary;
    private boolean active;
}