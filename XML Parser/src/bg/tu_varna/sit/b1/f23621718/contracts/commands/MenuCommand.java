package bg.tu_varna.sit.b1.f23621718.contracts.commands;

import bg.tu_varna.sit.b1.f23621718.menus.*;

/**
 * Интерфейс, дефиниращ структурата на командите, използвани в контекста на меню.
 *
 * <p>Наследява {@link ParamsCommand} и добавя методи, свързани с метаинформация
 * за името, описанието и свързаното меню.</p>
 */
public interface MenuCommand extends ParamsCommand {

    /**
     * Връща името на командата.
     *
     * @return Името на командата като {@code String}.
     */
    String getName();

    /**
     * Връща описанието на командата.
     *
     * @return Описанието на командата като {@code String}.
     */
    String getDescription();

    /**
     * Връща менюто, към което принадлежи командата.
     *
     * @return Обект от тип {@link Menu}, представляващ текущото меню.
     */
    Menu getMenu();
}
