package bg.tu_varna.sit.b1.f23621718.contracts.commands;

import java.util.*;

public interface ParamsCommand extends Command {
    List<String> getParameters();

    String getParametersAsString();

    void addParameter(String parameter);
}
