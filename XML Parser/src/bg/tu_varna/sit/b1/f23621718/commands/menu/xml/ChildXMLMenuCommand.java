package bg.tu_varna.sit.b1.f23621718.commands.menu.xml;

import bg.tu_varna.sit.b1.f23621718.commands.menu.*;
import bg.tu_varna.sit.b1.f23621718.data.traversals.*;
import bg.tu_varna.sit.b1.f23621718.exceptions.menu.*;
import bg.tu_varna.sit.b1.f23621718.menus.*;

import java.util.*;

/**
 * Команда от менюто, която връща n-тото дете на XML елемент с даден идентификатор.
 * <p>
 * Използва {@link XMLElementTraversal#getChildElements(String)} за получаване на
 * списък с деца на елемент. Потребителят подава два параметъра:
 * <ul>
 *     <li><b>id</b> – идентификатор на елемента</li>
 *     <li><b>n</b> – индекс на желаното дете (започва от 1)</li>
 * </ul>
 * Ако индексът е невалиден или не е цяло число, се хвърля {@link InvalidInputException}.
 */
public class ChildXMLMenuCommand extends AbstractMenuCommand {

    /**
     * Конструктор на командата, приема обект {@link Menu}, към който принадлежи.
     *
     * @param menu менюто, в което е регистрирана командата
     */
    public ChildXMLMenuCommand(Menu menu) {
        super("child", "gets the n-th child of element with <id>", menu);
        addParameter("id");
        addParameter("n");
    }

    /**
     * Изпълнява логиката за получаване и отпечатване на n-тото дете
     * на елемента с посочения ID.
     *
     * @param params списък с два параметъра – ID и индекс
     */
    @Override
    protected void doWork(List<String> params) {
        var children = XMLElementTraversal.getChildElements(id);
        log(String.format("=== Printing child with index %d === \n", n));
        log(children.get(n - 1).toString());
    }

    private String id;
    private Integer n;

    /**
     * Валидира и извлича параметрите от списъка.
     * <p>
     * Първият параметър се третира като ID, а последният се опитва да се парсне до цяло число.
     * Ако това не е възможно, се хвърля {@link InvalidInputException}.
     *
     * @param params входни параметри
     */
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
