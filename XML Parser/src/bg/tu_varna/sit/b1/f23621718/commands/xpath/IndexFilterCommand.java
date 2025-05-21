package bg.tu_varna.sit.b1.f23621718.commands.xpath;

import bg.tu_varna.sit.b1.f23621718.models.*;

import java.util.*;

/**
 * XPath команда за избор на конкретен елемент от входния списък по неговия индекс.
 *
 * <p>Използва се в XPath заявки от типа <code>element[2]</code>, където се извлича
 * вторият срещнат елемент с даденото име.</p>
 *
 * <p>Индексът е 0-базиран, т.е. индекс 0 избира първия елемент.</p>
 */
public class IndexFilterCommand extends BaseXPathCommand {

    /**
     * Индексът на елемента, който трябва да бъде извлечен от входния списък.
     */
    private final int index;

    /**
     * Създава нова IndexFilter команда.
     *
     * @param index Индекс на желания елемент във входния списък (0-базиран).
     */
    public IndexFilterCommand(int index) {
        this.index = index;
    }

    /**
     * Изпълнява командата, като избира елемент от входния списък по зададения индекс.
     *
     * <p>Ако индексът е невалиден (извън границите), ще бъде хвърлено {@link IndexOutOfBoundsException}
     * по време на изпълнение.</p>
     */
    @Override
    public void execute() {
        var result = new ArrayList<XMLContent>();
        result.add(getInput().get(index));
        setElements(result);
    }
}

