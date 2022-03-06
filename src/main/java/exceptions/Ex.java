package exceptions;

import java.util.Scanner;

public class Ex {



    public static void main(String[] args) throws NullException {
        try {
            Scanner str = new Scanner(System.in);
            Integer x1 = 10;
            Integer x2 = 0;
            Integer x3 = 0;
            if (x2 == 0) throw new NullException("Второй аргумент равен нулю", x2);
            x3 = x1 / x2;
            System.out.println(x3);

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("finally complete");
        }
    }
}
