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
            int num1 = firstHalf[i];
            int num2 = secondHalf[i];
            //преобразуем числа в двоичный вид
            String binary1 = binaryOps.decimalToBinary(num1);
            String binary2 = binaryOps.decimalToBinary(num2);
            String binaryResult = binaryOps.andOperation(num1, num2);
            int decimalResult = binaryOps.binaryToDecimal(binaryResult); //преобразование в десятичное
            //формируем наглядную строку результата
            String output = "(" + num1 + " = " + binary1 + ") AND (" + num2 + " = " + binary2 + ") = " + decimalResult + " = " + binaryResult;
            fileWriter.writeLogicalOperationsToFile("AND", output, "and_operations.txt");
        }
        System.out.println("Операции AND записаны в файл and_operations.txt");

        //операция ИЛИ (OR)
        for (int i = 0; i < half; i++) {
            int num1 = firstHalf[i];
            int num2 = secondHalf[i];
            //преобразуем числа в двоичный вид
            String binary1 = binaryOps.decimalToBinary(num1);
            String binary2 = binaryOps.decimalToBinary(num2);
            String binaryResult = binaryOps.orOperation(num1, num2);
            int decimalResult = binaryOps.binaryToDecimal(binaryResult); //преобразование в десятичное
            //формируем наглядную строку результата
            String output = "(" + num1 + " = " + binary1 + ") OR (" + num2 + " = " + binary2 + ") = " + decimalResult + " = " + binaryResult;
            fileWriter.writeLogicalOperationsToFile("OR", output, "or_operations.txt");
        }
        System.out.println("Операции OR записаны в файл or_operations.txt");

        //операция Штрих Шеффера (NAND)
        for (int i = 0; i < half; i++) {
            int num1 = firstHalf[i];
            int num2 = secondHalf[i];
            //преобразуем числа в двоичный вид
            String binary1 = binaryOps.decimalToBinary(num1);
            String binary2 = binaryOps.decimalToBinary(num2);
            String binaryResult = binaryOps.nandOperation(num1, num2);
            int decimalResult = binaryOps.binaryToDecimal(binaryResult); //преобразование в десятичное
            //формируем наглядную строку результата
            String output = "(" + num1 + " = " + binary1 + ") NAND (" + num2 + " = " + binary2 + ") = " + decimalResult + " = " + binaryResult;
            fileWriter.writeLogicalOperationsToFile("NAND", output, "nand_operations.txt");
        }
        System.out.println("Операции NAND записаны в файл nand_operations.txt");
        System.out.println("Программа завершена успешно!");
    }
}