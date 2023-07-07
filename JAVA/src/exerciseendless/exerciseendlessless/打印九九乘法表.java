package exerciseendless.exerciseendlessless;
//9*9乘法表
public class 打印九九乘法表 {

    public static void main(String[] args) {
        for (int i = 1; i <=9; i++) {
            for (int j = 1; j <=9; j++) {
                System.out.print(j+"*"+i+"="+(i*j)+"\t");
            }
            System.out.println();

        }

    }

}

