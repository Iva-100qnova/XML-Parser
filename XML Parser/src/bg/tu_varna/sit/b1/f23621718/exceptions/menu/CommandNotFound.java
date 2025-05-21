package bg.tu_varna.sit.b1.f23621718.exceptions.menu;

/**
 * Изключение, което се хвърля, когато се опитва да се изпълни команда,
 * която не съществува или не е регистрирана в менюто.
 */
public class CommandNotFound extends RuntimeException {

    /**
     * Конструктор с параметър съобщение за грешка.
     *
     * @param message Съобщение, описващо грешката.
     */
    public CommandNotFound(String message) {
        super(message);
    }
}