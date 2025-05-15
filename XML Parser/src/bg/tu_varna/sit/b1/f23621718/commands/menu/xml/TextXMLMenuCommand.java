package bg.tu_varna.sit.b1.f23621718.commands.menu.xml;

import bg.tu_varna.sit.b1.f23621718.commands.menu.*;
import bg.tu_varna.sit.b1.f23621718.data.traversals.*;
import bg.tu_varna.sit.b1.f23621718.menus.*;

import java.util.*;

public class TextXMLMenuCommand extends AbstractMenuCommand {
    public TextXMLMenuCommand(Menu menu) {
        super("text", "print all text from the element with <id> or elements inside of it", menu);
        addParameter("id");
    }

    @Override
    protected void doWork(List<String> params) {
        var text = XMLElementTraversal.getText(id);
        log("Printing all text inside of the element:\n\n");
        log(text);
    }

    private String id;

    @Override
    protected void validate(List<String> params) {
        super.validate(params);

        this.id = params.getFirst();
    }
}

