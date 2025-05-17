package bg.tu_varna.sit.b1.f23621718.commands.xpath;


import bg.tu_varna.sit.b1.f23621718.models.*;

import java.util.*;

public class ChildCommand extends BaseXPathCommand {
    private String elementName;

    public ChildCommand(String elementName) {
        this.elementName = elementName;
    }

    @Override
    public void execute() {
        var result = new ArrayList<XMLContent>();
        for (var parent : getInput())
            for (var el : parent.getChildren())
                if (el instanceof XMLElement && ((XMLElement) el).getName().equals(elementName))
                    result.add(el);
        setElements(result);
    }

}
