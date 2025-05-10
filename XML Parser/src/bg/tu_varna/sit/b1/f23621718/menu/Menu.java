package bg.tu_varna.sit.b1.f23621718.menu;


import bg.tu_varna.sit.b1.f23621718.commands.contracts.*;
import bg.tu_varna.sit.b1.f23621718.exceptions.*;
import bg.tu_varna.sit.b1.f23621718.loggers.contracts.*;

import java.util.*;

public class Menu implements Logger {


    private Map<String, MenuCommand> commands;
    private Logger logger;
    private boolean exit;

    public Menu(Logger logger) {
        this.logger = logger;
        commands = new HashMap<>();
    }

    public Map<String, MenuCommand> getCommands() {
        return new HashMap<>(commands);
    }

    public MenuCommand getCommand(String name) {
        return commands.get(name);
    }

    public void addCommand(MenuCommand command) {
        commands.put(command.getName(), command);
    }

    public void executeCommand(String name) {
        var command = getCommand(name);
        if (command == null)
            throw new CommandNotFound(String.format("Command with name \"%s\" does not exist in the menu.", name));
        command.execute();
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public void exit() {
        exit = true;
    }

    public void startMenu() {
        exit = false;
        while (!exit) {
            log(">");
            Scanner reader = new Scanner(System.in);
            var name = reader.next();
            executeCommand(name);
            log("\n");
        }
    }

    @Override
    public void log(String message) {
        getLogger().log(message);
    }
}
