package com;

import java.text.DateFormatSymbols;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.Currency;
import java.util.Locale;
import java.util.ResourceBundle;

public class Info {
    private static final String baseName = "com.Messages";

    public static  void localeInfo() {
        Locale locale = Locale.getDefault();
        printInfo(locale);
    }

    public static void localeInfo(Locale locale) {
        printInfo(locale);
    }

    private static void printInfo(Locale locale) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(baseName, locale);
        Object[] arguments = {locale.getDisplayLanguage()};
        String msg = new MessageFormat(resourceBundle.getString("info")).format(arguments);
        System.out.println(msg);
        Currency currency = Currency.getInstance(locale);
        DateFormatSymbols symbols = new DateFormatSymbols(locale);

        System.out.println("Country: " + locale.getDisplayCountry() + " ( " + locale.getDisplayCountry(locale) + "  )");
        System.out.println("Language: " + locale.getDisplayLanguage() + " ( " + locale.getDisplayLanguage(locale) + " ) ");

        String number = NumberFormat.getCurrencyInstance(locale).format(1);
        System.out.println("Currency: " + number + " ( " + currency.getDisplayName(locale) + " )");

        System.out.println("Week Days: " + Arrays.toString(symbols.getWeekdays()));
        System.out.println("Months: " + Arrays.toString(symbols.getMonths()));

        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter
                .ofLocalizedDate(FormatStyle.FULL)
                .withLocale(locale);
        System.out.println("Today: " + today.format(formatter));
    }
}
