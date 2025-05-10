package bg.tu_varna.sit.b1.f23621718.models;

import exceptions.InvalidXMLText;
import validators.XMLTextValidator;

import java.util.ArrayList;
import java.util.List;

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
