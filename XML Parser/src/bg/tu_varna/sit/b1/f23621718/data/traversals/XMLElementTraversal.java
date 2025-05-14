package bg.tu_varna.sit.b1.f23621718.data.traversals;

import bg.tu_varna.sit.b1.f23621718.data.*;
import bg.tu_varna.sit.b1.f23621718.exceptions.xml.*;
import bg.tu_varna.sit.b1.f23621718.models.*;
import bg.tu_varna.sit.b1.f23621718.parsers.*;

import java.util.*;

public class XMLElementTraversal {
    private static Map<String, Integer> ids = new HashMap<>();

    public static Map<String, XMLElement> getAllIds() {
        return getAllIds(XMLRoot.getRootElement(), true);
    }

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

    public static XMLElement getElementById(String id) {
        var mappedElements = XMLRoot.getMappedElements();
        var element = mappedElements.get(id);
        if (element == null)
            throw new ElementNotFound("Could not find element with id: " + id);
        return element;
    }

    public static String getAttribute(String id, String key) {
        var element = getElementById(id);
        return element.getAttribute(key);
    }

    public static void removeAttribute(String id, String key) {
        var element = getElementById(id);
        element.removeAttribute(key);
        checkForIdChange(key);
    }

    private static void checkForIdChange(String key) {
        if (key.equals("id")) {
            XMLRoot.resetMapping();
        }
    }


    public static void setAttribute(String id, String key, String value) {
        var element = getElementById(id);
        element.addAttribute(key, value);
        checkForIdChange(key);
    }

    public static List<XMLElement> getInnerElements() {
        return getInnerElements(XMLRoot.getRootElement());
    }

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

    public static String getText(XMLContent root) {
        StringBuilder sb = new StringBuilder();
        if (root instanceof XMLText) {
            sb.append(((XMLText) root).getText());
        }

        for (var element : root.getChildren()) {
            var res = getText(element);
            if (!res.isEmpty())
                sb.append(res);
        }

        return sb.toString();
    }

    public static void addChild(String id) {
        var element = getElementById(id);
        element.addChild(new XMLElement(""));
        XMLRoot.resetMapping();
    }

}
