package bg.tu_varna.sit.b1.f23621718.commands.menu.xml;

import bg.tu_varna.sit.b1.f23621718.commands.menu.*;
import bg.tu_varna.sit.b1.f23621718.data.traversals.*;
import bg.tu_varna.sit.b1.f23621718.exceptions.menu.*;
import bg.tu_varna.sit.b1.f23621718.menus.*;

import java.util.*;

public class ChildrenXMLMenuCommand extends AbstractMenuCommand {
    public ChildrenXMLMenuCommand(Menu menu) {
        super("children", "get all child attributes for children of with <id>", menu);
        addParameter("id");
    }

    @Override
    protected void doWork(List<String> params) {
        for (var child : XMLElementTraversal.getChildElements(id)) {
            log("=== Printing attributes for child === \n");
            var attributes = child.getAttributes();
            for (var key : attributes.keySet()) {
                log(String.format("%s = \"%s\"\n", key, attributes.get(key)));
            }
        }

    }

    private String id;

    @Override
    protected void validate(List<String> params) {
        super.validate(params);

        this.id = params.getFirst();
    }
}

