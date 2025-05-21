package bg.tu_varna.sit.b1.f23621718.commands.menu.xml;

import bg.tu_varna.sit.b1.f23621718.commands.menu.*;
import bg.tu_varna.sit.b1.f23621718.data.traversals.*;
import bg.tu_varna.sit.b1.f23621718.menus.*;

import java.util.*;

/**
 * {@code ChangeTagXMLMenuCommand} е команда от менюто, която променя таг на XML елемент с дадено {@code id}.
 * <p>
 * Командата приема два параметъра:
 * <ul>
 *     <li>{@code id} – идентификатор на елемента, чийто таг ще бъде променен.</li>
 *     <li>{@code tag} – новият таг, който ще бъде зададен.</li>
 * </ul>
 * Тази команда използва {@link XMLElementTraversal#changeTag(String, String)} за да извърши промяната.
 *
 * @author f23621718
 * @see AbstractMenuCommand
 * @see XMLElementTraversal
 */
public class ChangeTagXMLMenuCommand extends AbstractMenuCommand {

    /**
     * Конструктор на командата за промяна на таг.
     *
     * @param menu Менюто, към което принадлежи тази команда.
     */
    public ChangeTagXMLMenuCommand(Menu menu) {
        super("changetag", "changes the tag for the element with <id> to <tag>", menu);
        addParameter("id");
        addParameter("tag");
    }

    private String id;
    private String tag;

    /**
     * Изпълнява логиката по промяна на тага на елемента с даденото {@code id}.
     *
     * @param params Списък с параметри: {@code id} и {@code tag}.
     */
    @Override
    protected void doWork(List<String> params) {
        XMLElementTraversal.changeTag(id, tag);
        log("Tag for element successfully changed.\n");
    }


    /**
     * Валидира параметрите и ги задава като вътрешни променливи.
     *
     * @param params Списък от параметри, получени от входа.
     */
    @Override
    protected void validate(List<String> params) {
        super.validate(params);
        this.id = params.getFirst();
        this.tag = params.getLast();
    }
}
