package bg.tu_varna.sit.b1.f23621718.commands.menu;

import bg.tu_varna.sit.b1.f23621718.contracts.commands.*;
import bg.tu_varna.sit.b1.f23621718.contracts.loggers.*;
import bg.tu_varna.sit.b1.f23621718.exceptions.menu.*;
import bg.tu_varna.sit.b1.f23621718.menus.*;
import bg.tu_varna.sit.b1.f23621718.parsers.*;

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
        return new ArrayList<>(params);
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
    public void addParameter(String parameter) {
        this.params.add(parameter);
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

    @Override
    public void execute() {
        var params = parseParameters();
        this.validate(params);
        this.doWork(params);
    }

    protected List<String> parseParameters() {
        var reader = getMenu().getIOHandler().getReader();
        var line = reader.nextLine();
        var parser = new ParameterParser();
        return parser.parse(line);
    }


    protected void validate(List<String> params) {
        if (this.getMenu().getFilePath() == null)
            throw new NoFilePathException("An open file is required to run this command.");
        if (params.size() != getParameters().size())
            throw new InvalidInputException("Invalid number of parameters passed. Expected: " + getParameters().size());

    }

    protected abstract void doWork(List<String> params);
}
