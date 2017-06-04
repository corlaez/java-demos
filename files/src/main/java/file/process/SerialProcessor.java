package file.process;

import java.io.*;

/**
 * Created by Local_admin on 5/19/2017.
 */
public class SerialProcessor implements FileProcessor0 {

    @Override
    public void write(String path, Object content) {
        File file = new File(path);
        try (ObjectOutputStream objectOS = new ObjectOutputStream(new FileOutputStream(file))){
            objectOS.writeObject(content);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Object read(String path, Object... params) {
        Object o = null;
        File file = new File(path);
        try (ObjectInputStream objectIS = new ObjectInputStream(new FileInputStream(file))){
            o = objectIS.readObject();
        } catch(Exception e){
            e.printStackTrace();
        }
        return o;
    }
}
