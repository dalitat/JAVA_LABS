//загрузка и сохр данных
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileManager {

    public List<String> load(String fileName) throws IOException {

        return Files.readAllLines(Paths.get(fileName));

    }

    public void save(List<String> data, String fileName) throws IOException {

        Files.write(Paths.get(fileName), data);

    }
}
