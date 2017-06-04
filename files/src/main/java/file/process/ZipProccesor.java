package file.process;

import lombok.SneakyThrows;
import lombok.experimental.var;

import java.io.FileInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Jarman on 5/26/2017.
 */
public class ZipProccesor implements FileProcessor0 {
    @Override
    @SneakyThrows
    public void write(String path, Object content) {
        byte[] buffer = new byte[1024];
        String from = path;
        String to = (String) content;
        FileOutputStream fos = new FileOutputStream(to);//zip
        ZipOutputStream zos = new ZipOutputStream(fos);//zip

        var fileList = generateFileList(from, new File(from), false);
        for (String f: fileList) {
            System.out.println("f " + f);
            ZipEntry ze = new ZipEntry(f);
            zos.putNextEntry(ze);
            FileInputStream in = new FileInputStream(from + "/" + f);

            int len;
            while((len = in.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }
            in.close();
        }

        zos.closeEntry();
        zos.close();
    }

    private List<String> generateFileList(String from, File node, boolean recursive)  {
        List<String> fileList = new ArrayList<>();
        if(node.isFile()) {
            fileList.add(generateZipEntry(from, node.getAbsoluteFile().toString() ) );
        }
        if(node.isDirectory() && (recursive || from.equals(node.getAbsolutePath()))){
            String[] subNote = node.list();
            for(String filename : subNote){
                var newFiles = generateFileList(from, new File(node, filename), recursive);
                fileList.addAll(newFiles);
            }
        }
        return fileList;
    }

    private String generateZipEntry(String from, String file){
        return  file.substring(from.length() + 1, file.length());
    }

    @Override
    public Object read(String path, Object... params) {
        return null;
    }
}
