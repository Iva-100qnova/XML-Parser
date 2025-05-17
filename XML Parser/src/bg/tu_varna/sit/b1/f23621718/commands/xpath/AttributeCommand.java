package bg.tu_varna.sit.b1.f23621718.commands.xpath;


import bg.tu_varna.sit.b1.f23621718.models.*;

import java.util.*;

public class AttributeCommand extends BaseXPathCommand {

    private String attr;

    private List<String> attributesToPrint;

    @Override
    public String getResult() {
        StringBuilder sb = new StringBuilder();
        for (var attr : attributesToPrint)
            sb.append(attr).append("\n");
        return sb.toString();
    }

    public AttributeCommand(String attr) {
        this.attr = attr;
    }

    @Override
    public void execute() {
        var result = new ArrayList<String>();
        for (var el : getInput())
            if (el instanceof XMLElement && ((XMLElement) el).getAttribute(attr) != null)
                result.add(String.format("%s='%s'", attr, ((XMLElement) el).getAttribute(attr)));

        attributesToPrint = result;

        setElements(getInput());
    }
}
