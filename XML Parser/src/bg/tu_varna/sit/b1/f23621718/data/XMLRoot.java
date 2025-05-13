package bg.tu_varna.sit.b1.f23621718.data;

import bg.tu_varna.sit.b1.f23621718.models.*;

public class XMLRoot {
    private static XMLElement rootElement;

    public static void setRootElement(XMLElement rootElement) {
        XMLRoot.rootElement = rootElement;
    }

    public static XMLElement getRootElement() {
        return rootElement;
    }
}
