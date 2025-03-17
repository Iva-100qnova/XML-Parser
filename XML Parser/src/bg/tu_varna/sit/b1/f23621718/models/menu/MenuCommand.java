package bg.tu_varna.sit.b1.f23621718.models.menu;

import bg.tu_varna.sit.b1.f23621718.contracts.Command;

import java.util.List;

public class MenuCommand implements Command {
    private String name;
    private String description;
    private List<String> parameters;

    @Override
    public String toString() {
        return super.toString();
    }
}
