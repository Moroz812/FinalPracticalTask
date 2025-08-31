//класс для работы с двоичными числами и логическими операциями
public class BinaryOperations {

    //метод для преобразования десятичного числа в двоичную строку
    public String decimalToBinary(int decimal) {
        return Integer.toBinaryString(decimal); //используем встроенный метод Java
    }

    //метод для преобразования двоичной строки в десятичное число
    public int binaryToDecimal(String binary) {
        return Integer.parseInt(binary, 2); //используем встроенный метод Java
    }

    //метод для выполнения логической операции И (AND)
    public String andOperation(int num1, int num2) {
        String binary1 = decimalToBinary(num1); //преобразуем первое число в двоичное
        String binary2 = decimalToBinary(num2); //преобразуем второе число в двоичное

        //выравниваем длины двоичных строк, добавляя нули слева
        int maxLength = Math.max(binary1.length(), binary2.length());
        binary1 = String.format("%" + maxLength + "s", binary1).replace(' ', '0');
        binary2 = String.format("%" + maxLength + "s", binary2).replace(' ', '0');

        StringBuilder result = new StringBuilder(); //создаем StringBuilder для результата

        //проходим по каждому биту и выполняем операцию И
        for (int i = 0; i < maxLength; i++) {
            char bit1 = binary1.charAt(i); //получаем i-тый бит первого числа
            char bit2 = binary2.charAt(i); //получаем i-тый бит второго числа

            //выполняем операцию И: 1 только если оба бита равны 1
            if (bit1 == '1' && bit2 == '1') {
                result.append('1');
            } else {
                result.append('0');
            }
        }
        return result.toString(); //возвращаем результат
    }

    //метод для выполнения логической операции ИЛИ (OR)
    public String orOperation(int num1, int num2) {
        String binary1 = decimalToBinary(num1); //преобразуем первое число в двоичное
        String binary2 = decimalToBinary(num2); //преобразуем второе число в двоичное

        //выравниваем длины двоичных строк
        int maxLength = Math.max(binary1.length(), binary2.length());
        binary1 = String.format("%" + maxLength + "s", binary1).replace(' ', '0');
        binary2 = String.format("%" + maxLength + "s", binary2).replace(' ', '0');

        StringBuilder result = new StringBuilder(); // Создаем StringBuilder для результата

        //проходим по каждому биту и выполняем операцию ИЛИ
        for (int i = 0; i < maxLength; i++) {
            char bit1 = binary1.charAt(i); //получаем i-тый бит первого числа
            char bit2 = binary2.charAt(i); //получаем i-тый бит второго числа

            //выполняем операцию ИЛИ: 1 если хотя бы один бит равен 1
            if (bit1 == '1' || bit2 == '1') {
                result.append('1');
            } else {
                result.append('0');
            }
        }
        return result.toString(); //возвращаем результат
    }

    //метод для выполнения операции Штрих Шеффера (NAND)
    public String nandOperation(int num1, int num2) {
        //Штрих Шеффера - это отрицание операции И
        String andResult = andOperation(num1, num2); //получаем результат И
        StringBuilder result = new StringBuilder(); //создаем StringBuilder для результата

        //инвертируем каждый бит в цикле (меняем 1 на 0 и 0 на 1)
        for (int i = 0; i < andResult.length(); i++) {
            if (andResult.charAt(i) == '1') {
                result.append('0');
            } else {
                result.append('1');
            }
        }
        return result.toString(); //возвращаем результат
    }
}