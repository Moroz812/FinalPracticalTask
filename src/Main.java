import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        //создаем экземпляр генератора
        RandomNumberGenerator generator = new RandomNumberGenerator();
        //создаем экземпляр записи в файл
        FileWriterUtil fileWriter = new FileWriterUtil();
        //создаем экземпляр для перевода в двоичные
        BinaryOperations binaryOps = new BinaryOperations();

        //генерируем массив из 10000 случайных чисел от 1 до 1000
        System.out.println("Генерация случайных чисел...");
        int[] numbers = generator.generateNumbers(10000, 1, 1000);

        //выполняем агрегацию
        System.out.println("Выполнение агрегации...");
        Map<Integer, Integer> aggregation = generator.aggregateNumbers(numbers);
        fileWriter.writeAggregationToFile(aggregation, "aggregation.txt");
        System.out.println("Агрегация записана в файл aggregation.txt");

        //делим массив пополам и записываем обе части в новые массивы
        int half = numbers.length / 2;
        int[] firstHalf = new int[half]; // первая часть
        int[] secondHalf = new int[half]; // вторая часть

        //в цикле заполняем половины массивов
        for (int i = 0; i < half; i++) {
            firstHalf[i] = numbers[i]; // первая половина
            secondHalf[i] = numbers[i + half]; // вторая половина
        }

        //выполняем логические операции и записываем результаты в файлы
        System.out.println("Выполнение логических операций...");

        //операция И (AND)
        for (int i = 0; i < half; i++) {
            String binaryResult = binaryOps.andOperation(firstHalf[i], secondHalf[i]);
            int decimalResult = binaryOps.binaryToDecimal(binaryResult); //преобразование в десятичное
            String output = "(" + firstHalf[i] + ") AND (" + secondHalf[i] + ") = " + binaryResult + " = " + decimalResult;
            fileWriter.writeLogicalOperationsToFile("AND", output, "and_operations.txt");
        }
        System.out.println("Операции AND записаны в файл and_operations.txt");

        //операция ИЛИ (OR)
        for (int i = 0; i < half; i++) {
            String binaryResult = binaryOps.orOperation(firstHalf[i], secondHalf[i]);
            int decimalResult = binaryOps.binaryToDecimal(binaryResult); //преобразование в десятичное
            String output = "(" + firstHalf[i] + ") OR (" + secondHalf[i] + ") = " + binaryResult + " = " + decimalResult;
            fileWriter.writeLogicalOperationsToFile("OR", output, "or_operations.txt");
        }
        System.out.println("Операции OR записаны в файл or_operations.txt");

        //операция Штрих Шеффера (NAND)
        for (int i = 0; i < half; i++) {
            String binaryResult = binaryOps.nandOperation(firstHalf[i], secondHalf[i]);
            int decimalResult = binaryOps.binaryToDecimal(binaryResult); //преобразование в десятичное
            String output = "(" + firstHalf[i] + ") NAND (" + secondHalf[i] + ") = " + binaryResult + " = " + decimalResult;
            fileWriter.writeLogicalOperationsToFile("NAND", output, "nand_operations.txt");
        }
        System.out.println("Операции NAND записаны в файл nand_operations.txt");
        System.out.println("Программа завершена успешно!");
    }
}