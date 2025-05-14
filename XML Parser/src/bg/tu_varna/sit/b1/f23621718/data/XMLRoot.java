package bg.tu_varna.sit.b1.f23621718.data;

import bg.tu_varna.sit.b1.f23621718.data.traversals.*;
import bg.tu_varna.sit.b1.f23621718.models.*;

import java.util.*;

public class XMLRoot {
    private static XMLElement rootElement;
    private static Map<String, XMLElement> mappedElements;

    public static void setRootElement(XMLElement rootElement) {
        XMLRoot.rootElement = rootElement;
        resetMapping();
    }

    public static XMLElement getRootElement() {
        return rootElement;
    }

    public static Map<String, XMLElement> getMappedElements() {
        return new HashMap<>(mappedElements);
    }

    public static void resetMapping() {
        mappedElements = XMLElementTraversal.getAllIds();
    }
}
