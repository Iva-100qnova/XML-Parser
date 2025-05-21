package bg.tu_varna.sit.b1.f23621718.contracts.files;

import java.io.IOException;

/**
 * Интерфейс за четене на файлове.
 *
 * <p>Определя метод за прочитане на съдържанието на файл от зададен път.</p>
 */
public interface FileReader {

    /**
     * Прочита съдържанието на файл от зададения път.
     *
     * @param path Пътят до файла, който трябва да бъде прочетен.
     * @return Съдържанието на файла като {@code String}.
     * @throws IOException ако възникне грешка при достъп до файла.
     */
    String read(String path) throws IOException;
}
