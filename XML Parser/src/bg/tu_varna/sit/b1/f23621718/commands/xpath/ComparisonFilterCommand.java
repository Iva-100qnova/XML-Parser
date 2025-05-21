package bg.tu_varna.sit.b1.f23621718.commands.xpath;

import bg.tu_varna.sit.b1.f23621718.models.*;

import java.util.*;

/**
 * Команда за XPath филтриране, която избира XML елементи със стойност на атрибут,
 * съвпадаща със зададен ключ и стойност.
 *
 * <p>Пример: заявка <code>person(address="USA")</code> ще върне всички {@code person}
 * елементи, при които атрибут {@code address} е със стойност "USA".</p>
 */
public class ComparisonFilterCommand extends BaseXPathCommand {

    /**
     * Името на атрибута, по който ще се извършва проверката.
     */
    private final String key;

    /**
     * Стойността, с която ще се сравнява стойността на атрибута.
     */
    private final String value;

    /**
     * Конструктор за създаване на команда за филтриране чрез сравнение.
     *
     * @param key   Името на атрибута.
     * @param value Стойността, която трябва да съвпадне.
     */
    public ComparisonFilterCommand(String key, String value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Изпълнява командата, като филтрира всички XML елементи от входа,
     * чиито атрибути съдържат двойката {@code key=value}.
     */
    @Override
    public void execute() {
        var result = new ArrayList<XMLContent>();
        for (var el : getInput()) {
            if (el instanceof XMLElement) {
                var attr = ((XMLElement) el).getAttribute(key);
                if (attr != null && attr.equals(value)) {
                    result.add(el);
                }
            }
        }
        setElements(result);
    }
}