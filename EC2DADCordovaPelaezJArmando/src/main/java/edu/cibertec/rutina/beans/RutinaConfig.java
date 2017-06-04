package edu.cibertec.rutina.beans;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * Created by Arman on 5/26/2017.
 */
@Data
@XmlRootElement
public class RutinaConfig implements Serializable {
    private Integer id;
    private String propietario;
    private Date fecha;
    private List<Servidor> servers = new ArrayList<>();
    private static List<Integer> ids = new ArrayList<>();

    public RutinaConfig(){
        do {
            id = Integer.parseInt("" + (System.currentTimeMillis() / 10000));
        } while(ids.contains(id));
        ids.add(id);
    }

    @Override
    public String toString() {
        return
                "ID: " + id + "\n" +
                "Fecha: " + new SimpleDateFormat(
                        "dd 'de' MMMM 'de' yyyy",
                        new Locale("es", "PE")
                ).format(fecha) + "\n" +
                "Propietario: " + propietario + "\n" +
                "Lista de Servidores: " +
                "\n-------------------------------------------------------------------------\n" +
                servers.stream()
                        .map(s -> "Servidor " + s.getId() + ": " +s.getIp() + " alias " + s.getAlias() + " " + s.getMemoriaGB() + "\n")
                        .collect(Collectors.joining());
    }
}