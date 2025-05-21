package bg.tu_varna.sit.b1.f23621718.files;

import java.io.*;

public class XMLFileHandler extends FileIOHandler {

    /**
     * Прочита съдържанието на XML файл.
     * Проверява дали файлът има разширение ".xml".
     * Ако не е XML файл, хвърля IOException.
     *
     * @param path Път до файла.
     * @return Съдържанието на файла като низ.
     * @throws IOException Ако файлът не е XML или има проблем с четенето.
     */
    @Override
    public String read(String path) throws IOException {
        if (!path.endsWith(".xml"))
            throw new IOException("File must be an XML file.");
        return super.read(path);
    }

    /**
     * Записва съдържание в XML файл.
     * Проверява дали файлът има разширение ".xml".
     * Ако не е XML файл, хвърля IOException.
     *
     * @param path Път до файла.
     * @param data Данните за запис.
     * @throws IOException Ако файлът не е XML или има проблем с писането.
     */
    @Override
    public void write(String path, String data) throws IOException {
        if (!path.endsWith(".xml"))
            throw new IOException("File must be an XML file.");
        super.write(path, data);
    }
}
