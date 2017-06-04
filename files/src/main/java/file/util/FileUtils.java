package file.util;

import java.io.File;

/**
 * Contiene métodos para el trabajo de archivos.
 * @author José Armando Córdova Peláez
 * Created by José Armando Córdova Peláez on 5/5/2017.
 */
public class FileUtils {
    private static FileUtils INSTANCE;

    private FileUtils() {}

    public static FileUtils getInstance(){
        if(INSTANCE == null)
            INSTANCE = new FileUtils();
        return INSTANCE;
    }

    /** Este método crea una carpeta si no existe.
     * @param fullpath Es la ruta y nombre de la carpeta a crear */
    public void createFolder(String fullpath) {
        File folder = new File(fullpath);
        if(!folder.exists()) {
            folder.mkdir();
        }
        /* IO operations are expensive but some are cheap.
         * Cheap Operations: existense, permission, Kind of file (dir vs single file)
         * */

    }

}