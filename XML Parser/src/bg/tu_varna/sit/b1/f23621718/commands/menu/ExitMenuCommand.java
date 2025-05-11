package bg.tu_varna.sit.b1.f23621718.commands.menu;

import bg.tu_varna.sit.b1.f23621718.menus.Menu;

import java.util.*;


public class ExitMenuCommand extends AbstractMenuCommand{
    public ExitMenuCommand(Menu menu) {
        super("exit", "exists the program", menu);
    }

    @Override
    protected void doWork(List<String> params) {
        getMenu().exit();
        log("Exiting the program...");
    }

    @Override
    protected void validate(List<String> params) {}
}
