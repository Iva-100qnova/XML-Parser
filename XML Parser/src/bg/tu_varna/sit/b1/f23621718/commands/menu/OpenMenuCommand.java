package bg.tu_varna.sit.b1.f23621718.commands.menu;

import bg.tu_varna.sit.b1.f23621718.exceptions.menu.*;
import bg.tu_varna.sit.b1.f23621718.menus.*;

import java.util.*;

public class OpenMenuCommand extends AbstractMenuCommand {
    public OpenMenuCommand(Menu menu) {
        super("open", "opens <file>", menu);
        addParameter("file");
    }

    private String filePath;

    public String getFilePath() {
        return filePath;
    }

    @Override
    protected void doWork(List<String> params) {
        this.getMenu().setFilePath(getFilePath());
    }

    @Override
    protected void validate(List<String> params) {
        if (params.isEmpty())
            throw new InvalidInputException("Missing <file> parameter. ");

        this.filePath = params.getFirst();
    }
}
