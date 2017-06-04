package file.process;

/**
 * Created by arman on 5/12/2017.
 */
public interface FileProcessor0 {

    /**
     * Allows to write a file
     * @param path Where the file will be written
     * @param content content to write
     */
    void write(String path, Object content);

    /**
     * Allows to get the content of a file T
     * @param path Where the file is
     * @param params additional params if needed
     * @return
     */
    Object read(String path, Object ... params);

}
