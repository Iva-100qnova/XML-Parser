package bg.tu_varna.sit.b1.f23621718.commands.menu.xml;

import bg.tu_varna.sit.b1.f23621718.commands.menu.*;
import bg.tu_varna.sit.b1.f23621718.data.traversals.*;
import bg.tu_varna.sit.b1.f23621718.menus.*;

import java.util.*;

public class NewChildXMLMenuCommand extends AbstractMenuCommand {
    public NewChildXMLMenuCommand(Menu menu) {
        super("newchild", "add a new child for element with <id>", menu);
        addParameter("id");
    }

    @Override
    protected void doWork(List<String> params) {


        var element = XMLElementTraversal.addChild(id);
        log("Child added successfully. \n");
        log("ID: " + element.getId());
        log("\n");

    }

    private String id;

    @Override
    protected void validate(List<String> params) {
        super.validate(params);

        this.id = params.getFirst();
    }
}
