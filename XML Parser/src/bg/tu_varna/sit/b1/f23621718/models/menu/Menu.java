package bg.tu_varna.sit.b1.f23621718.models.menu;

import bg.tu_varna.sit.b1.f23621718.contracts.Logger;

import java.util.List;

public class Menu {
    private List<MenuCommand> menuCommandList;

    private void addCommand(MenuCommand menuCommand) {
        menuCommandList.add(menuCommand);
    }

    private void removeCommand(MenuCommand menuCommand) {
        menuCommandList.remove(menuCommand);
    }

    private void showMenu(Logger logger) {
        for (MenuCommand mc : menuCommandList) {
            logger.log(mc.toString());
        }
    }
}
