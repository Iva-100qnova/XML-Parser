package bg.tu_varna.sit.b1.f23621718.files;

import bg.tu_varna.sit.b1.f23621718.contracts.files.*;

import java.io.*;
import java.io.FileReader;
import java.io.FileWriter;

public class FileIOHandler implements FileHandler {

    @Override
    public String read(String path) throws IOException {

        File file = new File(path);
        if (file.createNewFile()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        reader.close();
        return sb.toString();
    }

    @Override
    public void write(String path, String data) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.write(data);
        writer.close();
    }
}
