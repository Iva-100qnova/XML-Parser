package bg.tu_varna.sit.b1.f23621718.commands.menu;

import bg.tu_varna.sit.b1.f23621718.exceptions.menu.*;
import bg.tu_varna.sit.b1.f23621718.menus.*;

import java.util.*;

public class SaveAsMenuCommand extends AbstractMenuCommand {
    public SaveAsMenuCommand(Menu menu) {
        super("saveas", "saves the currently open file in <file>", menu);
        addParameter("file");
    }

    @Override
    protected void doWork(List<String> params) {
        log("File saved.");
    }

    private String filePath;

    public String getFilePath() {
        return filePath;
    }

    @Override
    protected void validate(List<String> params) {
        super.validate(params);
        if (params.isEmpty())
            throw new InvalidInputException("Missing <file> parameter.");

        this.filePath = params.getFirst();
    }
}
