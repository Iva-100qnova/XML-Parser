package bg.tu_varna.sit.b1.f23621718.commands.contracts;


import bg.tu_varna.sit.b1.f23621718.menu.*;

import java.util.*;

public interface MenuCommand extends Command {
    String getName();

    String getDescription();

    Menu getMenu();

    List<String> getParameters();

    String getParametersAsString();
}
