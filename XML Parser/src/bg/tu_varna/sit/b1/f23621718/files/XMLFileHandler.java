package bg.tu_varna.sit.b1.f23621718.files;

import java.io.*;

public class XMLFileHandler extends FileIOHandler {
    @Override
    public String read(String path) throws IOException {
        if (!path.endsWith(".xml"))
            throw new IOException("File must be an XML file.");
        return super.read(path);
    }

    @Override
    public void write(String path, String data) throws IOException {
        if (!path.endsWith(".xml"))
            throw new IOException("File must be an XML file.");
        super.write(path, data);
    }
}
