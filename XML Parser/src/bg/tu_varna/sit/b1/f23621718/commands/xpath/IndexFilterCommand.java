package bg.tu_varna.sit.b1.f23621718.commands.xpath;


import bg.tu_varna.sit.b1.f23621718.models.*;

import java.util.*;

public class IndexFilterCommand extends BaseXPathCommand {

    private int index;

    public IndexFilterCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute() {
        var result = new ArrayList<XMLContent>();
        result.add(getInput().get(index));
        setElements(result);
    }

}
