import java.util.HashMap;
import java.util.Scanner;

public class Calculator {

    private final Scanner SCANNER = new Scanner(System.in);
    private final HashMap<String, Double> goods = new HashMap<>();

    public void addGoods() {
        while (true) {
            String command;
            System.out.println("Добавить товар? Для окончания введите 'завершить'");
            command = SCANNER.next();
            if (command.equalsIgnoreCase("завершить")) {
                break;
            }
            System.out.println("Введите стоимость товара например: '10,45'");
            double price = SCANNER.nextDouble();
            storeGoods(command, price);
        }
        SCANNER.close();
    }

    private void storeGoods(String name, double price) {
        if (goods.containsKey(name)) {
            double calculated = goods.get(name) + price;
            goods.put(name, calculated);
        } else {
            goods.put(name, price);
        }
        System.out.printf("Товар %s успешно добавлен%n", name);
    }

    public void printGoods() {
        System.out.println("Добавленные товары:");
        goods.forEach((k, v) -> System.out.println(k + " " + v));
    }

    public double getFinalSum(int numberOfPersons) {
        return goods.values().stream().mapToDouble(Double::doubleValue).sum() / numberOfPersons;
    }

}
