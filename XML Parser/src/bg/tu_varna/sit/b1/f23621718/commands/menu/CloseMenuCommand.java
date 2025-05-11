package bg.tu_varna.sit.b1.f23621718.commands.menu;

import bg.tu_varna.sit.b1.f23621718.data.*;
import bg.tu_varna.sit.b1.f23621718.menus.*;

import java.util.*;

public class CloseMenuCommand extends AbstractMenuCommand {
    public CloseMenuCommand(Menu menu) {
        super("close", "closes currently opened file\n", menu);
    }

    @Override
    protected void doWork(List<String> params) {
        XMLRoot.setRootElement(null);
        getMenu().setFilePath(null);
        log("File closed.");
    }

}
