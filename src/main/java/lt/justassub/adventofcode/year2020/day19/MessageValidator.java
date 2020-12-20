
package lt.justassub.adventofcode.year2020.day19;

import java.util.List;
import java.util.Set;

public interface MessageValidator {
    String validate(String message) throws NotValidException;

    void setMatchAny(List<List<MessageValidator>> validators);
}
