package bg.tu_varna.sit.b1.f23621718.commands.menu;

import bg.tu_varna.sit.b1.f23621718.commands.contracts.*;
import bg.tu_varna.sit.b1.f23621718.loggers.contracts.*;
import bg.tu_varna.sit.b1.f23621718.menu.*;

import java.util.*;

public abstract class AbstractMenuCommand implements MenuCommand, Logger {
    private String name;
    private String description;
    private List<String> params;
    private Menu menu;


    public AbstractMenuCommand(String name, String description, Menu menu) {
        this.name = name;
        this.menu = menu;
        this.description = description;
        this.params = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public List<String> getParameters() {
        return params;
    }

    @Override
    public String getParametersAsString() {
        StringBuilder sb = new StringBuilder();
        if(getParameters().isEmpty())
            return "";
        for (var p : getParameters()) {
            sb.append(String.format(" <%s>", p));
        }
        return sb.deleteCharAt(0).toString();
    }

    @Override
    public Menu getMenu() {
        return this.menu;
    }

    @Override
    public void log(String msg) {
        getMenu().log(msg);
    }

    @Override
    public String toString() {
        return String.format("%s %s \n\tDescription: %s", getName(), getParametersAsString(), getDescription());
    }
}
