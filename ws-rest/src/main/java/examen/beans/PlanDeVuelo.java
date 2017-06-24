package examen.beans;

import lombok.Data;

import java.util.UUID;

@Data
public class PlanDeVuelo {
    private String codigo;
    private String modelo;
    private int capacidadPasajeros;
    private String origen;
    private String destino;
    private Boolean esComercial;

    public PlanDeVuelo(String sModelo, String sCapacidadP, String sOrigen, String sDestino, String sComercialPrivado) {
        this.codigo = UUID.randomUUID().toString();
        this.modelo = sModelo;
        this.capacidadPasajeros = Integer.parseInt(sCapacidadP);
        this.origen = sOrigen;
        this.destino = sDestino;
        this.esComercial = sComercialPrivado.equalsIgnoreCase("p") ? false :
                sComercialPrivado.equalsIgnoreCase("c") ? true : null;
        if(esComercial == null)
            throw new IllegalArgumentException("es Comercial o Privado solo admite P o C");
    }
}