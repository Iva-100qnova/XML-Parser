package bg.tu_varna.sit.b1.f23621718.commands.menu.xml;

import bg.tu_varna.sit.b1.f23621718.commands.menu.*;
import bg.tu_varna.sit.b1.f23621718.data.traversals.*;
import bg.tu_varna.sit.b1.f23621718.menus.*;
import bg.tu_varna.sit.b1.f23621718.models.*;
import bg.tu_varna.sit.b1.f23621718.parsers.*;

import java.util.*;

/**
 * Команда, която изпълнява XPath заявки върху XML елемент, идентифициран с дадено ID.
 * <p>
 * Синтаксис на командата: {@code xpath <id> <XPath>}
 * <ul>
 *     <li>{@code id} – ID на XML елемента, върху който ще се изпълнява заявката.</li>
 *     <li>{@code XPath} – XPath заявка за извличане на информация от елемента и/или неговите деца.</li>
 * </ul>
 */
public class XPathXMLMenuCommand extends AbstractMenuCommand {

    private String id;
    private String xpath;

    /**
     * Създава нова команда XPathXMLMenuCommand със зададеното меню.
     *
     * @param menu менюто, към което принадлежи тази команда
     */
    public XPathXMLMenuCommand(Menu menu) {
        super("xpath", "run <xpath> queries on an element with <id>", menu);
        addParameter("id");
        addParameter("XPath");
    }

    /**
     * Изпълнява XPath заявката върху елемента с дадено ID.
     * Резултатите от заявката се извеждат в лог системата.
     *
     * @param params списък с параметри – ID на елемента и XPath заявка
     */
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

        log("Резултат от заявката:\n");
        log(parsedQueries.getLast().getResult());
    }

    /**
     * Валидира и извлича параметрите, необходими за изпълнение на командата.
     *
     * @param params списък с входни параметри
     * @throws IllegalArgumentException ако параметрите са невалидни или липсват
     */
    @Override
    protected void validate(List<String> params) {
        super.validate(params);

        this.id = params.getFirst();
        this.xpath = params.getLast();
    }
}
