package file.util;

import lombok.SneakyThrows;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    public List<File> getChildren(File parent, Predicate<File> p) {
        return Arrays.asList(parent.listFiles()).stream()
                .filter(p)
                .collect(Collectors.toList());
    }

    public List<File> getPngs(File parent) {
        return Arrays.asList(parent.listFiles()).stream()
                .filter(f -> !f.isDirectory() && f.getName().matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)"))
                .collect(Collectors.toList());
    }

    @SneakyThrows
    public void resizePngsUnder(String parent, float factor, String newPath) {
        newPath = newPath.trim();
        newPath = newPath.substring(newPath.length() - 1).equals("/") ? newPath : newPath + "/";
        File root = new File(parent);
        List<File> pngs = getPngs(root);
        for (File png: pngs) {
            BufferedImage resized = resize(png, factor);
            System.out.println(newPath + png.getName());
            ImageIO.write(resized, "png", new File(newPath + png.getName()));
        }
    }

    @SneakyThrows
    private BufferedImage resize(File png, float factor) {
        BufferedImage originalImage = ImageIO.read(png);
        int IMG_WIDTH = Math.round(originalImage.getWidth() * factor);
        int IMG_HEIGHT = Math.round(originalImage.getHeight() * factor);
        int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
        BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
        g.dispose();
        return resizedImage;
    }

    private void generateDrawablesFromXXHDPI(String parent) {
        createFolder(parent + "/android");
        createFolder(parent + "/android/drawable-xhdpi");
        createFolder(parent + "/android/drawable-hdpi");
        createFolder(parent + "/android/drawable-mdpi");
        createFolder(parent + "/android/drawable-ldpi");
        resizePngsUnder(parent, 2f / 3f, parent + "/android/drawable-xhdpi");
        resizePngsUnder(parent, 1f / 2f, parent + "/android/drawable-hdpi");
        resizePngsUnder(parent, 1f / 3f, parent + "/android/drawable-mdpi");
        resizePngsUnder(parent, 0.75f / 3f, parent + "/android/drawable-ldpi");
    }

    public static void main(String[] args) {
        new FileUtils().generateDrawablesFromXXHDPI("E:\\drawable-xxhdpi");
    }
}