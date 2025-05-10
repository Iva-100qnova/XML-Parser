package bg.tu_varna.sit.b1.f23621718.commands.menu;

import bg.tu_varna.sit.b1.f23621718.menu.*;

public class ExitMenuCommand extends AbstractMenuCommand{
    public ExitMenuCommand(Menu menu) {
        super("exit", "exists the program", menu);
    }

    @Override
    public void execute() {
        getMenu().exit();
        log("Exiting the program...");
    }
}
