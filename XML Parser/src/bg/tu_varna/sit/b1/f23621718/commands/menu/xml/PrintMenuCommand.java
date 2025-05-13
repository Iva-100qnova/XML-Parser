package bg.tu_varna.sit.b1.f23621718.commands.menu.xml;

import bg.tu_varna.sit.b1.f23621718.commands.menu.*;
import bg.tu_varna.sit.b1.f23621718.data.*;
import bg.tu_varna.sit.b1.f23621718.menus.*;

import java.util.*;

public class PrintMenuCommand extends AbstractMenuCommand {
    public PrintMenuCommand(Menu menu) {
        super("print", "print the XML content", menu);
    }

    @Override
    protected void doWork(List<String> params) {
        log(XMLRoot.getRootElement().toString());
    }
}