package serialize.clase.main;

import com.google.gson.Gson;
import serialize.clase.beans.Alumno;

/**
 * Created by Local_admin on 4/28/2017.
 */
public class GsonMain {

    public static void main(String ... vargs){
        Alumno alumno = new Alumno();
        alumno.setDni("70771112");
        alumno.setNombre("JUANA");
        alumno.setSueldo(1500D);

        Gson gson = new Gson();
    }

}
