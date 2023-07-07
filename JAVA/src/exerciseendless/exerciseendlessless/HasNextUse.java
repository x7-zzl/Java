package exerciseendless.exerciseendlessless;

import java.util.Scanner;

public class HasNextUse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            String s = in.next();
            System.out.println("打印：" + s);
        }
    }
}
