package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Local_admin on 6/16/2017.
 */
public class MyHttpClient {

    public void get(String url)  throws IOException {
        URL urlServicio = new URL(url);
        HttpURLConnection conexion= (HttpURLConnection)urlServicio.openConnection();
        conexion.setRequestMethod("GET");
        int codResp = conexion.getResponseCode();
        System.out.println(String.format("codigo de respuesta: %d", codResp));
        String lineaLeida;
        StringBuilder sb = new StringBuilder();//single thread
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()))) {
            reader.lines().forEach(System.out::println);
//            while ((lineaLeida = reader.readLine()) != null){
//                sb.append(lineaLeida).append(System.lineSeparator());
//            }
        } catch (Exception e) {
            System.out.println("ERROR");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        new MyHttpClient().get("http://localhost:8080/rest/basico");
    }

}