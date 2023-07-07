package 加减法口算习题.Version2;

import java.util.ArrayList;
import java.util.Random;

abstract class BinaryOperation {
    //定义变量
    static final int upper = 100;
    private int left_operand = 0, right_operand = 0;
    //运算符号
    private char operator = '+';
    @SuppressWarnings("ALL")
    private int value = 0;

    protected void generateBinaryOperation(char anOperator) {
        int left, right, result;
        Random random = new Random();
        left = random.nextInt(upper + 1);
        do {
            right = random.nextInt(upper + 1);
            result = calculate(left, right);
        } while (!(checkingCalculation(result)));
        left_operand = left;
        right_operand = right;
        operator = anOperator;
        value = result;
    }


    //抽象方法
    abstract boolean checkingCalculation(int anInteger);

    abstract int calculate(int left, int right);

    //实例变量访问器
    //成员变量访问方法
    public int getLeft_operand() {
        return left_operand;
    }

    public int getRight_operand() {
        return right_operand;
    }

    //字符串显示方法
    public char getOperator() {
        return operator;
    }

//    public boolean equals(BinaryOperation anOperation) {
//        return left_operand == anOperation.getLeft_operand() &
//                right_operand == anOperation.getRight_operand() &
//                operator == anOperation.getOperator();
//    }
}

//加法子类
class AdditionOperation extends BinaryOperation {
    AdditionOperation() {
        generateBinaryOperation('+');
    }

    //判断算式的结果是否大于0且小于等于100
    @Override
    boolean checkingCalculation(int anInteger) {
        return anInteger <= upper && anInteger >= 0;
    }

    //加法计算
    @Override
    int calculate(int left, int right) {
        return left + right;
    }
}

//减法子类
@SuppressWarnings("all")
class SubstractOperation extends BinaryOperation {
    SubstractOperation() {
        generateBinaryOperation('-');
    }

    //判断算式的结果是否大于0且小于等于100
    @Override
    boolean checkingCalculation(int anInteger) {
        return anInteger <= upper && anInteger >= 0;
    }

    //减法计算
    @Override
    int calculate(int left, int right) {
        return left - right;
    }
}

//测试类
public class BinaryOperation3_2_Test {
    public static void main(String[] args) {
        //构造对象，多态来生成对应的加法或者减法算式
        BinaryOperation binaryOperation;
        //用来计数，每生成5个算式换一行
        int count = 0;
        //创建集合用来记录结果
        ArrayList<Integer> result = new ArrayList<>();

        System.out.println("随机生成的50道算式题如下:");
        //随机生成50道加减法混合的算术题
        for (int i = 0; i < 50; i++) {
            Random random = new Random();
            int opValue = random.nextInt(2);
            if (opValue == 1) {
                binaryOperation = new AdditionOperation();
                //打印从”1.“开始
                //通过多态生成的对象调用对应的方法，获取值
                System.out.printf("%2d.%3d %s %3d= \t\t", (count + 1), binaryOperation.getLeft_operand(), binaryOperation.getOperator(), binaryOperation.getRight_operand());
                result.add(binaryOperation.calculate(binaryOperation.getLeft_operand(), binaryOperation.getRight_operand()));
//                count++;
//                if (count % 5 == 0) {
//                    System.out.println();
//                }
                count = print(count);
            } else {
                binaryOperation = new SubstractOperation();

                //通过多态生成的对象调用对应的方法，获取值

                System.out.printf("%2d.%3d %s %3d= \t\t", (count + 1), binaryOperation.getLeft_operand(), binaryOperation.getOperator(), binaryOperation.getRight_operand());
                //                System.out.print((count + 1) + ". " + binaryOperation.getLeft_operand() + " " + binaryOperation.getOperator() + " " + binaryOperation.getRight_operand() + "=" +
//                        binaryOperation.calculate(binaryOperation.getLeft_operand(), binaryOperation.getRight_operand()) + "\t\t");
                result.add(binaryOperation.calculate(binaryOperation.getLeft_operand(), binaryOperation.getRight_operand()));
//                count++;
//                if (count % 5 == 0) {
//                    System.out.println();
//                }
                count = print(count);
            }
        }

        System.out.println("各题答案如下；");
        count = 0;
        //遍历集合并排版好序号和各式的结果

        for (Integer i : result) {
            count++;
            //打印从”1.“开始
            System.out.print(count + ". " + i + "\t\t");
            if (count % 5 == 0) {
                System.out.println();
            }
        }

    }

    //打印方法，按照对应的格式生成算式
    private static int print(int count) {
        count++;
        if (count % 5 == 0) {
            System.out.println();
        }
        return count;
    }

}



