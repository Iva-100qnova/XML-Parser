package bg.tu_varna.sit.b1.f23621718.commands.menu;

import bg.tu_varna.sit.b1.f23621718.exceptions.menu.*;
import bg.tu_varna.sit.b1.f23621718.menus.*;

import java.util.*;

/**
 * Класът {@code OpenMenuCommand} представлява команда от менюто,
 * която задава път към XML файл и го "отваря" за по-нататъшна работа.
 */
public class OpenMenuCommand extends AbstractMenuCommand {

    /**
     * Стойност на подадения път до файл.
     */
    private String filePath;

    /**
     * Конструктор за създаване на команда за отваряне на файл.
     * Задава името на командата, описанието ѝ и параметъра, който изисква – {@code file}.
     *
     * @param menu Менюто, към което принадлежи командата.
     */
    public OpenMenuCommand(Menu menu) {
        super("open", "opens <file>", menu);
        addParameter("file");
    }


    /**
     * Връща текущо зададения път към файл.
     *
     * @return път до XML файла.
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Изпълнява логиката на командата – задава пътя на файла в {@link Menu}
     * и логва действието.
     *
     * @param params списък с параметри, съдържащ пътя до файла.
     */
    @Override
    protected void doWork(List<String> params) {
        this.getMenu().setFilePath(getFilePath());
        log("File opened.");
    }

    /**
     * Валидация на подадените параметри. Изисква точно един параметър – път до файл.
     *
     * @param params списък с параметри, очаква се един елемент (път до XML файл).
     * @throws InvalidInputException ако броят параметри е грешен или липсва.
     */
    @Override
    protected void validate(List<String> params) {
        if (params.isEmpty())
            throw new InvalidInputException("Missing <file> parameter.");
        if (params.size() != 1)
            throw new InvalidInputException("Invalid number of parameters passed. Expected: 1");

        this.filePath = params.getFirst();
    }
}