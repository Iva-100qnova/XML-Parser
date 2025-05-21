package bg.tu_varna.sit.b1.f23621718.contracts.menu;

import bg.tu_varna.sit.b1.f23621718.contracts.commands.*;

import java.util.*;

/**
 * Интерфейс, дефиниращ функционалността на меню, базирано на команди.
 * <p>
 * Позволява добавяне, достъп и изпълнение на команди чрез тяхното име.
 */
public interface CommandMenu {

    /**
     * Връща всички команди, налични в менюто.
     *
     * @return Map от имена на команди към съответните {@link MenuCommand} обекти.
     */
    Map<String, MenuCommand> getCommands();

    /**
     * Връща команда по подадено име.
     *
     * @param name Името на командата.
     * @return {@link MenuCommand}, свързана с подаденото име, или {@code null}, ако не съществува.
     */
    MenuCommand getCommand(String name);

    /**
     * Добавя нова команда към менюто.
     *
     * @param command Обект от тип {@link MenuCommand}, който да бъде добавен.
     */
    void addCommand(MenuCommand command);

    /**
     * Изпълнява команда по подадено име.
     * <p>
     * Извиква метода {@code execute()} на командата.
     *
     * @param name Името на командата за изпълнение.
     * @throws IllegalArgumentException ако командата не съществува.
     */
    void executeCommand(String name);
}

