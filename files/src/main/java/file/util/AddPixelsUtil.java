package file.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by Local_admin on 6/2/2017.
 */
public class AddPixelsUtil {
    static long c = 0;

    public static void main(String args[]) {
        String fileNameDEF = "C:\\Users\\Local_admin\\Desktop\\input\\Default.css";
        String fileNameRES = "C:\\Users\\Local_admin\\Desktop\\input\\Responsive.css";
        int pixels = 2;
        process(pixels, fileNameDEF, fileNameRES);
    }

    public static void process(int pixels, String ... filenames) {
        for (int i = 0; i < filenames.length; i++) {
            try (Stream<String> stream = Files.lines(Paths.get(filenames[i]))) {
                stream.forEach(s -> AddPixelsUtil.forEachLine(s, pixels));
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println();
            System.out.println("*****************************************************");
            System.out.println();
        }
    }

    public static void forEachLine(String curr, int pixels){
        if(curr.contains("font-size") && curr.contains("px")) {
            //System.out.println("old " + curr);
            int indexPX= curr.indexOf("px");
            String currSize;
            if(curr.charAt(indexPX - 2) != ' ')
                currSize = curr.substring(indexPX-2, indexPX);
            else
                currSize = curr.substring(indexPX-1, indexPX);
            if(currSize.equals("0"))
                return;
            c++;
            int newSize = Integer.parseInt(currSize) + pixels;
            String newCurr = curr.substring(0, indexPX - 2) + newSize + curr.substring(indexPX);
            System.out.println(newCurr);
        }
        else {
            System.out.println(curr);
        }
    }
}