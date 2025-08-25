import java.util.Random;

// класс для генерации случайных чисел
public class RandomNumber {
    private Random random; // объект для генерации случайных чисел

    // конструктор класса
    public RandomNumber() {
        this.random = new Random(); // инициализация
    }

    // метод для генерации массива случайных чисел
    public int[] generateNumbers(int count, int min, int max) {
        int[] numbers = new int[count]; // создаем массив

        // заполняем массив случайными числами в заданном диапазоне
        for (int i = 0; i < count; i++) {
            numbers[i] = random.nextInt(max - min + 1) + min; // генерируем число от min до max
        }
        return numbers; // возвращаем массив
    }
}

// Метод для агрегации - подсчета количества вхождений каждого числа