package bg.tu_varna.sit.b1.f23621718.commands.xpath;

import bg.tu_varna.sit.b1.f23621718.contracts.commands.*;
import bg.tu_varna.sit.b1.f23621718.models.*;

import java.util.*;

/**
 * Абстрактен базов клас за XPath команди. Предоставя обща реализация за
 * управление на входни и изходни XML елементи, както и форматиран резултат.
 * <p>
 * Използва се за дефиниране на специфични XPath операции чрез наследяване.
 */
public abstract class BaseXPathCommand implements XPathCommand {

    /**
     * Входният списък от XML елементи, върху които ще се прилага XPath операцията.
     */
    private List<XMLContent> input;

    /**
     * Резултатният списък от XML елементи след изпълнение на XPath операцията.
     */
    private List<XMLContent> result;

    /**
     * Връща списък с елементите, получени след изпълнение на XPath командата.
     *
     * @return копие на резултатния списък.
     */
    @Override
    public List<XMLContent> getElements() {
        return new ArrayList<>(result);
    }

    /**
     * Задава входния списък от XML елементи, които ще бъдат обработвани.
     *
     * @param input списък от елементи (XMLContent), върху които ще се изпълнява XPath логика.
     */
    @Override
    public void setInput(List<XMLContent> input) {
        this.input = new ArrayList<>(input);
    }

    /**
     * Връща текущия входен списък от XML елементи.
     *
     * @return копие на входния списък.
     */
    @Override
    public List<XMLContent> getInput() {
        return new ArrayList<>(input);
    }

    /**
     * Задава резултатен списък от XML елементи след изпълнение на XPath логика.
     *
     * @param result списък с резултати.
     */
    @Override
    public void setElements(List<XMLContent> result) {
        this.result = new ArrayList<>(result);
    }

    /**
     * Връща текстово представяне на резултата – всеки елемент на нов ред.
     *
     * @return форматиран резултат като низ.
     */
    @Override
    public String getResult() {
        StringBuilder sb = new StringBuilder();
        for (var el : getElements()) {
            sb.append(el.toString()).append("\n ------------------- \n");
        }
        return sb.toString();
    }
}