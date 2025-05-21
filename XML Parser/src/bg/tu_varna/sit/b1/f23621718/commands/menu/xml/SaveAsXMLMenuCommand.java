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
 * Команда от менюто, която записва текущото XML съдържание във файл, посочен от потребителя.
 * <p>
 * Наследява {@link SaveAsMenuCommand} и използва {@link XMLFileHandler} за запис във файл.
 * <p>
 * Командата изисква валиден път до файл и съхранява {@link XMLRoot#getRootElement()} съдържанието в него.
 */
public class SaveAsXMLMenuCommand extends SaveAsMenuCommand {

    /**
     * Конструктор, който инициализира командата с менюто, към което принадлежи.
     *
     * @param menu менюто, в което е регистрирана командата
     */
    public SaveAsXMLMenuCommand(Menu menu) {
        super(menu);
    }

    /**
     * Изпълнява логиката за запис на XML съдържание във файл.
     * <p>
     * Използва {@link XMLFileHandler} за запис и подава резултата към базовата реализация
     * в {@link SaveAsMenuCommand#doWork(List)}. При неуспех хвърля {@link InvalidInputException}.
     *
     * @param params списък с параметри, където се очаква път до файла
     */
    @Override
    protected void doWork(List<String> params) {
        FileHandler fileHandler = new XMLFileHandler();
        try {
            fileHandler.write(super.getFilePath(), XMLRoot.getRootElement().toString());
            super.doWork(params);
        } catch (IOException e) {
            throw new InvalidInputException(e.getMessage());
        }
    }
}
