package core.validations;

import java.util.Scanner;

public class NameValidator {

    Scanner scan = new Scanner(System.in);

    public String isValidFirstName() {
        String name = "";
        do {
            name = scan.nextLine().trim();
            String s = name.replaceAll("[a-zA-Z ]", "");

            if (!s.isEmpty()) {
                System.out.println("Harf dışında bir karakter girilemez...");
                System.out.println("Tekrar deneyiniz: ");
            } else if (name.length() < 2 || name.length() > 20) {
                System.out.println("İsminiz en az 2 harf ve en fazla 20 harf içermelidir...");
                System.out.println("Tekrar deneyiniz: ");
            } else {
                break;
            }
        } while (true);

        return name;

    }

    public String isValidLastName() {
        Scanner scan = new Scanner(System.in);

        String lastName = "";
        do {
            lastName = scan.nextLine().trim();
            String s = lastName.replaceAll("[a-zA-Z ]", "");
            if (!s.isEmpty()) {
                System.out.println("Harf dışında bir karakter girilemez...");
                System.out.println("Tekrar deneyiniz: ");
            } else if (lastName.length() < 2 || lastName.length() > 20) {
                System.out.println("İsminiz en az 2 harf ve en fazla 20 harf içermelidir...");
                System.out.println("Tekrar deneyiniz: ");
            } else {
                break;
            }
        } while (true);

        return lastName;

    }


}
