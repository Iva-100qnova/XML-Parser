package bg.tu_varna.sit.b1.f23621718.exceptions.xml;

/**
 * Изключение, което се хвърля при опит за обработка на невалидно XML съдържание.
 * Това може да се случи, ако структурата или данните на XML документа не отговарят
 * на очакваните формати или правила.
 */
public class InvalidXMLContent extends RuntimeException {

    /**
     * Конструктор с параметър съобщение за грешка.
     *
     * @param message Описателно съобщение за причината на изключението.
     */
    public InvalidXMLContent(String message) {
        super(message);
    }
}
