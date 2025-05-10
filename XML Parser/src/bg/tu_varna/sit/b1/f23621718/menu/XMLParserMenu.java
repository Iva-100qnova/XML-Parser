package bg.tu_varna.sit.b1.f23621718.menu;

import bg.tu_varna.sit.b1.f23621718.commands.menu.*;
import bg.tu_varna.sit.b1.f23621718.loggers.contracts.*;

public class XMLParserMenu extends Menu {
    public XMLParserMenu(Logger logger) {
        super(logger);

        addCommand(new HelpMenuCommand(this));
        addCommand(new ExitMenuCommand(this));
        
    }
}
