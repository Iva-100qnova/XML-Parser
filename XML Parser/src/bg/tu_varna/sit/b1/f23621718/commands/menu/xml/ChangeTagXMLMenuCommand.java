package bg.tu_varna.sit.b1.f23621718.commands.menu.xml;

import bg.tu_varna.sit.b1.f23621718.commands.menu.*;
import bg.tu_varna.sit.b1.f23621718.data.traversals.*;
import bg.tu_varna.sit.b1.f23621718.menus.*;

import java.util.*;

public class ChangeTagXMLMenuCommand extends AbstractMenuCommand {
    public ChangeTagXMLMenuCommand(Menu menu) {
        super("changetag", "changes the tag for the element with <id> to <tag>", menu);
        addParameter("id");
        addParameter("tag");
    }

    @Override
    protected void doWork(List<String> params) {
        XMLElementTraversal.changeTag(id, tag);
        log("Tag for element successfully changed.\n");
    }

    private String id;
    private String tag;

    @Override
    protected void validate(List<String> params) {
        super.validate(params);

        this.id = params.getFirst();
        this.tag = params.getLast();
    }
}
