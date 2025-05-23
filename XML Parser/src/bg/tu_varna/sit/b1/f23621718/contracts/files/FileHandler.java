package bg.tu_varna.sit.b1.f23621718.contracts.files;

/**
 * Обединяващ интерфейс за работа с файлове, включващ четене и запис.
 *
 * <p>Наследява интерфейсите {@link FileReader} и {@link FileWriter}, като предоставя
 * цялостна абстракция за файлови операции.</p>
 *
 * <p>Типичната реализация на този интерфейс трябва да поддържа както
 * отваряне и прочитане на съдържание от файл, така и записване на данни в файл.</p>
 */
public interface FileHandler extends FileReader, FileWriter {
}