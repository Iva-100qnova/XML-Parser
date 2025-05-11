package bg.tu_varna.sit.b1.f23621718.models;


import bg.tu_varna.sit.b1.f23621718.exceptions.xml.InvalidXMLText;
import bg.tu_varna.sit.b1.f23621718.validators.XMLTextValidator;

import java.util.List;
import java.util.ArrayList;

public class XMLText extends XMLContent {
    private final String text;

    public XMLText(String text) {
        if (!(new XMLTextValidator()).validate(text))
            throw new InvalidXMLText(String.format("Element text is invalid (might contain XML tags): \"%s\" ", text));
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public List<XMLContent> getChildren() {
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        return getText();
    }
}
