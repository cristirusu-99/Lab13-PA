package com;

import java.util.Locale;

import static com.Info.localeInfo;

public class DisplayLocales {
    public static void printAvailableLocales() {
        System.out.println("Default locale:");
        localeInfo();
        System.out.println("Available locales:");
        Locale[] available = Locale.getAvailableLocales();
        for (Locale locale : available) {
            System.out.println("Country: " + locale.getDisplayCountry() +
                    "\t\tLanguage: " + locale.getDisplayLanguage(locale));
        }

    }
}
