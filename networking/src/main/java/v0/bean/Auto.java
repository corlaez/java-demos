package v0.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by Jarman on 5/5/2017.
 */
@Data
public class Auto /*extends Car*/ implements Serializable {

    public Auto(String placa, String marca, String modelo, int motor){
        //super(placa);
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.motor = motor;
    }

    private String placa;
    private String marca;
    private String modelo;
    private int motor;
}