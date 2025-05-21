package bg.tu_varna.sit.b1.f23621718.models;

import bg.tu_varna.sit.b1.f23621718.exceptions.xml.InvalidXMLText;
import bg.tu_varna.sit.b1.f23621718.validators.XMLTextValidator;

import java.util.List;
import java.util.ArrayList;

/**
 * Клас, който представя текстово съдържание в XML.
 * Текстът се валидира с помощта на XMLTextValidator, за да се избегнат недопустими XML символи или тагове.
 * Текстовото съдържание няма деца.
 */
public class XMLText extends XMLContent {
    private final String text;

    /**
     * Създава нов XML текстов възел с даден текст.
     * Валидира текста с XMLTextValidator.
     *
     * @param text текстовото съдържание
     * @throws InvalidXMLText ако текстът съдържа недопустими символи или XML тагове
     */
    public XMLText(String text) {
        if (!(new XMLTextValidator()).validate(text))
            throw new InvalidXMLText(String.format("Element text is invalid (might contain XML tags): \"%s\" ", text));
        this.text = text;
    }

    /**
     * Връща текста на XML възела.
     *
     * @return текстовото съдържание
     */
    public String getText() {
        return text;
    }

    /**
     * Текстовото съдържание няма деца, връща празен списък.
     *
     * @return празен списък
     */
    public List<XMLContent> getChildren() {
        return new ArrayList<>();
    }

    /**
     * Връща текста като низово представяне на този XML възел.
     *
     * @return текстът
     */
    @Override
    public String toString() {
        return getText();
    }
}
