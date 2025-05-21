package bg.tu_varna.sit.b1.f23621718.exceptions;

/**
 * Изключение, което се хвърля при невалиден XML път по време на обработка.
 */
public class InvalidXMLPathException extends RuntimeException {
    public InvalidXMLPathException(String message) {
        super(message);
    }
}