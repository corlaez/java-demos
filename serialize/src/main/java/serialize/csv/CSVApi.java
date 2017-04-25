package serialize.csv;

import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jarma on 4/25/2017.
 */
public class CSVApi {
    Component parent;
    JFileChooser fileChooser;

    public CSVApi (Component parent){
        this.parent = parent;
        fileChooser = new JFileChooser();
    }

    public List<String> simpleReadFromFile() {
        int code = fileChooser.showOpenDialog(null);
        if(code == JFileChooser.APPROVE_OPTION) {
            return readRows();
        }
        return null;
    }

    @SneakyThrows
    private List<String> readRows() {
        FileReader fileReader = new FileReader(fileChooser.getSelectedFile());
        try (BufferedReader reader = new BufferedReader(fileReader)) {
            return reader.lines().collect(Collectors.toList());
        }
    }

    public static void main (String ... vargs) {
        CSVApi csvApi = new CSVApi(null);
        System.out.println(csvApi.simpleReadFromFile());
    }
}
