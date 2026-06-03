import java.util.List;
import java.util.stream.Collectors;

public class FilterProcessor {

    @DataProcessor
    public List<String> filter(List<String> data) {

        return data.stream()
                .filter(s -> s.length() > 4)
                .collect(Collectors.toList());

    }
}
