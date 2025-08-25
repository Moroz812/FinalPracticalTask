import java.util.Map;

public class Main {
    public static void main(String[] args) {
            // создаем экземпляр генератора
            RandomNumberGenerator generator = new RandomNumberGenerator();

            // генерируем массив из 10000 случайных чисел от 1 до 1000
            System.out.println("Генерация случайных чисел...");
            int[] numbers = generator.generateNumbers(10000, 1, 1000);

        // выполняем агрегацию
        System.out.println("Выполнение агрегации...");
        Map<Integer, Integer> aggregation = generator.aggregateNumbers(numbers);
    }
}