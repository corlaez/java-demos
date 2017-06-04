package file.process;

/**
 * Created by Local_admin on 5/12/2017.
 */
public interface FileProcessor<T> {

    /**
     * Allows to write a file T
     * @param path Where the file will be written
     * @param content content to write
     */
    void write(String path, T content);

    /**
     * Allows to get the content of a file T
     * @param path Where the file is
     * @param params additional params if needed
     * @return
     */
    T read(String path, Object params);

}
