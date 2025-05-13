package bg.tu_varna.sit.b1.f23621718.commands.menu.xml;

import bg.tu_varna.sit.b1.f23621718.commands.menu.*;
import bg.tu_varna.sit.b1.f23621718.contracts.files.*;
import bg.tu_varna.sit.b1.f23621718.data.*;
import bg.tu_varna.sit.b1.f23621718.exceptions.menu.*;
import bg.tu_varna.sit.b1.f23621718.files.*;
import bg.tu_varna.sit.b1.f23621718.menus.*;
import bg.tu_varna.sit.b1.f23621718.parsers.*;

import java.io.*;
import java.util.*;

public class OpenXMLMenuCommand extends OpenMenuCommand {
    public OpenXMLMenuCommand(Menu menu) {
        super(menu);
    }

    @Override
    protected void doWork(List<String> params) {
        FileHandler fileHandler = new XMLFileHandler();
        try {
            String data = fileHandler.read(getFilePath());
            var parser = new XMLParser();
            var parsedElement = parser.parse(data);

            super.doWork(params);
            XMLRoot.setRootElement(parsedElement);
        } catch (IOException e) {
            throw new InvalidInputException(e.getMessage());
        }
    }
}
