package exerciseendless.exerciseendlessless;

import java.util.Scanner;

public class RoundArea {
    public static void main(String[] args) {
       final double PI=3.14159;
       Scanner in=new Scanner(System.in);
       double r=in.nextDouble();
        double h=in.nextDouble();
        double s=PI*r*r*2+2*PI*r*h;
        System.out.println(String.format("%.2f",s));
    }
}