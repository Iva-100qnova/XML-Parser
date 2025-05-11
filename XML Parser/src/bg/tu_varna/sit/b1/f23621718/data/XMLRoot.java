package bg.tu_varna.sit.b1.f23621718.data;

import bg.tu_varna.sit.b1.f23621718.models.*;

public class XMLRoot {
    private static XMLContent rootElement;

    public static void setRootElement(XMLContent rootElement) {
        XMLRoot.rootElement = rootElement;
    }

    public static XMLContent getRootElement() {
        return rootElement;
    }
}
