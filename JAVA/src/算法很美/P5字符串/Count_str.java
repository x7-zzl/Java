package 算法很美.P5字符串;

import java.util.Scanner;

public class Count_str {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("输入一段字符串:");
        String str = in.nextLine();
        System.out.println("请输入你要寻找的字符串:");
        String sToFind = in.nextLine();
        int count = countStr(str, sToFind);
        System.out.println("在此字符串中共找到" + count + "个" + sToFind);
    }

    public static int countStr(String strInput, String find) {
        int num = 0;
        if(strInput.contains(find)){
            while (strInput.contains(find)) {
                strInput = strInput.substring(strInput.indexOf(find) + find.length());
                num++;
            }
        }else {
            return -1;
        }

        return num;
    }
}
