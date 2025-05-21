package bg.tu_varna.sit.b1.f23621718.data.traversals;

import bg.tu_varna.sit.b1.f23621718.data.*;
import bg.tu_varna.sit.b1.f23621718.exceptions.xml.*;
import bg.tu_varna.sit.b1.f23621718.models.*;
import bg.tu_varna.sit.b1.f23621718.parsers.*;

import java.util.*;

/**
 * Утилитарен клас за обхождане и манипулиране на XML елементи.
 * <p>
 * Предоставя методи за:
 * <ul>
 *     <li>Намиране и валидиране на уникални ID-та</li>
 *     <li>Достъп до деца и атрибути на XML елементи</li>
 *     <li>Добавяне и премахване на елементи и атрибути</li>
 *     <li>Промяна на тагове и получаване на текстово съдържание</li>
 * </ul>
 */
public class XMLElementTraversal {

    private static Map<String, Integer> ids = new HashMap<>();

    /**
     * Връща всички елементи с ID-та в текущия XML документ.
     *
     * @return Map от ID към съответния {@link XMLElement}.
     */
    public static Map<String, XMLElement> getAllIds() {
        return getAllIds(XMLRoot.getRootElement(), true);
    }

    /**
     * Обхожда рекурсивно подадения коренов елемент и събира всички XML елементи с ID-та.
     *
     * @param root  Началният {@link XMLContent} елемент.
     * @param clear Дали да се изчисти вътрешната структура от предишно обхождане.
     * @return Map от ID към {@link XMLElement}.
     */
    public static Map<String, XMLElement> getAllIds(XMLContent root, boolean clear) {
        if (clear)
            ids.clear();

        var result = new HashMap<String, XMLElement>();

        if (root instanceof XMLElement) {
            var id = ((XMLElement) root).getId();
            var newId = XMLParser.addId(id, ids);
            ((XMLElement) root).setId(newId);
            result.put(newId, (XMLElement) root);
        }

        for (var element : root.getChildren()) {
            var childResult = getAllIds(element, false);
            result.putAll(childResult);
        }

        return result;
    }

    /**
     * Връща {@link XMLElement} по зададено ID.
     *
     * @param id Уникалното ID.
     * @return Съответният елемент.
     * @throws ElementNotFound ако елемент с това ID не съществува.
     */
    public static XMLElement getElementById(String id) {
        var mappedElements = XMLRoot.getMappedElements();
        var element = mappedElements.get(id);
        if (element == null)
            throw new ElementNotFound("Could not find element with id: " + id);
        return element;
    }

    /**
     * Връща стойността на атрибут от елемент по ID.
     *
     * @param id  ID на елемента.
     * @param key Името на атрибута.
     * @return Стойността на атрибута или null, ако липсва.
     */
    public static String getAttribute(String id, String key) {
        var element = getElementById(id);
        return element.getAttribute(key);
    }

    /**
     * Премахва атрибут от елемент и обновява мапинга при нужда.
     *
     * @param id  ID на елемента.
     * @param key Името на атрибута.
     */
    public static void removeAttribute(String id, String key) {
        var element = getElementById(id);
        element.removeAttribute(key);
        checkForIdChange(key);
    }

    /**
     * Задава атрибут към елемент и обновява мапинга при нужда.
     *
     * @param id    ID на елемента.
     * @param key   Име на атрибута.
     * @param value Стойност на атрибута.
     */
    public static void setAttribute(String id, String key, String value) {
        var element = getElementById(id);
        element.addAttribute(key, value);
        checkForIdChange(key);
    }

    /**
     * Проверява дали даден ключ е "id" и ако е, нулира мапинга.
     *
     * @param key Атрибутен ключ.
     */
    private static void checkForIdChange(String key) {
        if (key.equals("id")) {
            XMLRoot.resetMapping();
        }
    }

    /**
     * Връща всички вътрешни {@link XMLElement} от документа.
     *
     * @return Списък от всички вътрешни XML елементи.
     */
    public static List<XMLElement> getInnerElements() {
        return getInnerElements(XMLRoot.getRootElement());
    }

    /**
     * Рекурсивно събира всички вътрешни {@link XMLElement} от подадения корен.
     *
     * @param root Коренов {@link XMLContent}.
     * @return Списък от вътрешни елементи.
     */
    public static List<XMLElement> getInnerElements(XMLContent root) {
        List<XMLElement> result = new ArrayList<>();
        for (var element : root.getChildren()) {
            if (element instanceof XMLElement) {
                result.add((XMLElement) element);
            }
            result.addAll(getInnerElements(element));
        }
        return result;
    }

    /**
     * Връща списък с директните деца {@link XMLElement} на елемент по ID.
     *
     * @param id ID на родителския елемент.
     * @return Списък с деца.
     */
    public static List<XMLElement> getChildElements(String id) {
        return getChildElements(getElementById(id));
    }

    /**
     * Връща списък с директните деца {@link XMLElement} на подадения елемент.
     *
     * @param root Родителски {@link XMLContent}.
     * @return Списък с деца.
     */
    public static List<XMLElement> getChildElements(XMLContent root) {
        List<XMLElement> result = new ArrayList<>();
        for (var element : root.getChildren()) {
            if (element instanceof XMLElement) {
                result.add((XMLElement) element);
            }
        }
        return result;
    }

    /**
     * Връща текстовото съдържание на елемент по ID.
     *
     * @param id ID на елемента.
     * @return Текстовото съдържание.
     */
    public static String getText(String id) {
        return getText(getElementById(id));
    }

    /**
     * Рекурсивно събира текстовото съдържание от XML структура.
     *
     * @param root Начален {@link XMLContent}.
     * @return Текстът, събран от всички {@link XMLText} елементи.
     */
    public static String getText(XMLContent root) {
        StringBuilder sb = new StringBuilder();
        if (root instanceof XMLText) {
            sb.append(((XMLText) root).getText()).append("\n");
        }

        for (var element : root.getChildren()) {
            var res = getText(element);
            if (!res.isEmpty())
                sb.append(res);
        }

        return sb.toString();
    }

    /**
     * Добавя ново дете към елемент с дадено ID.
     *
     * @param id ID на родителския елемент.
     * @return Новосъздаденият {@link XMLElement}.
     */
    public static XMLElement addChild(String id) {
        var element = getElementById(id);
        var newEl = new XMLElement("newChild");
        element.addChild(newEl);
        XMLRoot.resetMapping();
        return newEl;
    }

    /**
     * Променя таг името на даден елемент.
     *
     * @param id  ID на елемента.
     * @param tag Ново име на тага.
     * @return Модифицираният {@link XMLElement}.
     */
    public static XMLElement changeTag(String id, String tag) {
        var element = getElementById(id);
        element.setName(tag);
        return element;
    }
}
