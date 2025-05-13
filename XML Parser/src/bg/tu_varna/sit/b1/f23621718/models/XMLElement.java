package bg.tu_varna.sit.b1.f23621718.models;


import bg.tu_varna.sit.b1.f23621718.exceptions.xml.*;
import bg.tu_varna.sit.b1.f23621718.validators.*;

import java.util.*;

public class XMLElement extends XMLContent {
    private final String name;
    private final Map<String, String> attributes = new LinkedHashMap<>();
    private final List<XMLContent> children = new ArrayList<>();


    public XMLElement(String name) {
        if (!(new XMLNameValidator()).validate(name))
            throw new InvalidXMLElementName(String.format("Element name \"%s\" is invalid", name));
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    @Override
    public List<XMLContent> getChildren() {
        return children;
    }

    public void addAttribute(String key, String value) {
        attributes.put(key, value);
    }

    public void addChild(XMLContent node) {
        children.add(node);
    }

    public void addChildren(Collection<XMLContent> nodes) {
        children.addAll(nodes);
    }

    public String getAttributesAsString() {
        if (attributes.isEmpty())
            return "";
        StringBuilder sb = new StringBuilder();
        for (var key : attributes.keySet()) {
            sb.append(" ").append(key).append("=\"").append(attributes.get(key)).append("\"");
        }
        return sb.deleteCharAt(0).toString();
    }


    @Override
    public String toString() {
        var attributes = getAttributesAsString();

        if (getChildren().isEmpty()) {
            return String.format("<%s %s/>", getName(), attributes);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<").append(getName());
        if(!attributes.isEmpty())
            sb.append(" ").append(attributes);
        sb.append(">\n");
        sb.append(super.toString());
        sb.append(String.format("</%s>", getName()));
        return sb.toString();
    }

    public String getAttribute(String key) {
        return getAttributes().get(key);
    }
}
