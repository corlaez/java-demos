package file.process;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by Local_admin on 5/12/2017.
 */
public class FileProcessorTest {

    @Test
    public void textTest() {
        TextProcessor textProcessor = new TextProcessor();
        String path = "C:/helloWorld/armando.txt";
        String content = "Hola\r\nMundo\r\n";
        textProcessor.write(path, content);
        String readContent = textProcessor.read(path);
        assertEquals(content.trim(), readContent);
    }

    @Test
    public void serialTest() {
        SerialProcessor serialProcessor = new SerialProcessor();
        String path = "C:/helloWorld/armandoSerial.src";
        SerializableMock content = new SerializableMock(1,"juan", 1000D, true);
        serialProcessor.write(path, content);
        SerializableMock readContent = (SerializableMock) serialProcessor.read(path);
        assertEquals(content, readContent);
        System.out.println(readContent.getName());
    }

    @Test
    public void textXml() {
        XmlProcessor xmlProcessor = new XmlProcessor();
        String path = "C:/helloWorld/armando.xml";
        SerializableMock content = new SerializableMock(1,"juanXML", 1000D, true);
        xmlProcessor.write(path, content);
        SerializableMock readContent = (SerializableMock) xmlProcessor.read(path, SerializableMock.class);
        assertEquals(content, readContent);
        System.out.println(readContent.getName());
    }

}
