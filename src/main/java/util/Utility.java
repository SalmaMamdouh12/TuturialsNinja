package util;

import java.util.Random;

public class Utility {

    public static String generateRandomName() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();

        // Generate random length between 20 and 30
        int length = 20 + random.nextInt(11); // 11 because nextInt is exclusive of the upper bound

        StringBuilder name = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            name.append(characters.charAt(random.nextInt(characters.length())));
        }

        return name.toString();
    }

    public static String generateRandomGmail() {
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();

        int length = 8 + random.nextInt(8); // length between 8 and 15

        StringBuilder username = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            username.append(characters.charAt(random.nextInt(characters.length())));
        }

        return username.toString() + "@gmail.com";
    }


    public static String generaterandomDigits(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++)
            sb.append((int) (Math.random() * 10));
        return sb.toString();
    }

    public static String generatecomplexPassword(int length) {
        String all = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@#$%&*!";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++)
            sb.append(all.charAt((int) (Math.random() * all.length())));
        return sb.toString();
    }
}
