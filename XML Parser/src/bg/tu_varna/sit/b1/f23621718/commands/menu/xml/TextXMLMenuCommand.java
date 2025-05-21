package bg.tu_varna.sit.b1.f23621718.commands.menu.xml;

import bg.tu_varna.sit.b1.f23621718.commands.menu.*;
import bg.tu_varna.sit.b1.f23621718.data.traversals.*;
import bg.tu_varna.sit.b1.f23621718.menus.*;

import java.util.*;

/**
 * Команда, която извежда целия текст, съдържащ се в даден XML елемент или в неговите вложени елементи.
 * <p>
 * Синтаксис на командата: {@code text <id>}
 * <ul>
 *     <li>{@code id} – ID на XML елемента, чийто текст трябва да бъде извлечен и отпечатан.</li>
 * </ul>
 */
public class TextXMLMenuCommand extends AbstractMenuCommand {

    private String id;

    /**
     * Създава нова команда TextXMLMenuCommand със зададеното меню.
     *
     * @param menu менюто, към което принадлежи тази команда
     */
    public TextXMLMenuCommand(Menu menu) {
        super("text", "print all text from the element with <id> or elements inside of it", menu);
        addParameter("id");
    }

    /**
     * Изпълнява основната логика на командата – извличане и отпечатване на текст от XML елемент.
     *
     * @param params списък с параметри, съдържащ единствено id на елемента
     */
    @Override
    protected void doWork(List<String> params) {
        var text = XMLElementTraversal.getText(id);
        log("Извеждане на целия текст, съдържащ се в елемента:\n\n");
        log(text);
    }

    /**
     * Валидира и извлича параметъра, необходим за изпълнение на командата.
     *
     * @param params списък с входни параметри
     * @throws IllegalArgumentException ако параметърът липсва или е невалиден
     */
    @Override
    protected void validate(List<String> params) {
        super.validate(params);

        this.id = params.getFirst();
    }
}
