package bg.tu_varna.sit.b1.f23621718.commands.menu.xml;

import bg.tu_varna.sit.b1.f23621718.commands.menu.*;
import bg.tu_varna.sit.b1.f23621718.data.traversals.*;
import bg.tu_varna.sit.b1.f23621718.menus.*;

import java.util.*;

/**
 * Команда, която задава стойност на конкретен атрибут на XML елемент,
 * идентифициран чрез неговото ID.
 * <p>
 * Синтаксис на командата: {@code set <id> <key> <value>}
 * <ul>
 *     <li>{@code id} – ID на XML елемента.</li>
 *     <li>{@code key} – Име на атрибута, чиято стойност ще бъде зададена.</li>
 *     <li>{@code value} – Новата стойност за посочения атрибут.</li>
 * </ul>
 */
public class SetXMLMenuCommand extends AbstractMenuCommand {

    private String id;
    private String key;
    private String value;

    /**
     * Създава нова команда SetXMLMenuCommand със зададеното меню.
     *
     * @param menu менюто, към което принадлежи тази команда
     */
    public SetXMLMenuCommand(Menu menu) {
        super("set", "set the <value> of the <key> attribute for element <id>", menu);
        addParameter("id");
        addParameter("key");
        addParameter("value");
    }

    /**
     * Изпълнява основната логика на командата – задаване на атрибут към XML елемент.
     * Предполага се, че параметрите вече са валидирани.
     *
     * @param params списък с параметри, съдържащи id, key и value
     */
    @Override
    protected void doWork(List<String> params) {
        XMLElementTraversal.setAttribute(id, key, value);
        log(String.format("Успешно зададена стойност \"%s\" за атрибут \"%s\" на елемент с id \"%s\"", value, key, id));
    }

    /**
     * Валидира и извлича параметрите, необходими за изпълнение на командата.
     *
     * @param params списък с входни параметри
     * @throws IllegalArgumentException ако броят на параметрите е невалиден
     */
    @Override
    protected void validate(List<String> params) {
        super.validate(params);

        this.id = params.getFirst();
        this.key = params.get(1);
        this.value = params.get(2);
    }
}
