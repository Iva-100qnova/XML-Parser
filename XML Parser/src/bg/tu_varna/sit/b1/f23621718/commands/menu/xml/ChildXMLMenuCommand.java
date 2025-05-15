package bg.tu_varna.sit.b1.f23621718.commands.menu.xml;

import bg.tu_varna.sit.b1.f23621718.commands.menu.*;
import bg.tu_varna.sit.b1.f23621718.data.traversals.*;
import bg.tu_varna.sit.b1.f23621718.exceptions.menu.*;
import bg.tu_varna.sit.b1.f23621718.menus.*;

import java.util.*;

public class ChildXMLMenuCommand extends AbstractMenuCommand {
    public ChildXMLMenuCommand(Menu menu) {
        super("child", "gets the n-th child of element with <id>", menu);
        addParameter("id");
        addParameter("n");
    }

    @Override
    protected void doWork(List<String> params) {
        var children = XMLElementTraversal.getChildElements(id);
        log(String.format("=== Printing child with index %d === \n", n));
        log(children.get(n - 1).toString());
    }

    private String id;
    private Integer n;

    @Override
    protected void validate(List<String> params) {
        super.validate(params);

        this.id = params.getFirst();
        try {
            this.n = Integer.valueOf(params.getLast());
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Could not parse integer n.");
        }
    }
}
