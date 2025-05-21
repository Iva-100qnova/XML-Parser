package bg.tu_varna.sit.b1.f23621718.contracts.files;

import java.io.IOException;

/**
 * Интерфейс за запис на данни във файл.
 *
 * <p>Определя метод за записване на текстово съдържание във файл на зададен път.</p>
 */
public interface FileWriter {

    /**
     * Записва подадените данни във файл на зададения път.
     *
     * @param path Пътят до файла, в който да бъдат записани данните.
     * @param data Данните, които трябва да бъдат записани.
     * @throws IOException ако възникне грешка по време на запис.
     */
    void write(String path, String data) throws IOException;
}
