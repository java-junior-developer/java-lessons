package lesson02;

public class Lesson02 {
    public static void main(String[] args) {
        // использование var возможно начиная с java 10
        var version = 10; // int
        var bigNumber = 10L; // long
        var connected = true; // boolean
        var balance = 4000.8; // double
        var weight = 50.5F; // float
        var price = (short) 290; // short

        // TODO #1
        int start = 30;
        start -= 10; // start = start - 10; 20
        start += 50; // 70
        start *= 100; // 7000
        start /= 10; // 700
        start %= 2; // 0

        // TODO #2
        int a = 50, b = 90, c = 50;
        boolean result = a < b; // true
        result = a != c; // false
        result = a == c; // true
        result = a >= c; // true
        result = a <= b; // true

        // TODO #3
        int x = 50, y = 100, z = 91;
        int code = 3333, age = 34;
        boolean isActive = false, isConnected = true;

        result = (x % 2 == 0) && (y % 2 == 0) && (z % 2 == 0); // false

        result = (x < z) && (y > z); // true

        result = (code == 2222) || (code == 3333) || (code == 4444); // true

        result = (code != 3333) || (age < 18); // false

        result = !result; // true

        result = !isActive || !isConnected; // true

        result = !(code != 3333) || (age < 18); // true

        result = !((code != 3333) || (age < 18)); // true

        // Тернарный оператор ?
        int dateStart = 3, dateEnd = 28;
        int res = dateStart > dateEnd ? -1 : 0; // 0

        // TODO #4 на тернарный оператор
        // Дана переменная sum01 - сумма покупки,
        // если сумма покупки выше 100000, покупатель получит скидку 10%,
        // в противном случае скидка не предусмотрена.
        // Вывести сумму покупки с учетом скидки.
        int sum01 = 2000;
        double result01 = sum01 > 100_000 ? sum01 * 0.9 : sum01;
        System.out.println(result01);

        var pass = 200;

        if (pass == 100) {
            System.out.println("Вы вошли как админ");
        } else if (pass == 200) {
            System.out.println("Вы вошли как пользователь");
        } else if (pass == 300) {
            System.out.println("Вы вошли как суперадмин");
        }

        // TODO #5 на if
        // Даны целочисленные переменные age - возраст и exp - опыт.
        // Если значение age больше 200 или меньше 18 программа выводит - "Мы Вам перезвоним"
        // В противном случае, если значение exp меньше 5,
        // программа выводит - "Вы подходите на должность младшего разработчика",
        // если значение exp больше или равно 5,
        // программа выводит - "Вы подходите на должность старшего разработчика".

        int age01 = 20, exp = 3;
        if (age01 > 200 || age01 < 18) System.out.println("Мы Вам перезвоним");
        if (exp < 5) System.out.println("... младшего разработчика");
        else System.out.println("... старшего разработчика");

        var smallNum = 1;

        {
            smallNum = -1;
            var bigNum = 100_000_000;
        }

        System.out.println(smallNum);
        // System.out.println(bigNum);
    }
}
