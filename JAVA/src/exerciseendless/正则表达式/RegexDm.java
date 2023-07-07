package exerciseendless.正则表达式;

import java.util.Scanner;

public class RegexDm {
/*//    判断录入的手机号是否为13或者18开头
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入手机号：");
        String s = sc.nextLine();

        String regex = "1[38]\\d{9}";//定义手机号规则
        boolean flag = s.matches(regex);//判断功能
        System.out.println(flag);
    }*/



/*//    分割功能
    public static void main(String[] args) {
        String age = "18-24";//定义年龄范围
        String regex = "-";
        String[] strArr = age.split(regex);//分割成字符串数组

        for (int i = 0; i <strArr.length ; i++) {
            System.out.println(strArr[i]);
        }

        int startAge = Integer.parseInt(strArr[0]);
        int endAge = Integer.parseInt(strArr[1]);

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的年龄：");
        int a = sc.nextInt();
        if (a >= startAge && a <= endAge) {
            System.out.println("你就是我想找的");
        } else {
            System.out.println("滚");
        }
    }*/



//3、替换功能
public static void main(String[] args){
    String s = "12342jasfkgnas234";
    //把字符串里面的数字替换成*
    String regex = "\\d";
    String ss = "*";
    String result = s.replaceAll(regex,ss);
    System.out.println(result);
}


/*//    效验QQ号（要求：5-15位数字，0不能开头）
public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("请输入您的QQ号码：");
    String qq = sc.nextLine();
    System.out.println("checkQQ:"+checkQQ(qq));
}

    private static boolean checkQQ(String qq) {
        return qq.matches("[1-9]{1}\\d{4,14}");
    }
*/
}