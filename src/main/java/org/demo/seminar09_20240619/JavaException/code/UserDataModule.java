package org.demo.seminar09_20240619.JavaException.code;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class UserDataModule {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Введите имя (не более 20 символов):");
            String name = scanner.nextLine();
            if (name.length() > 20) {
                throw new NameLengthException("Имя не должно превышать 20 символов");
            }

            System.out.println("Введите фамилию (не более 20 символов):");
            String surname = scanner.nextLine();
            if (surname.length() > 20) {
                throw new SurnameLengthException("Фамилия не должна превышать 20 символов");
            }

            System.out.println("Введите дату рождения (формат YYYY-MM-DD):");
            String birthDateStr = scanner.nextLine();
            LocalDate birthDate;
            try {
                birthDate = LocalDate.parse(birthDateStr);
            } catch (DateTimeParseException e) {
                throw new InvalidDateFormatException("Дата рождения должна быть в формате YYYY-MM-DD");
            }

            System.out.println("Введите краткое описание (не более 100 символов):");
            String description = scanner.nextLine();
            if (description.length() > 100) {
                throw new DescriptionLengthException("Описание не должно превышать 100 символов");
            }

            System.out.println("Данные успешно введены!");

        } catch (NameLengthException | SurnameLengthException | InvalidDateFormatException
                | DescriptionLengthException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

class NameLengthException extends RuntimeException {
    public NameLengthException(String message) {
        super(message);
    }
}

class SurnameLengthException extends RuntimeException {
    public SurnameLengthException(String message) {
        super(message);
    }
}

class InvalidDateFormatException extends RuntimeException {
    public InvalidDateFormatException(String message) {
        super(message);
    }
}

class DescriptionLengthException extends RuntimeException {
    public DescriptionLengthException(String message) {
        super(message);
    }
}
