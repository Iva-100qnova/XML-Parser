package bg.tu_varna.sit.b1.f23621718.contracts.commands;

import bg.tu_varna.sit.b1.f23621718.models.*;

import java.util.*;

public interface XPathCommand extends Command {
    String getResult();

    List<XMLContent> getElements();
    void setElements(List<XMLContent> result);

    void setInput(List<XMLContent> input);
    List<XMLContent> getInput();
}
