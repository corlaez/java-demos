package edu.cibertec.rutina;

import edu.cibertec.rutina.beans.RutinaConfig;
import edu.cibertec.rutina.beans.Servidor;
import file.process.SerialProcessor;
import file.process.TextProcessor;
import file.process.XmlProcessor;
import file.process.ZipProccesor;
import file.util.FileUtils;
import lombok.experimental.var;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Local_admin on 5/26/2017.
 */
public class RutinaMain {
    public static void main(String[] args) {
        //config 2 pts
        var fileUtils = FileUtils.getInstance();
        fileUtils.createFolder("C:/eval");
        fileUtils.createFolder("C:/eval/backup");

        var rutinaConfig = new RutinaConfig();
        rutinaConfig.setFecha(new Date());
        rutinaConfig.setPropietario("JARMANDO");

        var servidor = new Servidor();
        servidor.setAlias("SERVER-14");
        servidor.setIp("192.168.0.14");
        servidor.setMemoriaGB(84);
        rutinaConfig.getServers().add(servidor);

        servidor = new Servidor();
        servidor.setAlias("SERVER-15");
        servidor.setIp("192.168.0.15");
        servidor.setMemoriaGB(85);
        rutinaConfig.getServers().add(servidor);

        servidor = new Servidor();
        servidor.setAlias("SERVER-16");
        servidor.setIp("192.168.0.16");
        servidor.setMemoriaGB(6);
        rutinaConfig.getServers().add(servidor);

        //write 7pts
        String reporteRutinaConfig = rutinaConfig.toString();
        var textProcessor = new TextProcessor();
        textProcessor.write("C:/eval/reporte.txt", reporteRutinaConfig);
        System.out.println(reporteRutinaConfig);

        //gestion 7pts
        var xmlProcessor = new XmlProcessor();
        var serialProcessor = new SerialProcessor();
        for (var server: rutinaConfig.getServers()) {
            if(server.getMemoriaGB() > 16) {
                xmlProcessor.write("C:/eval/" + server.getAlias() + ".xml", server);
            }
            else {
                serialProcessor.write("C:/eval/" + server.getAlias() + ".SER", server);
            }
        }

        //backup 4pts
        var zipProcessor = new ZipProccesor();
        String from = "C:\\eval";
        String to =
                "C:\\eval/backup/" +
                new SimpleDateFormat("dd-MM-yyyy").format(new Date()) +
                ".zip";
        zipProcessor.write(from, to);
    }
}