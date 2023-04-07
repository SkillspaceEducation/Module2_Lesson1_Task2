import java.util.Scanner;

/*
Текст задания в файле src.Текст задания.txt
 */
class Fraction {
    int numerat, denumerat;

    Fraction(int numerat, int denumerat) {
        this.numerat = numerat;
        this.denumerat = denumerat;
    }

    // метод для вывода дроби в текстовом виде
    static void printFraction(int numerat, int denumerat) {
        System.out.println("Дробь равна " + numerat + " / " + denumerat);
    }
}

class DoubleToFraction {
    double num;

    DoubleToFraction(double num) {
        this.num = num;
    }

    // метод для вывода числа с плавающй точкой в виде дроби
    static void printDoubleToFraction(double num) {
        if (num == 0.0) {
            System.out.println("Число с плавающей точкой равно нулю");
        } else {
            int step = getStep(num);
            System.out.println("Число с плавающей точкой в виде дроби равно " + (int) (num * step) + " / " + step);
        }
    }

    // метод для вычисления шага смещения числа с плавающей точкой
    static int getStep(double num) {
        String[] array = String.valueOf(num).split("[.]"); // разбиваем число с палавающей точкой на массив
        int len = array[1].length(); // определяем количество цифр в дробной части
        if ((int) num == num) {
            return 1; // если дробная часть числа равна нулю, смещение равно 1
        } else {
            return (int) Math.pow(10, len); // иначе определяем на размер сдвига
        }
    }
}

public class Main {

    // метод для получения реультата произведения дробей
    private static void composFraction(int n1, int n2, int n3, int n4) {
        int n5 = n1 * n3;
        int n6 = n2 * n4;
        if (n5 == 0 || n6 == 0) {
            System.out.println("Результат произведения дробей равен нулю");
        } else {
            int n7 = gcdByEuclidsAlgorihm(n5, n6);
            System.out.println("Результат произведения дробей равен " + (n1 * n3) / n7 + " / " +
                    (n2 * n4) / n7);
        }
    }

    // метод для получения результата деления дробей
    private static void divideFraction(int n1, int n2, int n3, int n4) {
        int n5 = n1 * n4;
        int n6 = n2 * n3;
        int n7 = gcdByEuclidsAlgorihm(n5, n6);
        try {
            int result = n5 / n6;
            System.out.println("Результат деления дробей равен " + (n1 * n4) / n7 + " / " +
                    (n2 * n3) / n7);
        } catch (ArithmeticException exp) {
            System.out.println("Деление на ноль");
        }
        if (n5 == 0) {
            System.out.println("Результат деления дробей равен нулю");
        }
    }

    // метод для получения общего знаменателя чисел для упрощения дроби
    private static int gcdByEuclidsAlgorihm(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcdByEuclidsAlgorihm(n2, n1 % n2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sNumerate, sDenumerate, sDoub;
        int numerate = 0;
        int denumerate = 0;
        double doub = 0.0;
        int error;

        do {
            System.out.println("Введите значение числителя");
            sNumerate = scanner.next();
            try {
                numerate = Integer.parseInt(sNumerate.trim());
                error = 0;
            } catch (NumberFormatException nfe) {
                System.out.println("Неверный ввод");
                error = 1;
            }
            if (error == 0) {
                break;
            }
        } while (error == 1);

        do {
            System.out.println("Введите значение знаменателя");
            sDenumerate = scanner.next();
            try {
                denumerate = Integer.parseInt(sDenumerate.trim());
                error = 0;
            } catch (NumberFormatException nfe) {
                System.out.println("Неверный ввод");
                error = 1;
            }
            if (error == 0) {
                if (denumerate == 0) {
                    System.out.println("Не может быть нулем");
                    error = 1;
                } else break;
            }
        } while (error == 1);

        do {
            System.out.println("Введите значение числа с плавающей точкой");
            sDoub = scanner.next();
            try {
                doub = Double.parseDouble(sDoub.trim());
                error = 0;
            } catch (NumberFormatException nfe) {
                System.out.println("Неверный ввод");
                error = 1;
            }
            if (error == 0) {
                break;
            }
        } while (error == 1);
        scanner.close(); // закрываем поток ввода

        Fraction fraction = new Fraction(numerate, denumerate); // создаем новый объект для дроби
        Fraction.printFraction(fraction.numerat, fraction.denumerat);

        DoubleToFraction fraction1 = new DoubleToFraction(doub); // создаем новый объект для числа с плавающей точкой
        DoubleToFraction.printDoubleToFraction(fraction1.num);
        // выполняем произведение дробей
        composFraction(fraction.numerat, fraction.denumerat, (int) (fraction1.num * DoubleToFraction.getStep(doub)),
                DoubleToFraction.getStep(doub));
        // выполнем деление дробей
        divideFraction(fraction.numerat, fraction.denumerat, (int) (fraction1.num * DoubleToFraction.getStep(doub)),
                DoubleToFraction.getStep(doub));
    }
}