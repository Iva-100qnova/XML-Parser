package bg.tu_varna.sit.b1.f23621718.commands.menu.xml;

import bg.tu_varna.sit.b1.f23621718.commands.menu.*;
import bg.tu_varna.sit.b1.f23621718.data.traversals.*;
import bg.tu_varna.sit.b1.f23621718.menus.*;

import java.util.*;

public class DeleteXMLMenuCommand extends AbstractMenuCommand {
    public DeleteXMLMenuCommand(Menu menu) {
        super("delete", "delete the attribute with <key> attribute for element <id>", menu);
        addParameter("id");
        addParameter("key");
    }

    @Override
    protected void doWork(List<String> params) {

        XMLElementTraversal.getElementById(id).removeAttribute(key);
        log("Attribute removed successfully.\n");
    }

    private String id;
    private String key;

    @Override
    protected void validate(List<String> params) {
        super.validate(params);

        this.id = params.getFirst();
        this.key = params.get(1);
    }
}

