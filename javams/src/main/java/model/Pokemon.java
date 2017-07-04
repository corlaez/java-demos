package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by Local_admin on 6/30/2017.
 */
@Data @NoArgsConstructor @AllArgsConstructor
public class Pokemon implements Serializable {
    private int numero;
    private String nombre;
    private String[] tipos;
}
