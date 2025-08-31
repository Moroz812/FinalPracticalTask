import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//класс для генерации случайных чисел
public class RandomNumberGenerator {
    private Random random; //объект для генерации случайных чисел

    //конструктор класса
    public RandomNumberGenerator() {
        this.random = new Random(); //инициализация
    }

    //метод для генерации массива случайных чисел
    public int[] generateNumbers(int count, int min, int max) {
        int[] numbers = new int[count]; //создаем массив

        //заполняем массив случайными числами в заданном диапазоне
        for (int i = 0; i < count; i++) {
            numbers[i] = random.nextInt(max - min + 1) + min; // генерируем число от min до max
        }
        return numbers; //возвращаем массив
    }

    //метод для агрегации - подсчета количества вхождений каждого числа
    public Map<Integer, Integer> aggregateNumbers(int[] numbers) {
        Map<Integer, Integer> aggregation = new HashMap<>(); //создаем карту для результатов

        //проходим по всем числам в массиве в цикле
        for (int number : numbers) {
            //если число уже есть, увеличиваем счетчик +1
            //если числа нет, добавляем число и счетчик
            aggregation.put(number, aggregation.getOrDefault(number, 0) + 1);
        }
        return aggregation; //возвращаем карту с результатами агрегации
    }
}