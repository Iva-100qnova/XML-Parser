package bg.tu_varna.sit.b1.f23621718.models;

import bg.tu_varna.sit.b1.f23621718.contracts.models.*;
import bg.tu_varna.sit.b1.f23621718.exceptions.xml.*;
import bg.tu_varna.sit.b1.f23621718.validators.*;

import java.util.*;

/**
 * Клас, който представя XML елемент със собствено име, атрибути и деца.
 * Разширява абстрактния клас XMLContent и имплементира интерфейса XMLContentWithId.
 * Валидира името на елемента при създаване и предоставя методи за управление на атрибути и деца.
 */
public class XMLElement extends XMLContent implements XMLContentWithId {

    private String name;
    private final Map<String, String> attributes = new LinkedHashMap<>();
    private final List<XMLContent> children = new ArrayList<>();

    /**
     * Създава нов XML елемент с дадено име.
     * Името се валидира чрез XMLNameValidator.
     *
     * @param name името на елемента
     * @throws InvalidXMLElementName ако името не е валидно
     */
    public XMLElement(String name) {
        if (!(new XMLNameValidator()).validate(name))
            throw new InvalidXMLElementName(String.format("Element name \"%s\" is invalid", name));
        this.name = name;
    }

    /**
     * Връща името на XML елемента.
     *
     * @return името на елемента
     */
    public String getName() {
        return name;
    }

    /**
     * Задава ново име на XML елемента.
     * Името не може да съдържа интервали.
     *
     * @param name новото име на елемента
     * @throws InvalidXMLElementName ако името съдържа интервали
     */
    public void setName(String name) {
        if (name.contains(" "))
            throw new InvalidXMLElementName("Element name cannot contain a space!");
        this.name = name;
    }

    /**
     * Връща карта с атрибутите на елемента.
     *
     * @return карта с ключове и стойности на атрибути
     */
    public Map<String, String> getAttributes() {
        return attributes;
    }

    /**
     * Връща списък с деца на този елемент.
     *
     * @return списък от XMLContent деца
     */
    @Override
    public List<XMLContent> getChildren() {
        return children;
    }

    /**
     * Добавя атрибут към елемента.
     *
     * @param key името на атрибута
     * @param value стойността на атрибута
     */
    public void addAttribute(String key, String value) {
        attributes.put(key, value);
    }

    /**
     * Добавя дете към елемента.
     *
     * @param node XMLContent обект, който да се добави като дете
     */
    public void addChild(XMLContent node) {
        children.add(node);
    }

    /**
     * Добавя колекция от деца към елемента.
     *
     * @param nodes колекция от XMLContent обекти
     */
    public void addChildren(Collection<XMLContent> nodes) {
        children.addAll(nodes);
    }

    /**
     * Връща атрибутите като низ във формат key="value", разделени с интервали.
     *
     * @return низ с атрибутите или празен низ ако няма атрибути
     */
    public String getAttributesAsString() {
        if (attributes.isEmpty())
            return "";
        StringBuilder sb = new StringBuilder();
        for (var key : attributes.keySet()) {
            sb.append(" ").append(key).append("=\"").append(attributes.get(key)).append("\"");
        }
        return sb.deleteCharAt(0).toString();
    }

    /**
     * Връща низово представяне на XML елемента и неговите деца в XML формат.
     *
     * @return XML представяне като низ
     */
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

    /**
     * Връща стойността на атрибут с даден ключ.
     *
     * @param key ключът на атрибута
     * @return стойността или null ако липсва
     */
    public String getAttribute(String key) {
        return getAttributes().get(key);
    }

    /**
     * Премахва атрибут с даден ключ.
     *
     * @param key ключът на атрибута за премахване
     */
    public void removeAttribute(String key) {
        getAttributes().remove(key);
    }

    /**
     * Връща стойността на атрибута "id", която служи като уникален идентификатор.
     *
     * @return стойността на id атрибута или null
     */
    @Override
    public String getId() {
        return getAttribute("id");
    }

    /**
     * Задава стойност на атрибута "id".
     *
     * @param id новата стойност на id атрибута
     */
    @Override
    public void setId(String id) {
        addAttribute("id", id);
    }
}
