package bg.tu_varna.sit.b1.f23621718.commands.menu;

import bg.tu_varna.sit.b1.f23621718.data.*;
import bg.tu_varna.sit.b1.f23621718.menus.*;

import java.util.*;

/**
 * Класът {@code CloseMenuCommand} представлява команда от менюто, която затваря текущо отворения XML файл.
 * <p>
 * След изпълнение на командата, асоциираният файл в {@link Menu} обекта се нулира (премахва се пътят до файла).
 * </p>
 */
public class CloseMenuCommand extends AbstractMenuCommand {

    /**
     * Конструктор за създаване на команда за затваряне на файл.
     *
     * @param menu Менюто, към което принадлежи командата.
     */
    public CloseMenuCommand(Menu menu) {
        super("close", "closes currently opened file", menu);
    }

    /**
     * Конкретна имплементация на логиката на командата.
     * Занулява пътя към отворения файл и логва действието.
     *
     * @param params не се използват за тази команда, но се изискват по интерфейс.
     */
    @Override
    protected void doWork(List<String> params) {
        getMenu().setFilePath(null);
        log("File closed.");
    }
}
