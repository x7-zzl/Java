package leetcode;
//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
//  如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
//  假设环境不允许存储 64 位整数（有符号或无符号）。

public class t7_整数反转 {
    public static void main(String[] args) {
        reverse(1534236469);
    }

    public static int reverse(int x) {
        String str=String.valueOf(x);
        StringBuilder sb=new StringBuilder();

        if(str.contains("-")){
            String substring = str.substring(1);
            sb.append(substring);
            sb.reverse();
        }else {
            sb.append(str);
            sb.reverse();
        }

        int result=0;
        try {
            result=Integer.parseInt(sb.toString());
        }catch (Exception ignored){
        }

        if(x<0){
            result=-result;
        }
        return result;
    }
}
