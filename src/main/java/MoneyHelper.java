public class MoneyHelper {

    public String getCurrencyCase(double sum) {

        int intSum = (int) Math.floor(sum);

        var preLastDigit = intSum % 100 / 10;
        if (preLastDigit == 1) {
            return "рублей";
        }

        return switch (intSum % 10) {
            case 1 -> "рубль";
            case 2, 3, 4 -> "рубля";
            default -> "рублей";
        };

    }

}
