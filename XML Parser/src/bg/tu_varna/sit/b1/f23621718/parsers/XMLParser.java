package bg.tu_varna.sit.b1.f23621718.parsers;


import bg.tu_varna.sit.b1.f23621718.contracts.parsers.*;
import bg.tu_varna.sit.b1.f23621718.exceptions.xml.*;
import bg.tu_varna.sit.b1.f23621718.generators.*;
import bg.tu_varna.sit.b1.f23621718.models.*;

import java.util.*;

public class XMLParser implements Parser<XMLElement> {

    private final Map<String, Integer> ids = new HashMap<>();

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

    public XMLElement parseAttributes(String s) {
        var blocks = s.split(" ");
        var element = new XMLElement(blocks[0]);
        for (int i = 1; i < blocks.length; i++) {
            var attribute = blocks[i].split("=");
            String value;
            if (attribute.length == 1) {
                value = "true";
            } else if (attribute.length != 2) {
                throw new InvalidXMLContent("Attribute is invalid. Tried to parse: " + blocks[i]);
            } else {
                value = attribute[1].substring(attribute[1].indexOf('"') + 1, attribute[1].lastIndexOf('"'));
            }
            element.addAttribute(attribute[0], value);
        }

        var id = addId(element.getAttribute("id"), this.ids);
        element.addAttribute("id", id);

        return element;
    }

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
            // Self-closing
            var el = parseAttributes(s.substring(1, indexOfFirstElementEnding - 1));
            result.add(el);
            result.addAll(parseElements(s.substring(indexOfFirstElementEnding + 1)));
            return result;
        }

        var element = parseAttributes(s.substring(1, indexOfFirstElementEnding));
        var closingTag = String.format("</%s>", element.getName());
        var elementEndingIndex = s.indexOf(closingTag);


        if (elementEndingIndex == -1) {
            // Not self-closing, but single tag (no inside content)
            result.add(element);
            result.addAll(parseElements(s.substring(indexOfFirstElementEnding + 1)));
            return result;
        }

        element.addChildren(parseElements(s.substring(indexOfFirstElementEnding + 1, elementEndingIndex)));
        result.add(element);
        result.addAll(parseElements(s.substring(elementEndingIndex + closingTag.length())));
        return result;
    }


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
