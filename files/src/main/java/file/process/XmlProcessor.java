package file.process;

import serialize.clase.v2.XmlParser;

/**
 * Created by arman on 5/19/2017.
 */
public class XmlProcessor implements FileProcessor0 {
    TextProcessor textProcessor = new TextProcessor();

    public void write(String path, Object content) {
        XmlParser x = new XmlParser(content.getClass());
        String xmlContent = x.marshal(content);
        textProcessor.write(path, xmlContent);
    }

    public Object read(String path, Object... params) {
        if(params == null || params.length == 0 || !(params[0] instanceof Class))
            throw new IllegalArgumentException("You need to send a Class as params[0]");
        XmlParser x = new XmlParser((Class<?>)params[0]);
        String xmlContent = textProcessor.read(path);
        Object content = x.unmarshal(xmlContent);
        return content;
    }
}