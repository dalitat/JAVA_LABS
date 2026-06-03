import java.util.List;

public class AggregateProcessor {

    @DataProcessor
    public List<String> count(List<String> data) {

        System.out.println("кол-во элементов: " + data.size());

        return data;

    }
}
