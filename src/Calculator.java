import java.util.Arrays;
import java.util.Scanner;

class Calculator {
    static String[] roman = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XII", "XCIII", "XCIV", "XCV", "XCVI", "XVII", "XCVIII", "ХХIХ", "C"};
    static String[] charAllowedRoman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    static String[] charAllowedArab = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    public static void main(String[] args) throws Error {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        if(string.length() < 5)throw new Error("Некорректная математическая операция "+string);
        String[] strNum = string.split("\\s+[+\\-/*]\\s+", 2);//разбиваем на 2 части используя разделители[+\\-*/] и пробел(\\s+)
        String[] operatorArr = string.split("\\s+");//разбиваем строку если в ней содержится 1 или более раз пробел(\\s+)
        String operator = operatorArr[1];
        if(operator.length() != 1) throw new Error("Некорректное число операторов: " +operatorArr[1]);
        if(strNum.length != 2) throw new Error("Некорректное число операндов");

        if (Arrays.asList(charAllowedArab).contains(strNum[0]) && Arrays.asList(charAllowedArab).contains(strNum[1])){
            int resultArabic;
            int num1 = Integer.parseInt(strNum[0]);
            int num2 = Integer.parseInt(strNum[1]);
            resultArabic = switch (operator) {
                case ("+") -> num1 + num2;
                case ("-") -> num1 - num2;
                case ("*") -> num1 * num2;
                case ("/") -> num1 / num2;
                default -> throw new Error("Некорректный оператор "+operator);
            };
            System.out.println(resultArabic);
        } else if (Arrays.asList(charAllowedRoman).contains(strNum[0]) && Arrays.asList(charAllowedRoman).contains(strNum[1])) {
            int resultRoman;
            int numR1 = Arrays.asList(roman).indexOf(strNum[0]);
            int numR2 = Arrays.asList(roman).indexOf(strNum[1]);
            resultRoman = switch (operator) {
                case ("+") -> numR1 + numR2;
                case ("-") -> numR1 - numR2;
                case ("*") -> numR1 * numR2;
                case ("/") -> numR1 / numR2;
                default -> throw new Error("Некорректный оператор: " + operator);
            };
            if (resultRoman < 0)
                throw new Error("Невозможно написать " + resultRoman + " в римских цифрах.\nВ римской системе нет отрицательных чисел");
            if (resultRoman == 0)
                throw new Error("Невозможно написать " + resultRoman + " в римских цифрах.\nВ римской системе нет нуля");

            System.out.println(roman[resultRoman]);
        } else {
            throw new Error("Используются разные системы счисления");
        }
    }
}