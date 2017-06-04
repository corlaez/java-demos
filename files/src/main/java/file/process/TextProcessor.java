package file.process;

import java.io.*;
/**
 * Created by Local_admin on 5/12/2017.
 */
public class TextProcessor implements FileProcessor {

    @Override
    public void write(String path, Object content) {
        File file = new File(path);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            writer.write((String)content);
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public Object read(String path, Object params) {
        File file = new File(path);
        String s = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            s = reader.lines().reduce("", (a,b) -> a + "\r\n" + b);
        } catch (Exception e) { e.printStackTrace(); }
        return s.substring(2);
    }

    public String read(String path) {
        return (String) read(path, null);
    }

    public static void main(String[] args) {

    }

}