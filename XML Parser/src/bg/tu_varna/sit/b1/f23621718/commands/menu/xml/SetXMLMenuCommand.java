package bg.tu_varna.sit.b1.f23621718.commands.menu.xml;

import bg.tu_varna.sit.b1.f23621718.commands.menu.*;
import bg.tu_varna.sit.b1.f23621718.data.traversals.*;
import bg.tu_varna.sit.b1.f23621718.menus.*;

import java.util.*;

public class SetXMLMenuCommand extends AbstractMenuCommand {
    public SetXMLMenuCommand(Menu menu) {
        super("set", "set the <value> of the <key> attribute for element <id>", menu);
        addParameter("id");
        addParameter("key");
        addParameter("value");
    }

    @Override
    protected void doWork(List<String> params) {
        XMLElementTraversal.setAttribute(id, key, value);
        log(String.format("Successfully set value \"%s\" for attribute \"%s\" for element with id \"%s\"", value, key, id));
    }

    private String id;
    private String key;
    private String value;

    @Override
    protected void validate(List<String> params) {
        super.validate(params);

        this.id = params.getFirst();
        this.key = params.get(1);
        this.value = params.get(2);
    }
}


