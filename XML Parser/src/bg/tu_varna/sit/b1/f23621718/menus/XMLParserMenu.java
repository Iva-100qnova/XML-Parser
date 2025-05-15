package bg.tu_varna.sit.b1.f23621718.menus;

import bg.tu_varna.sit.b1.f23621718.commands.menu.*;
import bg.tu_varna.sit.b1.f23621718.commands.menu.xml.*;
import bg.tu_varna.sit.b1.f23621718.contracts.io_handlers.*;

public class XMLParserMenu extends Menu {
    public XMLParserMenu(IOHandler ioHandler) {
        super(ioHandler);

        addCommand(new HelpMenuCommand(this));
        addCommand(new OpenXMLMenuCommand(this));
        addCommand(new PrintMenuCommand(this));
        addCommand(new SelectXMLMenuCommand(this));
        addCommand(new SetXMLMenuCommand(this));
        addCommand(new ChildrenXMLMenuCommand(this));
        addCommand(new ChildXMLMenuCommand(this));
        addCommand(new CloseMenuCommand(this));
        addCommand(new SaveXMLMenuCommand(this));
        addCommand(new SaveAsXMLMenuCommand(this));
        addCommand(new TextXMLMenuCommand(this));
        addCommand(new DeleteXMLMenuCommand(this));
        addCommand(new NewChildXMLMenuCommand(this));
        addCommand(new ChangeTagXMLMenuCommand(this));
        addCommand(new ExitMenuCommand(this));

    }
}
