package bg.tu_varna.sit.b1.f23621718.contracts.menu;

import bg.tu_varna.sit.b1.f23621718.contracts.commands.*;

import java.util.*;

public interface CommandMenu {
    Map<String, MenuCommand> getCommands();
    MenuCommand getCommand(String name);
    void addCommand(MenuCommand command);
    void executeCommand(String name);
}
