import java.util.Locale;
import java.util.Scanner;

public class Main {

    private static int numberOfPersons = 0;
    public static final Scanner scanner = new Scanner(System.in);
    private static final String GREETING_MESSAGE = "Введите число на сколько человек разделить счет:";

    public static void main(String[] args) {

        scanner.useLocale(Locale.US);
        printMessage(GREETING_MESSAGE);
        applyNumberOfPersons();

        Calculator calculator = new Calculator();
        calculator.addGoods();
        calculator.printGoods();

        double sum = calculator.getFinalSum(numberOfPersons);

        MoneyHelper moneyHelper = new MoneyHelper();
        String rubbles = moneyHelper.getCurrencyCase(sum);

        System.out.printf(Locale.US, "Сумма к оплате на персону: %.2f %s", sum, rubbles);

    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void applyNumberOfPersons() {
        while (numberOfPersons <= 1) {
            if (scanner.hasNextInt()) {
                numberOfPersons = scanner.nextInt();
            } else {
                System.out.println("Введены некорректные данные, введите целое число");
                scanner.next();
                continue;
            }
            if (numberOfPersons < 1) {
                System.out.println("Введено некорректное число персон. Введите целое число больше одного");
            } else if (numberOfPersons == 1) {
                System.out.println("Вы ввели 1, значит ели один, нет смысла делить счёт. Введите число больше одного");
            } else {
                System.out.println("Количество персон: " + numberOfPersons);
            }
        }
        scanner.nextLine();
    }
}