package bg.tu_varna.sit.b1.f23621718.commands.xpath;

import bg.tu_varna.sit.b1.f23621718.contracts.commands.*;
import bg.tu_varna.sit.b1.f23621718.models.*;

import java.util.*;

public abstract class BaseXPathCommand implements XPathCommand {

    private List<XMLContent> input;
    private List<XMLContent> result;

    @Override
    public List<XMLContent> getElements() {
        return new ArrayList<>(result);
    }

    @Override
    public void setInput(List<XMLContent> input) {
        this.input = new ArrayList<>(input);
    }

    @Override
    public List<XMLContent> getInput() {
        return new ArrayList<>(input);
    }

    @Override
    public void setElements(List<XMLContent> result) {
        this.result = new ArrayList<>(result);
    }

    @Override
    public String getResult() {
        StringBuilder sb = new StringBuilder();
        for (var el : getElements()) {
            sb.append(el.toString()).append("\n ------------------- \n");
        }
        return sb.toString();
    }
}