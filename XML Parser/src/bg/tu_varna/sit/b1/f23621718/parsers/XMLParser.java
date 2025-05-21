package bg.tu_varna.sit.b1.f23621718.parsers;

import bg.tu_varna.sit.b1.f23621718.contracts.parsers.*;
import bg.tu_varna.sit.b1.f23621718.exceptions.xml.*;
import bg.tu_varna.sit.b1.f23621718.generators.*;
import bg.tu_varna.sit.b1.f23621718.models.*;

import java.util.*;

/**
 * Клас, който парсва XML низ и го превръща в дървовидна структура от XMLElement и XMLContent.
 * Осигурява методи за парсване на атрибути и елементи, като също така осигурява уникални ID-та на елементите.
 */
public class XMLParser implements Parser<XMLElement> {

    private final Map<String, Integer> ids = new HashMap<>();

    /**
     * Генерира уникален ID за XML елемент, ако подаденият ID вече съществува.
     *
     * @param id оригиналният ID на елемента, може да е null
     * @param ids карта с честотата на срещане на ID-та
     * @return уникален ID, базиран на подадения или генериран нов
     */
    public static String addId(String id, Map<String, Integer> ids) {
        if (id == null) {
            var generator = new IDGenerator(10);
            id = generator.generate();
        }

        var freq = ids.get(id);
        if (freq == null)
            ids.put(id, 1);
        else {
            ids.put(id, freq + 1);
            id = String.format("%s_%d", id, freq + 1);
        }

        return id;
    }

    /**
     * Парсва низ с XML таг и атрибути и връща XMLElement.
     *
     * @param s низ, съдържащ име на таг и атрибути
     * @return създаден XML елемент с уникален ID
     * @throws InvalidXMLContent ако форматът на атрибутите е некоректен
     */
    public XMLElement parseAttributes(String s) {
        s = s.trim();

        int length = s.length();
        int i = 0;

        StringBuilder tagNameBuilder = new StringBuilder();
        while (i < length && !Character.isWhitespace(s.charAt(i))) {
            tagNameBuilder.append(s.charAt(i));
            i++;
        }
        String tagName = tagNameBuilder.toString();

        XMLElement element = new XMLElement(tagName);

        while (i < length) {
            while (i < length && Character.isWhitespace(s.charAt(i))) {
                i++;
            }
            if (i >= length) {
                break;
            }

            StringBuilder attrNameBuilder = new StringBuilder();
            while (i < length && !Character.isWhitespace(s.charAt(i)) && s.charAt(i) != '=') {
                attrNameBuilder.append(s.charAt(i));
                i++;
            }
            String attrName = attrNameBuilder.toString();

            if (i >= length || s.charAt(i) != '=') {
                element.addAttribute(attrName, "true");
                continue;
            }

            i++;

            while (i < length && Character.isWhitespace(s.charAt(i))) {
                i++;
            }
            if (i >= length || s.charAt(i) != '"') {
                throw new InvalidXMLContent("Attribute value must start with a quotation mark (\"). Problem around: " + s.substring(Math.max(0, i - 5), Math.min(length, i + 5)));
            }

            i++;
            StringBuilder attrValueBuilder = new StringBuilder();
            while (i < length && s.charAt(i) != '"') {
                attrValueBuilder.append(s.charAt(i));
                i++;
            }
            if (i >= length) {
                throw new InvalidXMLContent("Missing closing quotation mark for attribute \"" + attrName + "\" in: " + s);
            }
            i++;

            String attrValue = attrValueBuilder.toString();
            element.addAttribute(attrName, attrValue);
        }

        String originalId = element.getAttribute("id");
        String uniqueId = addId(originalId, this.ids);
        element.addAttribute("id", uniqueId);

        return element;
    }

    /**
     * Рекурсивно парсва съдържанието на XML низ в списък от XMLContent (текст и елементи).
     *
     * @param s низ с XML съдържание
     * @return списък с XMLContent обекти (XMLElement и XMLText)
     * @throws InvalidXMLContent при невалиден XML формат
     */
    public List<XMLContent> parseElements(String s) {
        s = s.trim();

        var result = new ArrayList<XMLContent>();

        if (s.isEmpty())
            return result;

        if (s.charAt(0) != '<') {
            result.add(new XMLText(s.replaceAll("\n +", "\n").replaceAll("\n\t+", "\n")));
            return result;
        }

        var indexOfFirstElementEnding = s.indexOf('>');
        if (indexOfFirstElementEnding == -1)
            throw new InvalidXMLContent("Invalid XML. Tag is not closed.");

        if (s.charAt(indexOfFirstElementEnding - 1) == '/') {
            var el = parseAttributes(s.substring(1, indexOfFirstElementEnding - 1));
            result.add(el);
            result.addAll(parseElements(s.substring(indexOfFirstElementEnding + 1)));
            return result;
        }

        var element = parseAttributes(s.substring(1, indexOfFirstElementEnding));
        var closingTag = String.format("</%s>", element.getName());
        var elementEndingIndex = s.indexOf(closingTag);

        if (elementEndingIndex == -1) {
            result.add(element);
            result.addAll(parseElements(s.substring(indexOfFirstElementEnding + 1)));
            return result;
        }

        element.addChildren(parseElements(s.substring(indexOfFirstElementEnding + 1, elementEndingIndex)));
        result.add(element);
        result.addAll(parseElements(s.substring(elementEndingIndex + closingTag.length())));
        return result;
    }

    /**
     * Парсва XML низ в XMLElement, проверява за един коренов елемент.
     *
     * @param s низ с XML
     * @return кореновият XML елемент
     * @throws InvalidXMLContent ако има повече от един корен, или съдържанието е невалидно
     */
    @Override
    public XMLElement parse(String s) {
        if (s.isBlank())
            return null;

        var result = parseElements(s);
        if (result.size() > 1)
            throw new InvalidXMLContent("Invalid XML. Multiple root elements found.");

        if (result.isEmpty())
            throw new InvalidXMLContent("Invalid XML. File is empty.");

        var first = result.getFirst();
        if (!(first instanceof XMLElement))
            throw new InvalidXMLContent("Invalid XML. Root must be an XML element.");
        return (XMLElement) first;
    }
}
