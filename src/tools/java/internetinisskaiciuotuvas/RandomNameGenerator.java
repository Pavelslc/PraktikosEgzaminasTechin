package internetinisskaiciuotuvas;

import java.io.IOException;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class RandomNameGenerator {
    private static final String ALLOWED_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
    private static final Random random = new Random();

    public static String generateRandomName(int length) {
        if (length < 1) {
            throw new IllegalArgumentException("Length must be at least 1.");
        }

        StringBuilder nameBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(ALLOWED_CHARS.length());
            nameBuilder.append(ALLOWED_CHARS.charAt(randomIndex));
        }

        return nameBuilder.toString();
    }

    public static String generateRandomName() {
        return generateRandomName(10);
    }
}

