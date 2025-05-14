package bg.tu_varna.sit.b1.f23621718.commands.menu;

import bg.tu_varna.sit.b1.f23621718.menus.*;

import java.util.*;

public class SaveMenuCommand extends AbstractMenuCommand {
    public SaveMenuCommand(Menu menu) {
        super("save", "saves the currently open file", menu);
    }

    @Override
    protected void doWork(List<String> params) {
        log("File saved.");
    }
}

