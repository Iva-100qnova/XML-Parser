package bg.tu_varna.sit.b1.f23621718.commands.xpath;


import bg.tu_varna.sit.b1.f23621718.models.*;

import java.util.*;

public class ComparisonFilterCommand extends BaseXPathCommand {
    private String key;
    private String value;


    public ComparisonFilterCommand(String key, String value) {
        this.key = key;
        this.value = value;
    }


    @Override
    public void execute() {
        var result = new ArrayList<XMLContent>();
        for (var el : getInput())
            if (el instanceof XMLElement) {
                var attr = ((XMLElement) el).getAttribute(key);
                if (attr != null && attr.equals(value))
                    result.add(el);
            }
        setElements(result);
    }
}
