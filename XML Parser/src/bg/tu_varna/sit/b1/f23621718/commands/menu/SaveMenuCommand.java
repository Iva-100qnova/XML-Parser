package bg.tu_varna.sit.b1.f23621718.commands.menu;

import bg.tu_varna.sit.b1.f23621718.menus.*;

import java.util.*;

/**
 * Класът {@code SaveMenuCommand} представлява команда от менюто,
 * която запазва текущо отворения XML файл в оригиналното му местоположение.
 */
public class SaveMenuCommand extends AbstractMenuCommand {

    /**
     * Конструктор за създаване на команда за запис на текущия файл.
     *
     * @param menu Менюто, към което принадлежи командата.
     */
    public SaveMenuCommand(Menu menu) {
        super("save", "saves the currently open file", menu);
    }

    /**
     * Изпълнява логиката на командата – логва съобщение за запазване.
     * Действителното записване може да бъде добавено по-късно.
     *
     * @param params Тази команда не изисква параметри.
     */
    @Override
    protected void doWork(List<String> params) {
        log("File saved.");
    }
}