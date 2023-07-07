package 算法很美.P5字符串;

import java.util.Scanner;

//编写一个方法，给一个字符串，将其中的空格改为umr
public class ReplaceSpace {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        System.out.print("替换后的字符串:");
        System.out.println(str.replaceAll(" ", "umr"));

    }
}
