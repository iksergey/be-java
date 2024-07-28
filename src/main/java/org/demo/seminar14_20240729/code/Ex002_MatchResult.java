package org.demo.seminar14_20240729.code;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.MatchResult;

public class Ex002_MatchResult {
    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("(\\d{3})-(\\d{2})-(\\d{4})");
        Matcher matcher = pattern.matcher("123-45-6789");

        if (matcher.matches()) {
            MatchResult result = matcher.toMatchResult();
            System.out.println("Полное совпадение: " + result.group(0));
            System.out.println("Первая группа: " + result.group(1));
        }
    }
}
