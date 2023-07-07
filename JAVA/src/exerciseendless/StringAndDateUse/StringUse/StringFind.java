package exerciseendless.StringAndDateUse.StringUse;
//统计某段字符在一个字符串中出现的次数
import java.util.Scanner;

public class StringFind {
    public static void main(String[] args) {
        int count=0;
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String find="aa";
//        int index=str.indexOf(find);
        while (find.length()<str.length()){
            str=str.substring(str.indexOf(find)+ find.length());
            count++;
        }
        System.out.println(count);
    }
}
