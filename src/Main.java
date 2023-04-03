/*
Текст задания в файле src.Текст задания.txt
 */
class Fraction {
    int numerat, denumerat;

    Fraction(int numerat, int denumerat) {
        this.numerat = numerat;
        this.denumerat = denumerat;
    }

    static void fraction(int numerat, int denumrat) {
        int n = gcdByEuclidsAlgorihm(numerat, denumrat);
        System.out.println(numerat / n + " / " + denumrat / n);
    }

    static int gcdByEuclidsAlgorihm(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcdByEuclidsAlgorihm(n2, n1 % n2);
    }
}

public class Main {

    static int getDenumerateDouble(double num, int step) {
        double doub = num * step; // смещаем дробную часть к целой
        return (int) doub % step; // отбрасываем исходную целую часть
    }

    private static int getStep(double num) {
        String[] array = String.valueOf(num).split("[.]"); // разбиваем число с палавающей точкой на массив
        int len = array[1].length(); // определяем количество цифр в дробной части
        return (int) Math.pow(10, len); // определяем коэффициент для смещения
    }

    public static void main(String[] args) {
        int denumerateDouble; // знаменатель числа с плавающей точкой
        int step; // шаг для смещения дробной части числа с плавающей точкой
        Fraction fract = new Fraction(20, 10);
        Fraction.fraction(fract.numerat, fract.denumerat);
        double f = 45.67;
        int d = (int) f; // отбрасываем дробную часть с плаващей точкой
        if (d == f) {
            denumerateDouble = 0;
            step = 1;
        } else {
            step = getStep(f);
            denumerateDouble = getDenumerateDouble(f, step);
        }
        System.out.println(step);
        System.out.println(denumerateDouble);

    }
}