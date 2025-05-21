package bg.tu_varna.sit.b1.f23621718.commands.menu;

import bg.tu_varna.sit.b1.f23621718.menus.Menu;

import java.util.*;


/**
 * Класът {@code ExitMenuCommand} представлява команда от менюто, която излиза от програмата.
 * <p>
 * След изпълнение на командата се извиква методът {@code exit()} на {@link Menu},
 * който прекратява работата на приложението.
 * </p>
 */
public class ExitMenuCommand extends AbstractMenuCommand {

    /**
     * Конструктор за създаване на команда за изход от програмата.
     *
     * @param menu Менюто, към което принадлежи командата.
     */
    public ExitMenuCommand(Menu menu) {
        super("exit", "exists the program", menu);
    }

    /**
     * Изпълнява логиката за прекратяване на приложението и логва действието.
     *
     * @param params не се използват в тази команда.
     */
    @Override
    protected void doWork(List<String> params) {
        getMenu().exit();
        log("Exiting the program...");
    }

    /**
     * Презаписва метода за валидация без проверка, тъй като командата няма параметри и не изисква отворен файл.
     *
     * @param params списък с параметри (игнорира се).
     */
    @Override
    protected void validate(List<String> params) {
        // Няма нужда от валидация за тази команда.
    }
}