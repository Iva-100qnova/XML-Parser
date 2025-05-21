package bg.tu_varna.sit.b1.f23621718.commands.menu.xml;

import bg.tu_varna.sit.b1.f23621718.commands.menu.*;
import bg.tu_varna.sit.b1.f23621718.data.traversals.*;
import bg.tu_varna.sit.b1.f23621718.menus.*;

import java.util.*;

/**
 * Команда от менюто, която изтрива атрибут с даден ключ от XML елемент с определен ID.
 * <p>
 * Използва {@link XMLElementTraversal#getElementById(String)} за намиране на елемента,
 * след което премахва съответния атрибут чрез {@code removeAttribute}.
 * <p>
 * Приема два задължителни параметъра:
 * <ul>
 *     <li><b>id</b> – идентификатор на XML елемента</li>
 *     <li><b>key</b> – име на атрибута, който да се премахне</li>
 * </ul>
 */
public class DeleteXMLMenuCommand extends AbstractMenuCommand {

    /**
     * Конструктор, който инициализира командата с нейното име, описание и необходимите параметри.
     *
     * @param menu менюто, към което принадлежи командата
     */
    public DeleteXMLMenuCommand(Menu menu) {
        super("delete", "delete the attribute with <key> attribute for element <id>", menu);
        addParameter("id");
        addParameter("key");
    }

    /**
     * Изпълнява основната логика на командата – премахване на атрибут по зададен ключ
     * от XML елемент с даден ID.
     *
     * @param params списък с параметри: ID на елемента и ключ на атрибута
     */
    @Override
    protected void doWork(List<String> params) {
        XMLElementTraversal.getElementById(id).removeAttribute(key);
        log("Attribute removed successfully.\n");
    }

    private String id;
    private String key;

    /**
     * Валидира и запазва параметрите от потребителя.
     *
     * @param params списък от два елемента: ID и ключ на атрибута
     */
    @Override
    protected void validate(List<String> params) {
        super.validate(params);

        this.id = params.getFirst();
        this.key = params.get(1);
    }
}
