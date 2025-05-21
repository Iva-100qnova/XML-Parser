package bg.tu_varna.sit.b1.f23621718.commands.xpath;

import bg.tu_varna.sit.b1.f23621718.models.*;

import java.util.*;

/**
 * Конкретна XPath команда, която връща всички наследници с дадено име
 * от подадения входен списък от XML елементи.
 * <p>
 * Пример: при заявка <code>person/address</code>, се извиква <code>ChildCommand("address")</code>.
 */
public class ChildCommand extends BaseXPathCommand {

    /**
     * Името на наследниците, които трябва да бъдат извлечени.
     */
    private String elementName;

    /**
     * Създава нова команда за намиране на наследници с дадено име.
     *
     * @param elementName името на децата (наследниците), които да бъдат избрани.
     */
    public ChildCommand(String elementName) {
        this.elementName = elementName;
    }

    /**
     * Изпълнява командата, извличайки всички наследници на елементите от входа,
     * които са инстанции на {@link XMLElement} и имат съвпадащо име.
     */
    @Override
    public void execute() {
        var result = new ArrayList<XMLContent>();
        for (var parent : getInput()) {
            for (var el : parent.getChildren()) {
                if (el instanceof XMLElement && ((XMLElement) el).getName().equals(elementName)) {
                    result.add(el);
                }
            }
        }
        setElements(result);
    }
}
