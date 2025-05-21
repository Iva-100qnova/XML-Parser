package bg.tu_varna.sit.b1.f23621718.contracts.commands;

import bg.tu_varna.sit.b1.f23621718.models.*;

import java.util.*;

/**
 * Интерфейс, дефиниращ команда за работа с XPath-подобна логика върху XML съдържание.
 *
 * <p>Наследява базовия {@link Command} интерфейс и разширява функционалността
 * с методи за подаване на входни елементи, извличане на резултати и
 * задаване на филтрирани елементи.</p>
 */
public interface XPathCommand extends Command {

    /**
     * Връща текстово представяне на резултата от изпълнението на XPath командата.
     *
     * @return {@code String}, съдържащ резултатите като текст.
     */
    String getResult();

    /**
     * Връща списъка с XML елементи, които са резултат от командата.
     *
     * @return {@code List<XMLContent>} съдържащ филтрираните или намерени елементи.
     */
    List<XMLContent> getElements();

    /**
     * Задава списък с елементи като резултат от изпълнението на командата.
     *
     * @param result Списък от {@code XMLContent}, които представляват резултатите.
     */
    void setElements(List<XMLContent> result);

    /**
     * Задава входните XML елементи, върху които ще работи командата.
     *
     * @param input Списък от {@code XMLContent}, представляващи входа.
     */
    void setInput(List<XMLContent> input);

    /**
     * Връща текущите входни XML елементи, върху които ще се прилага командата.
     *
     * @return {@code List<XMLContent>} – списък с елементи за обработка.
     */
    List<XMLContent> getInput();
}
