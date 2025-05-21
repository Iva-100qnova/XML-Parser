package bg.tu_varna.sit.b1.f23621718.exceptions.xml;

/**
 * Изключение, което се хвърля, когато XML текстовото съдържание е невалидно.
 * Това е специализиран тип {@link InvalidXMLContent}, което индикира проблем с текста в XML елемент.
 */
public class InvalidXMLText extends InvalidXMLContent {

    /**
     * Конструктор с параметър съобщение за грешка.
     *
     * @param message Описателно съобщение за причината на изключението.
     */
    public InvalidXMLText(String message) {
        super(message);
    }
}
