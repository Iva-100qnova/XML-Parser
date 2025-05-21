package bg.tu_varna.sit.b1.f23621718.exceptions.menu;

/**
 * Изключение, което се хвърля, когато се опитва да се използва файл без да е зададен път до него.
 * Обикновено се използва, ако командата изисква отворен файл, но файлът не е зададен.
 */
public class NoFilePathException extends RuntimeException {

    /**
     * Конструктор с параметър съобщение за грешка.
     *
     * @param message Съобщение, описващо грешката.
     */
    public NoFilePathException(String message) {
        super(message);
    }
}

