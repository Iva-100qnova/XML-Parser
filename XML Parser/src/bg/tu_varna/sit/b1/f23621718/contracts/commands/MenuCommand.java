package bg.tu_varna.sit.b1.f23621718.contracts.commands;


import bg.tu_varna.sit.b1.f23621718.menus.*;

public interface MenuCommand extends ParamsCommand {
    String getName();

    String getDescription();

    Menu getMenu();



}
