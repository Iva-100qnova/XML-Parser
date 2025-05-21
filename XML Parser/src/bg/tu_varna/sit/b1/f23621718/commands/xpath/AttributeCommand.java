package bg.tu_varna.sit.b1.f23621718.commands.xpath;

import bg.tu_varna.sit.b1.f23621718.models.*;

import java.util.*;

/**
 * Класът {@code AttributeCommand} реализира XPath операцията за избор на атрибути
 * от XML елементи по зададен ключ. Командата връща стойностите на даден атрибут
 * от всички елементи в текущия входен списък.
 */
public class AttributeCommand extends BaseXPathCommand {

    /**
     * Името на атрибута, който ще бъде извлечен.
     */
    private String attr;

    /**
     * Резултатен списък със стойностите на атрибута във вид: {@code ключ='стойност'}.
     */
    private List<String> attributesToPrint;


    /**
     * Създава нова XPath команда за извличане на даден атрибут.
     *
     * @param attr името на атрибута, който се търси.
     */
    public AttributeCommand(String attr) {
        this.attr = attr;
    }

    /**
     * Изпълнява командата като обхожда входните XML елементи и извлича стойностите
     * на атрибута, ако съществува. Резултатът се запазва във вътрешен списък.
     */
    @Override
    public void execute() {
        var result = new ArrayList<String>();
        for (var el : getInput()) {
            if (el instanceof XMLElement) {
                String value = ((XMLElement) el).getAttribute(attr);
                if (value != null) {
                    result.add(String.format("%s='%s'", attr, value));
                }
            }
        }
        attributesToPrint = result;

        setElements(getInput());
    }

    /**
     * Връща резултата от изпълнението на XPath заявката – списък с намерените атрибути.
     *
     * @return текстова репрезентация на атрибутите, по един на ред.
     */
    @Override
    public String getResult() {
        StringBuilder sb = new StringBuilder();
        for (var attr : attributesToPrint)
            sb.append(attr).append("\n");
        return sb.toString();
    }
}