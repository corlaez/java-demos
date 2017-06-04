package edu.cibertec.rutina.beans;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Local_admin on 5/26/2017.
 */
@Data
@XmlRootElement
public class Servidor implements Serializable {
    private Integer id;
    private String alias;
    private String ip;
    private int memoriaGB;
    private static List<Integer> ids = new ArrayList<>();

    public Servidor(){
        do {
            id = Integer.parseInt("" + (System.currentTimeMillis() / 10000));
        } while(ids.contains(id));
        ids.add(id);
    }
}