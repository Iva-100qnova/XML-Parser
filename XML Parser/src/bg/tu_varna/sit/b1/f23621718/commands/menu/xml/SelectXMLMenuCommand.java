package bg.tu_varna.sit.b1.f23621718.commands.menu.xml;

import bg.tu_varna.sit.b1.f23621718.commands.menu.*;
import bg.tu_varna.sit.b1.f23621718.data.traversals.*;
import bg.tu_varna.sit.b1.f23621718.menus.*;

import java.util.*;

public class SelectXMLMenuCommand extends AbstractMenuCommand {
    public SelectXMLMenuCommand(Menu menu) {
        super("select", "print the value of the <key> attribute for element <id>", menu);
        addParameter("id");
        addParameter("key");
    }

    @Override
    protected void doWork(List<String> params) {
        log(XMLElementTraversal.getAttribute(id, key));
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

