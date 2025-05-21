package bg.tu_varna.sit.b1.f23621718.menus;

import bg.tu_varna.sit.b1.f23621718.contracts.commands.*;
import bg.tu_varna.sit.b1.f23621718.contracts.io_handlers.*;
import bg.tu_varna.sit.b1.f23621718.contracts.loggers.*;
import bg.tu_varna.sit.b1.f23621718.contracts.menu.*;
import bg.tu_varna.sit.b1.f23621718.exceptions.menu.*;

import java.util.*;

/**
 * Имплементация на менюто, което управлява изпълнението на команди,
 * обработва вход/изход и следи за файлов път.
 * Реализира интерфейсите Logger, FileMenu, CommandMenu и BaseMenu.
 */
public class Menu implements Logger, FileMenu, CommandMenu, BaseMenu {

    private Map<String, MenuCommand> commands;
    private IOHandler ioHandler;
    private boolean exit;
    private String file;

    /**
     * Създава ново меню с подаден IOHandler.
     *
     * @param ioHandler обект за обработка на вход и изход
     */
    public Menu(IOHandler ioHandler) {
        this.ioHandler = ioHandler;
        commands = new LinkedHashMap<>();
    }

    /**
     * Връща копие на всички команди в менюто.
     *
     * @return Map с имената и командите
     */
    @Override
    public Map<String, MenuCommand> getCommands() {
        return new LinkedHashMap<>(commands);
    }

    /**
     * Връща командата с дадено име.
     *
     * @param name името на командата
     * @return обектът на командата или null ако няма такава
     */
    @Override
    public MenuCommand getCommand(String name) {
        return commands.get(name);
    }

    /**
     * Добавя команда в менюто.
     *
     * @param command командата за добавяне
     */
    @Override
    public void addCommand(MenuCommand command) {
        commands.put(command.getName(), command);
    }

    /**
     * Изпълнява команда по име.
     *
     * @param name името на командата за изпълнение
     * @throws CommandNotFound ако командата не съществува
     */
    @Override
    public void executeCommand(String name) {
        var command = getCommand(name);
        if (command == null)
            throw new CommandNotFound(String.format("Command with name \"%s\" does not exist in the menu.", name));
        command.execute();
    }

    /**
     * Връща IOHandler-а на менюто.
     *
     * @return обект за вход и изход
     */
    @Override
    public IOHandler getIOHandler() {
        return this.ioHandler;
    }

    /**
     * Задава флага за изход от менюто.
     */
    @Override
    public void exit() {
        exit = true;
    }

    /**
     * Стартира цикъла на менюто, като чете команди от входа
     * и ги изпълнява докато не бъде зададено излизане.
     */
    @Override
    public void startMenu() {
        exit = false;
        while (!exit) {
            try {
                log(">");
                var name = ioHandler.getReader().next();
                executeCommand(name);
            } catch (Exception e) {
                log(e.getMessage());
            }
            log("\n");
        }
    }

    /**
     * Логва съобщение чрез IOHandler-а.
     *
     * @param message съобщението за логване
     */
    @Override
    public void log(String message) {
        ioHandler.log(message);
    }

    /**
     * Връща пътя към файла.
     *
     * @return файловият път
     */
    @Override
    public String getFilePath() {
        return this.file;
    }

    /**
     * Задава път към файл.
     *
     * @param file пътят към файла
     */
    @Override
    public void setFilePath(String file) {
        this.file = file;
    }
}
