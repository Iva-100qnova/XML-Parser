package bg.tu_varna.sit.b1.f23621718.commands.menu.xml;

import bg.tu_varna.sit.b1.f23621718.commands.menu.*;
import bg.tu_varna.sit.b1.f23621718.contracts.files.*;
import bg.tu_varna.sit.b1.f23621718.data.*;
import bg.tu_varna.sit.b1.f23621718.exceptions.menu.*;
import bg.tu_varna.sit.b1.f23621718.files.*;
import bg.tu_varna.sit.b1.f23621718.menus.*;

import java.io.*;
import java.util.*;

public class SaveXMLMenuCommand extends SaveMenuCommand {
    public SaveXMLMenuCommand(Menu menu) {
        super(menu);
    }

    @Override
    protected void doWork(List<String> params) {
        FileHandler fileHandler = new XMLFileHandler();
        try {
            fileHandler.write(this.getMenu().getFilePath(), XMLRoot.getRootElement().toString());

            super.doWork(params);
        } catch (IOException e) {
            throw new InvalidInputException(e.getMessage());
        }
    }
}


