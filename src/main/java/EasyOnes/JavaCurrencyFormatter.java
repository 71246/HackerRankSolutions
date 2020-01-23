package EasyOnes;

import java.text.*;
import java.util.Locale;

public class JavaCurrencyFormatter {
    public static void main(String[] args) {
        double payment = 12324.134;

        NumberFormat us = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat india = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        NumberFormat china = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat france = NumberFormat.getCurrencyInstance(Locale.FRANCE);

        System.out.println("us: " + us.format(payment));
        System.out.println("india: " + india.format(payment));
        System.out.println("china: " + china.format(payment));
        System.out.println("france: " + france.format(payment));

        /*
        String currency = NumberFormat.getCurrencyInstance(Locale.US).format(amount);
        System.out.println(currency);

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        currency = numberFormat.format(amount);
        System.out.println(currency);

        currency = NumberFormat.getCurrencyInstance(Locale.CHINA).format(amount);
        System.out.println(currency);

        currency = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(amount);
        System.out.println(currency);
        */
    }
}
