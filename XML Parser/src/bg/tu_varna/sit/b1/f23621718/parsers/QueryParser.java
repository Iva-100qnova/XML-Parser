package bg.tu_varna.sit.b1.f23621718.parsers;


import bg.tu_varna.sit.b1.f23621718.commands.contracts.QueryCommand;
import bg.tu_varna.sit.b1.f23621718.parsers.contracts.Parser;

import java.util.List;

public class QueryParser implements Parser<List<QueryCommand>> {
    @Override
    public List<QueryCommand> parse(String s) {
        return List.of();
    }
}
