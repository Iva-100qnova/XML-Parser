package bg.tu_varna.sit.b1.f23621718.commands.menu.xml;

import bg.tu_varna.sit.b1.f23621718.commands.menu.*;
import bg.tu_varna.sit.b1.f23621718.data.traversals.*;
import bg.tu_varna.sit.b1.f23621718.exceptions.menu.*;
import bg.tu_varna.sit.b1.f23621718.menus.*;

import java.util.*;

/**
 * {@code ChildrenXMLMenuCommand} е команда от менюто, която извежда всички атрибути
 * на децата на XML елемент, идентифициран чрез {@code id}.
 * <p>
 * За всеки дъщерен елемент, неговите атрибути се извеждат във формат {@code ключ = "стойност"}.
 *
 * <p>Използва {@link XMLElementTraversal#getChildElements(String)} за достъп до децата.
 *
 * @author f23621718
 * @see AbstractMenuCommand
 * @see XMLElementTraversal
 */
public class ChildrenXMLMenuCommand extends AbstractMenuCommand {

    private String id;

    /**
     * Конструктор на командата за извеждане на атрибутите на децата.
     *
     * @param menu Менюто, към което принадлежи тази команда.
     */
    public ChildrenXMLMenuCommand(Menu menu) {
        super("children", "get all child attributes for children of with <id>", menu);
        addParameter("id");
    }

    /**
     * Изпълнява логиката по намиране и извеждане на атрибутите на всички деца
     * на елемент с даденото {@code id}.
     *
     * @param params Списък с един параметър: {@code id}.
     */
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


    /**
     * Валидира входните параметри и извлича {@code id}.
     *
     * @param params Списък от параметри, получени от входа.
     */
    @Override
    protected void validate(List<String> params) {
        super.validate(params);
        this.id = params.getFirst();
    }
}
