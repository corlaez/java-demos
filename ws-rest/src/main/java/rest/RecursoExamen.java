package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import examen.beans.PlanDeVuelo;
import examen.beans.Interprete;
import examen.beans.Reporte;
import lombok.experimental.var;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Path("examen")
public class RecursoExamen {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String examen(@QueryParam("vuelos") String vuelos){
        //7 puntos
        System.out.println("INPUT-VUELOS: " + vuelos);
        if(vuelos == null)
            return  "Debe especificar el parametro 'vuelos'";
        var interprete = new Interprete(vuelos);
        var listaVuelos = interprete.execute();
        if(listaVuelos == null) {
            return "Error de formato. Ejemplo de formato correcto: %5B%7BAIRBUS X5,300,Lima (PE),Aarhus (DK),C%7D%7C%7BBOEING T500,500,Cusco (PE),Bruselas(BELG),C%7D%5D";
        }
        //11 puntos
        int maxC = listaVuelos.stream()
                .max(Comparator.comparing(PlanDeVuelo::getCapacidadPasajeros))
                .get().getCapacidadPasajeros();
        var vuelosMaximaCantidad = listaVuelos.stream()
                .filter(v -> v.getCapacidadPasajeros() == maxC)
                .collect(Collectors.toList());
        var vuelosComerciales = listaVuelos.stream()
                .filter(v -> v.getEsComercial())
                .collect(Collectors.toList());
        //2 puntos
        String reporte = gson.toJson(
                new Reporte(
                        vuelosMaximaCantidad,
                        vuelosComerciales,
                        interprete.getVuelosConError())
        );
        System.out.println("REPORTE: " + reporte);
        return reporte;
    }
}