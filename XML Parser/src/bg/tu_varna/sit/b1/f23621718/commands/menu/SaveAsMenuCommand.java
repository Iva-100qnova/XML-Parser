package bg.tu_varna.sit.b1.f23621718.commands.menu;

import bg.tu_varna.sit.b1.f23621718.exceptions.menu.*;
import bg.tu_varna.sit.b1.f23621718.menus.*;

import java.util.*;

/**
 * Класът {@code SaveAsMenuCommand} представлява команда от менюто,
 * която запазва текущо отворения XML файл под ново име (или нов път).
 */
public class SaveAsMenuCommand extends AbstractMenuCommand {

    /**
     * Пътят, под който ще бъде записан файлът.
     */
    private String filePath;

    /**
     * Конструктор за създаване на команда за запазване на файл с ново име.
     *
     * @param menu Менюто, към което принадлежи командата.
     */
    public SaveAsMenuCommand(Menu menu) {
        super("saveas", "saves the currently open file in <file>", menu);
        addParameter("file");
    }

    /**
     * Връща зададения път за запазване.
     *
     * @return път до новия файл.
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Изпълнява логиката на командата – логва съобщение за запазен файл.
     * Реалното записване на съдържание може да бъде имплементирано допълнително.
     *
     * @param params списък с параметри, съдържащ новия път за запазване.
     */
    @Override
    protected void doWork(List<String> params) {
        log("File saved.");
    }

    /**
     * Валидация на подадените параметри. Изисква точно един параметър – път до новия файл.
     *
     * @param params списък с параметри.
     * @throws InvalidInputException ако липсва параметър.
     */
    @Override
    protected void validate(List<String> params) {
        super.validate(params);
        if (params.isEmpty())
            throw new InvalidInputException("Missing <file> parameter.");

        this.filePath = params.getFirst();
    }
}