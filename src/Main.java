public class Main {
    public static void main(String[] args) {
            // создаем экземпляр генератора
            RandomNumber generator = new RandomNumber();

            // генерируем массив из 10000 случайных чисел от 1 до 1000
            System.out.println("Генерация случайных чисел...");
            int[] numbers = generator.generateNumbers(10000, 1, 1000);
    }
}