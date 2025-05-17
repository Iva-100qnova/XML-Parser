package bg.tu_varna.sit.b1.f23621718.commands.menu.xml;

import bg.tu_varna.sit.b1.f23621718.commands.menu.*;
import bg.tu_varna.sit.b1.f23621718.data.traversals.*;
import bg.tu_varna.sit.b1.f23621718.menus.*;
import bg.tu_varna.sit.b1.f23621718.models.*;
import bg.tu_varna.sit.b1.f23621718.parsers.*;

import java.util.*;

public class XPathXMLMenuCommand extends AbstractMenuCommand {
    public XPathXMLMenuCommand(Menu menu) {
        super("xpath", "run <xpath> queries on an element with <id>", menu);
        addParameter("id");
        addParameter("XPath");
    }

    @Override
    protected void doWork(List<String> params) {
        var el = XMLElementTraversal.getElementById(id);
        var parser = new XPathParser();
        var parsedQueries = parser.parse(xpath);

        List<XMLContent> elements = new ArrayList<>();
        elements.add(el);

        for (var query : parsedQueries) {
            query.setInput(elements);
            query.execute();
            elements = query.getElements();
        }
        log("Query result: \n");
        log(parsedQueries.getLast().getResult());
    }

    private String id;
    private String xpath;

    @Override
    protected void validate(List<String> params) {
        super.validate(params);

        this.id = params.getFirst();
        this.xpath = params.getLast();
    }
}