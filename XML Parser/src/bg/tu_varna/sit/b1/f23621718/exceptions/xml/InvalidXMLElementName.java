package bg.tu_varna.sit.b1.f23621718.exceptions.xml;

/**
 * Изключение, което се хвърля, когато името на XML елемент не е валидно.
 * Това е специфичен тип {@link InvalidXMLContent}, който указва, че даден XML елемент
 * съдържа недопустимо или неправилно име.
 */
public class InvalidXMLElementName extends InvalidXMLContent {

    /**
     * Конструктор с параметър съобщение за грешка.
     *
     * @param message Описателно съобщение за причината на изключението.
     */
    public InvalidXMLElementName(String message) {
        super(message);
    }
}