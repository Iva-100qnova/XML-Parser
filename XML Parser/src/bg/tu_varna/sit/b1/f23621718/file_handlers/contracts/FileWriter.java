package bg.tu_varna.sit.b1.f23621718.file_handlers.contracts;

import java.io.IOException;

public interface FileWriter {
    void write(String path, String data) throws IOException;
}
