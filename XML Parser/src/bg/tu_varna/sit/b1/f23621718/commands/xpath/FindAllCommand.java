package bg.tu_varna.sit.b1.f23621718.commands.xpath;


import bg.tu_varna.sit.b1.f23621718.models.*;

import java.util.*;

/**
 * XPath команда за намиране на всички XML елементи с дадено име в йерархията на елементите.
 *
 * <p>Командата обхожда цялото поддърво на всеки входен елемент и събира всички
 * {@link XMLElement}, чието име съвпада с подаденото {@code elementName}.</p>
 *
 * <p>Пример: XPath заявка като <code>person/address</code> ще използва тази команда
 * за да върне всички {@code address} елементи, които са наследници на {@code person}.</p>
 */
public class FindAllCommand extends BaseXPathCommand {

    /**
     * Името на елементите, които трябва да бъдат намерени.
     */
    private final String elementName;

    /**
     * Конструктор за създаване на FindAll команда.
     *
     * @param elementName Името на XML елементите, които се търсят.
     */
    public FindAllCommand(String elementName) {
        this.elementName = elementName;
    }

    /**
     * Изпълнява командата, като обхожда дървото от входни елементи и намира всички XML елементи
     * с име {@code elementName}. Обхождането е реализирано с използване на стек (DFS).
     */
    @Override
    public void execute() {
        var result = new ArrayList<XMLContent>();
        Stack<XMLContent> queue = new Stack<>();

        for (var el : getInput())
            queue.push(el);

        while (!queue.empty()) {
            var top = queue.peek();
            queue.pop();
            for (var el : top.getChildren())
                queue.push(el);
            if (top instanceof XMLElement && ((XMLElement) top).getName().equals(elementName))
                result.add(top);
        }

        setElements(result);
    }
}
