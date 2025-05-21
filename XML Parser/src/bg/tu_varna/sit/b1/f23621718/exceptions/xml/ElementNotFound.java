package bg.tu_varna.sit.b1.f23621718.exceptions.xml;

/**
 * Изключение, което се хвърля, когато XML елемент с дадено ID не бъде намерен.
 * Използва се при търсене на елементи в XML дърво, когато търсеният елемент липсва.
 */
public class ElementNotFound extends RuntimeException {

    /**
     * Конструктор с параметър съобщение за грешка.
     *
     * @param message Съобщение, описващо причината за изключението.
     */
    public ElementNotFound(String message) {
        super(message);
    }
}