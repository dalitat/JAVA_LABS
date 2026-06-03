import java.io.*;
import java.util.Scanner;

public class FileReadProgram {

    public static void readFile(String filename) throws CustomFileNotFoundException, IOException {
        File file = new File(filename);
        if (!file.exists()) {
            throw new CustomFileNotFoundException("Файл не найден: " + filename);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            System.out.println("Содержимое файла:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    public static void log(String text) {
        try (FileWriter writer = new FileWriter("exceptions_log.txt", true)) {
            writer.write(text + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Ошибка записи в лог файл.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите имя файла для чтения: ");
            String filename = scanner.nextLine();

            readFile(filename);

        } catch (CustomFileNotFoundException e) {
            System.out.println("Ошибка: " + e.getMessage());
            log(e.getClass().getSimpleName() + ": " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e.getMessage());
            log(e.getClass().getSimpleName() + ": " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
