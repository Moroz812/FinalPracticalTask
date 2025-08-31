import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

//класс для записи данных в файл и автоматической нумерации новый файлов
public class FileWriterUtil {

    //метод для получения имени файла с номером
    String getFilename(String baseName, String extension) {
        int counter = 1; //начинаем с 1
        String filename = baseName + "." + extension; //дефолтное имя файла

        //файл с таким именем существует - увеличиваем счетчик
        while (new File(filename).exists()) {
            filename = baseName + "_" + counter + "." + extension;
            counter++;
        }
        return filename; //возвращаем имя файла
    }

    //метод для записи результатов агрегации в файл
    public String writeAggregationToFile(Map<Integer, Integer> aggregation, String filename) throws IOException {
        //String filename = getFilename(baseFilename, "txt"); //получаем имя файла
        FileWriter writer = new FileWriter(filename); //вызываем конструктор FileWriter с перезаписью
        //проходим по всем записям в карте агрегации
        for (Map.Entry<Integer, Integer> entry : aggregation.entrySet()) {
            //записываем строку в формате "число - количество"
            writer.write(entry.getKey() + " - " + entry.getValue() + ";\n");
        }
        writer.close(); //закрываем файл
        return filename; //возвращаем имя созданного файла
    }

    //метод для записи результатов логических операций в файл
    public void writeLogicalOperationsToFile(String content, String filename) throws IOException {
        FileWriter writer = new FileWriter(filename, true); //создаём FileWriter для записи с продолжением файла
        writer.write(content + "\n"); //запись результата операции
        writer.close(); //закрытие файла
    }

/*
    //метод для записи результатов логических операций в файл
    public void writeLogicalOperationsToFile(String operation, String result, String baseFilename) throws IOException {
        String filename = getFilename(baseFilename, "txt"); //получаем имя файла
        FileWriter writer = new FileWriter(filename, true); //создаём FileWriter для записи в файл
        writer.write(result + "\n"); //запись результата операции
        writer.close(); //закрытие файла
    } */
}