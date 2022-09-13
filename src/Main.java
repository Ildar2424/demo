import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

class Calculator {


    public static void main(String[] args) throws Exception {
        String input;
        System.out.print("Добро пожаловать! Этот калькулятор поддерживает простейшие математические операции. \nВведите математическое выражение арабскими или римскими цифрами. \nПрописывайте его строго с пробелами: ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println( calc(str));

    }

    public static String calc(String str) throws Exception {

        String[] str_1 = str.split(" "); // Делим на части и передаем в массив.
        String[] a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] z = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] b = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        List<String> rim = new ArrayList<String>();
        rim = Arrays.asList(b);
        if (str_1.length != 3) {
            throw new Exception("Неверное выражение. Проверьте, верно ли указаны пробелы. Или еще что не так");
        } else {
            boolean found1 = false;
            boolean found2 = false;

            if ((rim.contains(str_1[0]) == false)) {
                int num1 = Integer.parseInt(str_1[0]);
                int num2 = Integer.parseInt(str_1[2]);
                for (String x : a) {
                    if (x.equals(str_1[0]) && (num1 != 0)) { // проверка, соответствует первый ли элемент(арабские числа) введеного выражения массиву.
                        found1 = true;
                        break;
                    }
                }
                if (found1 == false) {
                    throw new Exception("Первое число " + str_1[0] + " не соответствует тз.");
                }
                for (String x : a) {
                    if (x.equals(str_1[2]) && (num2 != 0)) { // проверка, соответствует ли Второй элемент(арабские числа) введеного выражения массиву.
                        found2 = true;
                        break;
                    }
                }
                if (found2 == false) {
                    throw new Exception("Второе " + str_1[2] + " не соответствует тз.");
                }
                if (found1 == true && found2 == true) {
                    if (str.contains(" + ")) {
                        return ("Ответ: " + Integer.toString(num1 + num2));
                    } else if (str.contains(" - ")) {
                        return ("Ответ: " + Integer.toString(num1 - num2));
                    } else if (str.contains(" * ")) {
                        return ("Ответ: " + Integer.toString(num1 * num2));
                    } else if (str.contains(" / ")) {
                        return ("Ответ: " + Integer.toString(num1 / num2));

                    } else {
                        throw new Exception("Неверный знак операции.");
                    }
                }
            } else if (rim.contains(str_1[0])) { // Начинаем проверять римские
                int numRim1 = rim.indexOf(str_1[0]);
                int numRim2 = rim.indexOf(str_1[2]);
                for (String x : z) {
                    if (x.equals(str_1[0]) && (numRim1 != 0)) { // проверка, соответствует первый ли элемент(римские числа) введеного выражения массиву.
                        found1 = true;
                        break;
                    }
                }
                if (found1 == false) {
                    throw new Exception("Первое число " + str_1[0] + " не соответствует тз.");
                }
                for (String x : z) {
                    if (x.equals(str_1[2]) && (numRim2 != 0)) { // проверка, соответствует ли Второй элемент(римские числа) введеного выражения массиву.
                        found2 = true;
                        break;
                    }
                }
                if (found2 == false) {
                    throw new Exception("Второе " + str_1[2] + " не соответствует тз.");
                }
                if (found1 == true && found2 == true) {
                    if (str.contains(" + ")) {
                        if ((numRim1 + numRim2) <= 0) {
                            throw new Exception("Римские числа не могут быть меньше 1");
                        } else {
                            return ("Ответ: " + b[(numRim1 + numRim2)]);
                        }
                    } else if (str.contains(" - ")) {
                        if ((numRim1 - numRim2) <= 0) {
                            throw new Exception("Римские числа не могут быть меньше 1");
                        } else {
                            return ("Ответ: " + b[(numRim1 - numRim2)]);
                        }
                    } else if (str.contains(" * ")) {
                        if ((numRim1 * numRim2) <= 0) {
                            throw new Exception("Римские числа не могут быть меньше 1");
                        } else {
                            return ("Ответ: " + b[(numRim1 * numRim2)]);
                        }
                    } else if (str.contains(" / ")) {
                        if ((numRim1 / numRim2) <= 0) {
                            throw new Exception("Римские числа не могут быть меньше 1");
                        } else {
                            return ("Ответ: " + b[(numRim1 / numRim2)]);
                        }
                    } else {
                        throw new Exception ("Неверный знак операции.");
                    }
                } else {
                    System.out.println("Эта строчка никогда не появится в кальке");
                }
            } else {
                System.out.println("Эта строчка никогда не появится в кальке");
            }
        }
        return str;
    }
}



