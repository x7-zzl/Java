package 算法很美.蓝桥杯真题.第七届;

/*2、生日蜡烛
        题目：某君从某年开始每年都举办一次生日party，并且每次都要吹熄与年龄相同根数的蜡烛。

        现在算起来，他一共吹熄了236根蜡烛。

        请问，他从多少岁开始过生日party的？

        请填写他开始过生日party的年龄数。

        注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。

        解析：等差数列求和 （Sn=[n*(a1+an)]/2）*/
public class Main2 {
    public static void main(String[] args) {
        int i, j;
        for (i = 1; i < 100; i++) {
            for (j = i; j < 100; j++) {
                if ((i + j) * (j - i + 1) / 2 == 236) {
                    System.out.println(i);
                }
            }
        }
    }
}
