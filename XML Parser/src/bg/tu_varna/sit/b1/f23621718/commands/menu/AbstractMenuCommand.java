package bg.tu_varna.sit.b1.f23621718.commands.menu;

import bg.tu_varna.sit.b1.f23621718.contracts.commands.*;
import bg.tu_varna.sit.b1.f23621718.contracts.loggers.*;
import bg.tu_varna.sit.b1.f23621718.exceptions.menu.*;
import bg.tu_varna.sit.b1.f23621718.menus.*;
import bg.tu_varna.sit.b1.f23621718.parsers.*;

import java.util.*;

/**
 * Абстрактен клас, реализиращ основна функционалност за командите от менюто.
 * Поддържа име, описание, параметри и референция към текущото меню.
 * Изпълнява шаблонен метод {@code execute()}, който валидира и изпълнява логиката.
 * <p>
 * Реализира интерфейсите {@link MenuCommand} и {@link Logger}.
 * </p>
 */
public abstract class AbstractMenuCommand implements MenuCommand, Logger {
    private String name;
    private String description;
    private List<String> params;
    private Menu menu;


    /**
     * Конструктор с параметри.
     *
     * @param name        Името на командата.
     * @param description Описание на командата.
     * @param menu        Референция към менюто, в което се намира командата.
     */
    public AbstractMenuCommand(String name, String description, Menu menu) {
        this.name = name;
        this.menu = menu;
        this.description = description;
        this.params = new ArrayList<>();
    }

    /**
     * Връща името на командата.
     *
     * @return Името като {@code String}.
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Връща описанието на командата.
     *
     * @return Описание като {@code String}.
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * Връща списък с параметрите на командата.
     *
     * @return Нов списък от параметри.
     */
    @Override
    public List<String> getParameters() {
        return new ArrayList<>(params);
    }


    /**
     * Връща параметрите на командата във формат като за CLI извикване.
     *
     * @return Форматиран низ с параметрите.
     */
    @Override
    public String getParametersAsString() {
        StringBuilder sb = new StringBuilder();
        if (getParameters().isEmpty())
            return "";
        for (var p : getParameters()) {
            sb.append(String.format(" <%s>", p));
        }
        return sb.deleteCharAt(0).toString();
    }

    /**
     * Добавя нов параметър към списъка с параметри.
     *
     * @param parameter Нов параметър.
     */
    @Override
    public void addParameter(String parameter) {
        this.params.add(parameter);
    }

    /**
     * Връща менюто, към което принадлежи командата.
     *
     * @return {@link Menu} обект.
     */
    @Override
    public Menu getMenu() {
        return this.menu;
    }

    /**
     * Записва съобщение чрез логиката на {@link Menu}.
     *
     * @param msg Съобщение за логване.
     */
    @Override
    public void log(String msg) {
        getMenu().log(msg);
    }

    /**
     * Връща текстово представяне на командата.
     *
     * @return Командата като текст.
     */
    @Override
    public String toString() {
        return String.format("%s %s \n\tDescription: %s", getName(), getParametersAsString(), getDescription());
    }

    /**
     * Главен метод за изпълнение на командата.
     * Парсва параметри, валидира входа и изпълнява конкретната логика чрез {@code doWork}.
     */
    @Override
    public void execute() {
        var params = parseParameters();
        this.validate(params);
        this.doWork(params);
    }

    /**
     * Извлича потребителски вход и парсва параметрите чрез {@link ParameterParser}.
     *
     * @return Списък от параметри.
     */
    protected List<String> parseParameters() {
        var reader = getMenu().getIOHandler().getReader();
        var line = reader.nextLine();
        var parser = new ParameterParser();
        return parser.parse(line);
    }


    /**
     * Валидира входа – проверява дали е отворен файл и дали броят параметри е коректен.
     *
     * @param params Списък от входни параметри.
     * @throws NoFilePathException     ако няма отворен файл.
     * @throws InvalidInputException   ако броят параметри не съвпада с очаквания.
     */
    protected void validate(List<String> params) {
        if (this.getMenu().getFilePath() == null)
            throw new NoFilePathException("An open file is required to run this command.");
        if (params.size() != getParameters().size())
            throw new InvalidInputException("Invalid number of parameters passed. Expected: " + getParameters().size());
    }

    /**
     * Абстрактен метод, който трябва да се реализира от наследниците,
     * съдържащ конкретната логика на командата.
     *
     * @param params валидираните параметри от входа.
     */
    protected abstract void doWork(List<String> params);
}
