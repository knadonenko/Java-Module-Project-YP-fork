import java.util.HashMap;
import java.util.Locale;

public class Calculator {

    private final HashMap<String, Double> goods = new HashMap<>();

    public void addGoods() {
        while (true) {
            String command;
            System.out.println("Добавить товар? Для окончания введите 'завершить'");
            command = Main.scanner.nextLine();
            if (command.equalsIgnoreCase("завершить")) {
                break;
            }
            System.out.println("Введите стоимость товара например: '10.45'");
            if (Main.scanner.hasNextDouble()) {
                double price = Main.scanner.nextDouble();
                storeGoods(command, price);
                Main.scanner.nextLine();
            } else {
                System.out.println("Введено неверное значение");
                Main.scanner.nextLine();
            }
        }
        Main.scanner.close();
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
        goods.forEach((k, v) -> System.out.printf(Locale.US, "%s %.2f%n", k, v));
    }

    public double getFinalSum(int numberOfPersons) {
        return goods.values().stream().mapToDouble(Double::doubleValue).sum() / numberOfPersons;
    }

}
