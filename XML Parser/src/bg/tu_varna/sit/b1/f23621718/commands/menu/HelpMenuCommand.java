package bg.tu_varna.sit.b1.f23621718.commands.menu;

import bg.tu_varna.sit.b1.f23621718.menu.*;

public class HelpMenuCommand extends AbstractMenuCommand {
    public HelpMenuCommand(Menu menu) {
        super("help", "prints this information", menu);
    }

    @Override
    public void execute() {
        var commands = getMenu().getCommands().values();
        StringBuilder sb = new StringBuilder("The following commands are supported:");
        for (var c : commands) {
            sb.append("\n").append(c.toString());
        }

        log(sb.toString());
    }
}
