import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DataManager {

    private List<String> data; 
    private List<Object> processors;
    private FileManager fileManager;

    public DataManager() {

        data = new ArrayList<>();
        processors = new ArrayList<>();
        fileManager = new FileManager();

    }

    public void registerDataProcessor(Object processor) { //дооо

        processors.add(processor);

    }

    public void loadData(String source) throws Exception {

        data = fileManager.load(source);

    }

    public void processData() throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (Object processor : processors) { //п

            for (Method method : processor.getClass().getDeclaredMethods()) {

                if (method.isAnnotationPresent(DataProcessor.class)) {

                    Future<List<String>> future =
                            executor.submit(() ->
                                    (List<String>) method.invoke(processor, data));

                    data = future.get();

                }
            }
        }

        executor.shutdown();

    }

    public void saveData(String destination) throws Exception {

        fileManager.save(data, destination);

    }
}
