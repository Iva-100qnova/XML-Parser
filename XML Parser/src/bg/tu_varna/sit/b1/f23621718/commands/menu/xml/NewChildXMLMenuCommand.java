package bg.tu_varna.sit.b1.f23621718.commands.menu.xml;

import bg.tu_varna.sit.b1.f23621718.commands.menu.*;
import bg.tu_varna.sit.b1.f23621718.data.traversals.*;
import bg.tu_varna.sit.b1.f23621718.menus.*;

import java.util.*;

/**
 * Команда от менюто, която добавя ново дете към XML елемент с даден идентификатор.
 * <p>
 * Използва {@link XMLElementTraversal#addChild(String)} за създаване и добавяне
 * на ново дете към съответния елемент. След успешното добавяне, извежда ID-то на новото дете.
 * <p>
 * Изисква един параметър:
 * <ul>
 *     <li><b>id</b> – идентификатор на родителския XML елемент</li>
 * </ul>
 */
public class NewChildXMLMenuCommand extends AbstractMenuCommand {

    /**
     * Конструктор, който инициализира командата с нейното име, описание и необходимите параметри.
     *
     * @param menu менюто, към което принадлежи командата
     */
    public NewChildXMLMenuCommand(Menu menu) {
        super("newchild", "add a new child for element with <id>", menu);
        addParameter("id");
    }

    /**
     * Изпълнява основната логика на командата – добавя ново дете към елемента
     * с посочения ID и извежда ID-то на новосъздадения елемент.
     *
     * @param params списък с един елемент: ID на родителския елемент
     */
    @Override
    protected void doWork(List<String> params) {
        var element = XMLElementTraversal.addChild(id);
        log("Child added successfully. \n");
        log("ID: " + element.getId());
        log("\n");
    }

    private String id;

    /**
     * Валидира и извлича ID параметъра от подадения списък.
     *
     * @param params списък с един параметър: ID на родителския елемент
     */
    @Override
    protected void validate(List<String> params) {
        super.validate(params);
        this.id = params.getFirst();
    }
}
