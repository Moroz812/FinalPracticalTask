//класс для работы с двоичными числами и логическими операциями
public class BinaryOperations {

    //метод для преобразования десятичного числа в двоичную строку
    public String decimalToBinary(int decimal) {
        return Integer.toBinaryString(decimal); //используем встроенный метод Java
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
}