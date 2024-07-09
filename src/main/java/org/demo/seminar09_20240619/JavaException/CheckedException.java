package org.demo.seminar09_20240619.JavaException;

import java.io.File;
import java.io.FileReader;

public class CheckedException {
    public static void main(String[] args) {
        try {
            File file = new File("test.txt");
            FileReader fr = new FileReader(file);
        } catch (Exception ex) {
            System.out.println("error");
        }
    }
}
