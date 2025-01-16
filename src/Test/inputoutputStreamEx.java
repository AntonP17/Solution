package Test;

import java.io.ByteArrayOutputStream;
import java.util.Random;

public class inputoutputStreamEx {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        int textLength = 8;
        ByteArrayOutputStream byteArrayOutputStream;
        Random random = new Random();

        while (true) {
            byteArrayOutputStream = new ByteArrayOutputStream();
            boolean hasLowercase = false;
            boolean hasUppercase = false;
            boolean hasDigit = false;

            for (int i = 0; i < textLength; i++) {
                int charType = random.nextInt(3); // 0 - lowercase, 1 - uppercase, 2 - digit

                byte randomChar;
                switch (charType) {
                    case 0:
                        randomChar = (byte) getRandomLowercaseLetter(random);
                        hasLowercase = true;
                        break;
                    case 1:
                        randomChar = (byte) getRandomUppercaseLetter(random);
                        hasUppercase = true;
                        break;
                    case 2:
                        randomChar = (byte) getRandomDigit(random);
                        hasDigit = true;
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + charType);
                }

                byteArrayOutputStream.write(randomChar);
            }

            // Проверяем, что пароль содержит хотя бы одну строчную, одну заглавную букву и одну цифру
            if (hasLowercase && hasUppercase && hasDigit) {
                break;
            }
        }

        return byteArrayOutputStream;
    }

    private static char getRandomLowercaseLetter(Random random) {
        return (char) (random.nextInt(26) + 'a');
    }

    private static char getRandomUppercaseLetter(Random random) {
        return (char) (random.nextInt(26) + 'A');
    }

    private static char getRandomDigit(Random random) {
        return (char) (random.nextInt(10) + '0');
    }
}
