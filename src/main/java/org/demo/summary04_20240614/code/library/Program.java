package org.demo.summary04_20240614.code.library;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import com.github.javafaker.Faker;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Data
class User {
    @Getter
    @Setter
    private String name;

    // @Getter(value = lombok.AccessLevel.NONE)
    private Date birthday;
}

public class Program {
    public static void main(String[] args) {

        LocalDate localDate = LocalDate.of(1990, 8, 28);
        User user1 = User.builder()
                .name("имя")
                .birthday(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        System.out.println(user1.getName());
        System.out.println(user1.getBirthday());
        System.out.println(user1);

        Faker faker = new Faker(Locale.of("en"), new Random(0));

        User user2 = User.builder()
                .name(faker.name().fullName())
                .birthday(faker.date().birthday(18, 71))
                .build();

        System.out.println(user2.getName());
        System.out.println(user2.getBirthday());
        System.out.println(user2);

        System.out.println(user1.equals(user2));
    }
}
