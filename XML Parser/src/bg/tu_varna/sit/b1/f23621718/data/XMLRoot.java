package bg.tu_varna.sit.b1.f23621718.data;

import bg.tu_varna.sit.b1.f23621718.data.traversals.*;
import bg.tu_varna.sit.b1.f23621718.models.*;

import java.util.*;

/**
 * Singleton клас, който държи кореновия XML елемент и мапинг между ID-та и
 * съответните XML елементи в документа.
 * <p>
 * Позволява достъп до корена на XML дървото и осигурява бърз достъп до
 * елементите чрез техните уникални ID-та.
 */
public class XMLRoot {
    /**
     * Кореновият XML елемент на документа.
     */
    private static XMLElement rootElement;

    /**
     * Map, съдържащ връзка от уникални ID-та към съответните {@link XMLElement} обекти.
     */
    private static Map<String, XMLElement> mappedElements;

    /**
     * Задава коренов елемент на XML документа.
     * Автоматично нулира мапинга на ID-та.
     *
     * @param rootElement Кореновият {@link XMLElement}.
     */
    public static void setRootElement(XMLElement rootElement) {
        XMLRoot.rootElement = rootElement;
        resetMapping();
    }

    /**
     * Връща кореновия XML елемент.
     *
     * @return Кореновият {@link XMLElement}.
     */
    public static XMLElement getRootElement() {
        return rootElement;
    }

    /**
     * Връща копие на текущия Map с мапинг от ID към {@link XMLElement}.
     *
     * @return Map с ID-та и съответните елементи.
     */
    public static Map<String, XMLElement> getMappedElements() {
        return new HashMap<>(mappedElements);
    }

    /**
     * Обновява мапинга между ID-та и XML елементите, като извиква
     * {@link XMLElementTraversal#getAllIds()} за новото дърво.
     */
    public static void resetMapping() {
        mappedElements = XMLElementTraversal.getAllIds();
    }
}
