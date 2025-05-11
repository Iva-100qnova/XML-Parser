package bg.tu_varna.sit.b1.f23621718.menus;


import bg.tu_varna.sit.b1.f23621718.contracts.commands.*;
import bg.tu_varna.sit.b1.f23621718.contracts.io_handlers.*;
import bg.tu_varna.sit.b1.f23621718.contracts.loggers.*;
import bg.tu_varna.sit.b1.f23621718.contracts.menu.*;
import bg.tu_varna.sit.b1.f23621718.exceptions.menu.*;

import java.util.*;

public class Menu implements Logger, FileMenu, CommandMenu, BaseMenu {


    private Map<String, MenuCommand> commands;
    private IOHandler ioHandler;
    private boolean exit;
    private String file;

    public Menu(IOHandler ioHandler) {
        this.ioHandler = ioHandler;
        commands = new HashMap<>();
    }

    @Override
    public Map<String, MenuCommand> getCommands() {
        return new HashMap<>(commands);
    }

    @Override
    public MenuCommand getCommand(String name) {
        return commands.get(name);
    }

    @Override
    public void addCommand(MenuCommand command) {
        commands.put(command.getName(), command);
    }

    @Override
    public void executeCommand(String name) {
        var command = getCommand(name);
        if (command == null)
            throw new CommandNotFound(String.format("Command with name \"%s\" does not exist in the menu.", name));
        command.execute();
    }

    @Override
    public IOHandler getIOHandler() {
        return this.ioHandler;
    }

    @Override
    public void exit() {
        exit = true;
    }

    @Override
    public void startMenu() {
        exit = false;
        while (!exit) {
            log(">");
            var name = ioHandler.getReader().next();
            executeCommand(name);
            log("\n");
        }
    }

    @Override
    public void log(String message) {
        ioHandler.log(message);
    }

    @Override
    public String getFilePath() {
        return this.file;
    }

    @Override
    public void setFilePath() {
        this.file = file;
    }
}
