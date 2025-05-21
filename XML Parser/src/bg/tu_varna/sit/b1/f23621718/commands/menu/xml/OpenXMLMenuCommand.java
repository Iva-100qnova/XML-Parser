package bg.tu_varna.sit.b1.f23621718.commands.menu.xml;

import bg.tu_varna.sit.b1.f23621718.commands.menu.*;
import bg.tu_varna.sit.b1.f23621718.contracts.files.*;
import bg.tu_varna.sit.b1.f23621718.data.*;
import bg.tu_varna.sit.b1.f23621718.exceptions.menu.*;
import bg.tu_varna.sit.b1.f23621718.files.*;
import bg.tu_varna.sit.b1.f23621718.menus.*;
import bg.tu_varna.sit.b1.f23621718.models.XMLElement;
import bg.tu_varna.sit.b1.f23621718.parsers.*;

import java.io.*;
import java.util.*;

/**
 * Команда от менюто, която отваря XML файл и парсва съдържанието му в {@link XMLElement}.
 * <p>
 * Наследява {@link OpenMenuCommand} и използва {@link XMLFileHandler} за четене от файл,
 * както и {@link XMLParser} за преобразуване на XML съдържанието в обектен модел.
 * <p>
 * Ако парсването не е успешно, се създава празен коренов елемент с име <code>root</code>.
 */
public class OpenXMLMenuCommand extends OpenMenuCommand {

    /**
     * Конструктор, който инициализира командата с дадено меню.
     *
     * @param menu менюто, към което принадлежи командата
     */
    public OpenXMLMenuCommand(Menu menu) {
        super(menu);
    }

    /**
     * Изпълнява логиката за отваряне и парсване на XML файл.
     * <p>
     * Чете съдържанието на файл от зададения път чрез {@link XMLFileHandler#read(String)}.
     * След това парсва съдържанието чрез {@link XMLParser#parse(String)} и го записва в {@link XMLRoot}.
     * Ако съдържанието е невалидно или празно, се създава нов {@link XMLElement} с име <code>root</code>.
     *
     * @param params списък от параметри, очаква се път до файла
     */
    @Override
    protected void doWork(List<String> params) {
        FileHandler fileHandler = new XMLFileHandler();
        try {
            String data = fileHandler.read(getFilePath());
            var parser = new XMLParser();
            var parsedElement = parser.parse(data);

            super.doWork(params);
            if (parsedElement == null)
                parsedElement = new XMLElement("root");

            XMLRoot.setRootElement(parsedElement);
        } catch (IOException e) {
            throw new InvalidInputException(e.getMessage());
        }
    }
}
