package file.util;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.io.File;

/**
 * Created by Local_admin on 5/12/2017.
 */
public class FileUtilsTest {

    @Test
    public void newFolderTest(){
        FileUtils fu = FileUtils.getInstance();
        assertThat(fu, notNullValue());
        String path = "C:/helloWorld";
        assertThat(new File(path).exists(), is(false));
        fu.createFolder(path);
        assertThat(new File(path).exists(), is(true));
    }

}
