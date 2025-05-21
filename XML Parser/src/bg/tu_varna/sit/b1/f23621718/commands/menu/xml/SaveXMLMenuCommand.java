package bg.tu_varna.sit.b1.f23621718.commands.menu.xml;

import bg.tu_varna.sit.b1.f23621718.commands.menu.*;
import bg.tu_varna.sit.b1.f23621718.contracts.files.*;
import bg.tu_varna.sit.b1.f23621718.data.*;
import bg.tu_varna.sit.b1.f23621718.exceptions.menu.*;
import bg.tu_varna.sit.b1.f23621718.files.*;
import bg.tu_varna.sit.b1.f23621718.menus.*;

import java.io.*;
import java.util.*;

/**
 * Команда от менюто, която записва текущото XML съдържание във вече асоциирания файл.
 * <p>
 * Наследява {@link SaveMenuCommand} и използва {@link XMLFileHandler} за записване на
 * съдържанието на {@link XMLRoot#getRootElement()} в пътя, асоцииран с менюто.
 * <p>
 * Ако пътят не е настроен или възникне грешка при писане, се хвърля {@link InvalidInputException}.
 */
public class SaveXMLMenuCommand extends SaveMenuCommand {

    /**
     * Конструктор, който инициализира командата с даденото меню.
     *
     * @param menu менюто, към което принадлежи командата
     */
    public SaveXMLMenuCommand(Menu menu) {
        super(menu);
    }

    /**
     * Изпълнява логиката за запис на текущото XML съдържание във вече отворения файл.
     * <p>
     * Използва {@link XMLFileHandler#write(String, String)} за запис на съдържанието.
     * След успешен запис, извиква допълнителна логика от родителския клас.
     *
     * @param params параметри от потребителя – не се използват директно тук
     */
    @Override
    protected void doWork(List<String> params) {
        FileHandler fileHandler = new XMLFileHandler();
        try {
            fileHandler.write(this.getMenu().getFilePath(), XMLRoot.getRootElement().toString());
            super.doWork(params);
        } catch (IOException e) {
            throw new InvalidInputException(e.getMessage());
        }
    }
}


