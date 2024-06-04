public class MoneyHelper {

    public String convertSum(double sum) {

        int intSum = (int) Math.floor(sum);

        return switch (intSum % 10) {
            case 1 -> "рубль";
            case 2, 3, 4 -> "рубля";
            default -> "рублей";
        };

    }

}
