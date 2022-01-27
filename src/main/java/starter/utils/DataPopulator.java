package starter.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;


import java.util.List;

import static java.util.stream.Collectors.toList;

public class DataPopulator {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> List<T> populate(final DataTable table, final Class<T> returnType) {
        return table.asMaps().stream().map(data -> mapper.convertValue(data, returnType)).collect(toList());
    }

    public static <T> T populateSingleEntity(final DataTable table, final Class<T> returnType) {
        return populate(table, returnType).get(0);
    }
}
