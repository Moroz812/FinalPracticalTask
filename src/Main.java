import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        // создаем экземпляр генератора
        RandomNumberGenerator generator = new RandomNumberGenerator();
        // создаем экземпляр записи в файл
        FileWriterUtil fileWriter = new FileWriterUtil();

        // генерируем массив из 10000 случайных чисел от 1 до 1000
        System.out.println("Генерация случайных чисел...");
        int[] numbers = generator.generateNumbers(10000, 1, 1000);

        // выполняем агрегацию
        System.out.println("Выполнение агрегации...");
        Map<Integer, Integer> aggregation = generator.aggregateNumbers(numbers);
        fileWriter.writeAggregationToFile(aggregation, "aggregation.txt");
        System.out.println("Агрегация записана в файл aggregation.txt");

        // делим массив пополам и записываем обе части в новые массивы
        int half = numbers.length / 2;
        int[] firstHalf = new int[half]; // первая часть
        int[] secondHalf = new int[half]; // вторая часть

        // в цикле заполняем половины массивов
        for (int i = 0; i < half; i++) {
            firstHalf[i] = numbers[i]; // первая половина
            secondHalf[i] = numbers[i + half]; // вторая половина
        }
    }
}