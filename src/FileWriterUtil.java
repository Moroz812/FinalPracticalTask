import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

// класс для записи данных в файл
public class FileWriterUtil {

    // метод для записи результатов агрегации в файл
    public void writeAggregationToFile(Map<Integer, Integer> aggregation, String filename) throws IOException {
        FileWriter writer = new FileWriter(filename); // вызываем конструктор FileWriter

        // проходим по всем записям в карте агрегации
        for (Map.Entry<Integer, Integer> entry : aggregation.entrySet()) {
            // записываем строку в формате "число - количество"
            writer.write(entry.getKey() + " - " + entry.getValue() + ";\n");
        }
        writer.close(); // закрываем файл
    }
}
// метод для записи результатов логических операций в файл