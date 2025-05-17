package bg.tu_varna.sit.b1.f23621718.commands.xpath;

import bg.tu_varna.sit.b1.f23621718.models.*;

import java.util.*;

public class FindAllCommand extends BaseXPathCommand {
    private final String elementName;

    public FindAllCommand(String elementName) {
        this.elementName = elementName;
    }


    @Override
    public void execute() {
        var result = new ArrayList<XMLContent>();
        Stack<XMLContent> queue = new Stack<>();
        for (var el : getInput())
            queue.push(el);

        while (!queue.empty()) {
            var top = queue.peek();
            queue.pop();
            for (var el : top.getChildren())
                queue.push(el);
            if (top instanceof XMLElement && ((XMLElement) top).getName().equals(elementName))
                result.add(top);
        }

        setElements(result);
    }

}