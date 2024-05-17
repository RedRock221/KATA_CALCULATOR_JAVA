import java.io.IOException;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws KException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите уровнение");
        String str1 = sc.nextLine();
        String[] string = str1.split(" "); // преобразование строки с разделением пробелом
        int test = 0, t2 = 0, num = 0, num1 = 0, num2 = 0;
        boolean t = false;

        switch (string.length) { //тут идёт проверка кол. переменных
            case 1:
                throw new KException("т.к. строка не является математической операцией");
            case 3:
                for(int i = 0; i < string.length; ++i) { //проверка на римские числа
                    char[] V = new char[]{'I', 'V', 'X'};
                    char[] charArray = string[i].toCharArray();

                    for(int j = 0; j < charArray.length; ++j) {
                        t = false;
                        for(int k = 0; k < V.length; ++k) {
                            if (charArray[j] == V[k]) {
                                t = true;
                            }
                        }
                    }
                    if (t) {
                        t2 = t2 + 1; //суммирование римских чисел в уравнении
                    }
                }
                switch (t2) {
                    case 0:
                        try {
                            num1 = Integer.parseInt(string[0]);
                            num2 = Integer.parseInt(string[2]);
                        } catch (NumberFormatException e) {
                            throw new KException("Ошибка ввода данных");
                        }
                        break;
                    case 1:
                        throw new KException("т.к. используются одновременно разные системы счисления");
                    case 2: //
                        Rome_num r1 = Rome_num.valueOf(string[0]);
                        Rome_num r2 = Rome_num.valueOf(string[2]);
                        num1 = Integer.parseInt(String.valueOf(r1.getNum()));
                        num2 = Integer.parseInt(String.valueOf(r2.getNum()));
                        break;
                        case 3:
                            throw new KException("Ошибка ввода данных");
                }
                break;
            default:
                throw new KException("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

        if(num1 > 0 && num1 < 11 && num2 > 0 && num2 < 11) { // проверка что число от 1 до 10
        } else {
            throw new KException("т.к. по условиям задачи числа от 1 до 10");
        }

        switch (string[1]) { // определение действия с переменными
            case "+":
                num = num1 + num2;
                break;
            case "-":
                num = num1 - num2;
                break;
            case "*":
                num = num1 * num2;
                break;
            case "/":
                num = num1 / num2;
                break;
            default:
                throw new KException("т.к. неправильно выбрана операция");
        }

        if (t2 == 2) {
            if(num < 0 || num == 0) {
                throw new KException("т.к. в римской системе нет отрицательных чисел");
            }
            for ( ; ; ) {
                if (num > 100 || num == 100){
                    System.out.print("C");
                    num = num - 100;
                }else if (num > 90 || num == 90){
                    System.out.print("XC");
                    num = num - 90;
                }else if (num > 50 || num == 50){
                    System.out.print("L");
                    num = num - 50;
                }else if (num > 40 || num == 40){
                    System.out.print("XL");
                    num = num - 40;
                }else if (num > 10 || num == 10){
                    System.out.print("X");
                    num = num - 10;
                }else if (num > 9 || num == 9){
                    System.out.print("IX");
                    num = num - 9;
                }else if (num > 5 || num == 5){
                    System.out.print("v");
                    num = num - 5;
                }else if (num > 4 || num == 4){
                    System.out.print("IV");
                    num = num - 4;
                }else if (num > 1 || num == 1) {
                    System.out.print("I");
                    num = num - 1;
                }else if (num == 0) {
                    return;
                }
            }
        } else {
            System.out.println(num);
        }
    }
}