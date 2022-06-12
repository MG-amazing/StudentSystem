package one.code;

import java.util.Random;

public class Code {
    public static int getCode() {
        Random r1 = new Random();
        int num1 = r1.nextInt(10);
        return num1;
    }
}
