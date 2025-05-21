package bg.tu_varna.sit.b1.f23621718.exceptions.menu;

/**
 * Изключение, което се хвърля при невалиден вход (например грешен брой или формат на параметри)
 * при изпълнение на команда в менюто.
 */
public class InvalidInputException extends RuntimeException {

    /**
     * Конструктор с параметър съобщение за грешка.
     *
     * @param message Съобщение, описващо грешката.
     */
    public InvalidInputException(String message) {
        super(message);
    }
}
