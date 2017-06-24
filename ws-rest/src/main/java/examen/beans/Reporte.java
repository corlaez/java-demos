package examen.beans;

import lombok.Data;

import java.util.List;
import java.util.UUID;

/**
 * Created by Local_admin on 6/23/2017.
 */
@Data
public class Reporte {
    String reporteId;
    List<PlanDeVuelo> vuelosConMaximosPasajeros;
    List<PlanDeVuelo> vuelosComerciales;
    String vuelosQueNoSeInterpretaron;

    public Reporte(List<PlanDeVuelo> vuelosConMaximosPasajeros, List<PlanDeVuelo> vuelosComerciales, String vuelosConError){
        this.reporteId = UUID.randomUUID().toString();
        this.vuelosConMaximosPasajeros = vuelosConMaximosPasajeros;
        this.vuelosComerciales = vuelosComerciales;
        this.vuelosQueNoSeInterpretaron = vuelosConError;
    }
}
