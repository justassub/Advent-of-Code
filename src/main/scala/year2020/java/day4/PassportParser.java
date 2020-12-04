package year2020.java.day4;

import java.util.HashMap;
import java.util.Map;

public class PassportParser {
    public static Map<String, String> parsePassportFields(String line) {
        Map<String, String> fields = new HashMap<>();
        String[] fieldsWithValues = line.split(" ");
        for (String fieldWithValue : fieldsWithValues) {
            String[] splitInfo = fieldWithValue.split(":");
            fields.put(splitInfo[0], splitInfo[1]);
        }
        return fields;
    }
}
