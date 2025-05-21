package bg.tu_varna.sit.b1.f23621718.commands.menu;

import bg.tu_varna.sit.b1.f23621718.menus.*;

import java.util.*;

/**
 * Класът {@code HelpMenuCommand} представлява команда от менюто,
 * която извежда информация за всички поддържани команди в текущото меню.
 */
public class HelpMenuCommand extends AbstractMenuCommand {

    /**
     * Конструктор за създаване на команда за извеждане на помощна информация.
     *
     * @param menu Менюто, в което се намира командата.
     */
    public HelpMenuCommand(Menu menu) {
        super("help", "prints this information", menu);
    }

    /**
     * Изпълнява логиката на командата – извежда списък с всички регистрирани команди в менюто
     * и техните описания чрез метода {@code toString()} на всяка команда.
     *
     * @param params не се използват в тази команда.
     */
    @Override
    protected void doWork(List<String> params) {
        var commands = getMenu().getCommands().values();
        StringBuilder sb = new StringBuilder("The following commands are supported:");
        for (var c : commands) {
            sb.append("\n").append(c.toString());
        }

        log(sb.toString());
    }

    /**
     * Презаписва метода за валидация без проверка, тъй като командата няма нужда от параметри или файл.
     *
     * @param params Списък с параметри (игнорира се).
     */
    @Override
    protected void validate(List<String> params) {
        // Няма нужда от валидация за help командата.
    }
}
