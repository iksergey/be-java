package org.demo.seminar14_20240729.code;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Ex001_RegExIntro {
    public static void main(String[] args) {
        String[] patterns = {
                "\\d{3}-\\d{2}-\\d{4}",
                "(\\d{3})-(\\d{2})-(\\d{4})",
                "[0-9]{3}-[0-9]{2}-[0-9]{4}",
                "\\d{3,3}-\\d{2,2}-\\d{4,4}",
                "\\b\\d{3}-\\d{2}-\\d{4}\\b",
                "^\\d{3}-\\d{2}-\\d{4}$",
                "(?<area>\\d{3})-(?<exchange>\\d{2})-(?<subscriber>\\d{4})",
        };
        String[] phones = {
                "123-45-6789",
                "12-24-56",
                "123 456-11-2211",
                "123-12-2345 11 22",
        };

        for (int i = 0; i < patterns.length; i++) {
            String patternStr = patterns[i];
            Pattern pattern = Pattern.compile(patternStr);
            for (int j = 0; j < phones.length; j++) {
                String phone = phones[j];
                Matcher matcher = pattern.matcher(phone);
                boolean matcherResult = matcher.matches();
                // matcher.reset();
                matcher = pattern.matcher(phone);
                boolean findResult = matcher.find();

                System.out.printf("Соответствие [%s] на [%s]: %s | %s >> \n",
                        phone,
                        patternStr,
                        matcherResult,
                        findResult);

            }
            System.out.println();
        }
    }
}
