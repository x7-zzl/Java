package 加减法口算习题.Version4;

import java.text.DecimalFormat;
import java.util.*;

//加减乘除法,小数版本
abstract class BinaryOperation {
    //定义变量
    static final double upper = 100;
    private double left_operand = 0, right_operand = 0;
    //运算符号
    private char operator;
    //保留两位小数
    public DecimalFormat df = new DecimalFormat("#.00");

    protected void generateBinaryOperation(char anOperator) {
        double left, right, result;

        Random random = new Random();
        left = Double.parseDouble(df.format(random.nextDouble() * (upper + 1)));
        do {
            right = Double.parseDouble(df.format(random.nextDouble() * (upper + 1)));
            result = calculate(left, right);
        } while (!(checkingCalculation(result)));
        left_operand = left;
        right_operand = right;
        operator = anOperator;

    }


    //抽象方法
    abstract boolean checkingCalculation(double anInteger);

    abstract double calculate(double left, double right);

    //实例变量访问器
    //成员变量访问方法
    public double getLeft_operand() {
        return left_operand;
    }

    //除数为0时重新生成一个随机数直到不为0跳出循环
    public double getRight_operand() {
        while (right_operand == 0) {
            right_operand = Double.parseDouble(df.format(new Random().nextDouble() * (upper + 1)));
        }
        return right_operand;
    }

    //字符串显示方法
    public char getOperator() {
        return operator;
    }

    //算式
    public String toString() {
        return getLeft_operand() + " " + getOperator() + " " + getRight_operand() + "=";
    }
}

//加法子类
class AdditionOperation extends BinaryOperation {
    AdditionOperation() {
        generateBinaryOperation('+');
    }

    //判断算式的结果是否大于0
    @Override
    boolean checkingCalculation(double anInteger) {
        return anInteger >= 0;
    }

    //加法计算
    @Override
    double calculate(double left, double right) {
        return Double.parseDouble((df.format(left + right)));
    }
}

//减法子类
class SubstractOperation extends BinaryOperation {
    SubstractOperation() {
        generateBinaryOperation('-');
    }

    //判断算式的结果是否大于等于0
    @Override
    boolean checkingCalculation(double anInteger) {
        return anInteger >= 0;
    }

    //减法计算
    @Override
    double calculate(double left, double right) {
        return Double.parseDouble((df.format(left - right)));
    }
}


//乘法子类
class MultiplicationOperation extends BinaryOperation {
    MultiplicationOperation() {
        generateBinaryOperation('×');
    }

    //判断算式的结果是否大于0
    @Override
    boolean checkingCalculation(double anInteger) {
        return anInteger >= 0;
    }

    //乘法计算
    @Override
    double calculate(double left, double right) {
        return Double.parseDouble((df.format(left * right)));
    }
}

//除法子类
class DivisionOperation extends BinaryOperation {
    DivisionOperation() {
        generateBinaryOperation('÷');
    }

    //判断算式的结果是否大于等于0
    @Override
    boolean checkingCalculation(double anInteger) {
        return anInteger >= 0;
    }

    //除法计算
    @Override
    double calculate(double left, double right) {
        //保留两位小数
        return Double.parseDouble((df.format(left / right)));
    }
}


class Exercise {
    BinaryOperation binaryOperation;

    //记录题号
    int count = 0;
    //使用map双列集合，记录题号和算术题目
    //记录算术对象
    Map<Integer, BinaryOperation> binaryOperations = new HashMap<>();

    //创建集合用来记录结果
    Map<Integer, Double> result = new HashMap<>();

    //随机生成加减法算式
    public void generateBinaryExercise(int operationCount) {
        while (operationCount > 0) {
            binaryOperation = generateOperation();
            count++;
            binaryOperations.put(count, binaryOperation);
            //存放计算结果
            result.put(count, binaryOperation.calculate(binaryOperation.getLeft_operand(), binaryOperation.getRight_operand()));
            operationCount--;
        }
    }

    //通过生成随机数的方式随机生成加减乘除法的算式
    private BinaryOperation generateOperation() {
        Random random = new Random();
        int opValue = random.nextInt(4);
        if (opValue == 0) {
            return new DivisionOperation();
        } else if (opValue == 1) {
            return new SubstractOperation();
        } else if (opValue == 2) {
            return new MultiplicationOperation();
        } else {
            return new AdditionOperation();
        }
    }


    //生成operationCount个加法算式
    public void generateAdditionExercise(int operationCount) {
        for (int i = 0; i < operationCount; i++) {
            binaryOperation = new AdditionOperation();
            //题号递增
            count++;
            //在集合中存放题号和算式对象
            binaryOperations.put(count, binaryOperation);
            //在结果集合中存放题号和对应的结果
            result.put(count, binaryOperation.calculate(binaryOperation.getLeft_operand(), binaryOperation.getRight_operand()));
        }
    }

    //生成operationCount个减法算式
    public void generateSubstractExercise(int operationCount) {
        for (int i = 0; i < operationCount; i++) {
            binaryOperation = new SubstractOperation();
            count++;
            binaryOperations.put(count, binaryOperation);
            result.put(count, binaryOperation.calculate(binaryOperation.getLeft_operand(), binaryOperation.getRight_operand()));
        }
    }


    //生成operationCount个乘法算式
    public void generateMultiplicationExercise(int operationCount) {
        for (int i = 0; i < operationCount; i++) {
            binaryOperation = new MultiplicationOperation();
            //题号递增
            count++;
            //在集合中存放题号和算式对象
            binaryOperations.put(count, binaryOperation);
            //在结果集合中存放题号和对应的结果
            result.put(count, binaryOperation.calculate(binaryOperation.getLeft_operand(), binaryOperation.getRight_operand()));
        }
    }

    //生成operationCount个除法算式
    public void generateDivisionExercise(int operationCount) {
        for (int i = 0; i < operationCount; i++) {
            binaryOperation = new DivisionOperation();
            count++;
            binaryOperations.put(count, binaryOperation);
            result.put(count, binaryOperation.calculate(binaryOperation.getLeft_operand(), binaryOperation.getRight_operand()));
        }
    }


    //按格式输出，每行打印columns个算式
    public void formattedDisplay(int columns) {
        //临时变量，用来换格式
        int t = 0;
        //对集合对象binaryOperations进行迭代，按格式打印出来
        //每个对象都是一个算式
        for (Map.Entry<Integer, BinaryOperation> entry : binaryOperations.entrySet()) {
            Integer key = entry.getKey();
            BinaryOperation binaryoperation = entry.getValue();
            System.out.print(key + "." + binaryoperation + "\t\t");

            //每到columns个算式换一行
            t++;
            if (t == columns) {
                System.out.println();
                //换行后重置t为0
                t = 0;
            }
        }
    }

    //用户输入结果存放入集合中与结果进行比较
    public void checkResult() {
        //储存答案的集合
        Map<Integer, Double> answers = new HashMap<>();
        int amount = 0;
        System.out.println("请输入各题的答案（结果不是整数的保留小数点后两位）:");
        //用户输入的结果
        Scanner in = new Scanner(System.in);

        //根据算术的题数来让用户输入对应个数的答案
        for (int i = 0; i < result.size(); i++) {
            amount++;
            System.out.print(amount + ".");
            double answer = in.nextDouble();
            //将用户输入的结果存放在集合中
            answers.put(amount, answer);
        }
        System.out.println("本次答题过程中，你一共答错了" + mapCompare(result, answers) + "题");
    }

    //对用户输入的答案和算式正确的结果进行比较
    private static int mapCompare(Map<Integer, Double> hashMap, Map<Integer, Double> hashMap1) {

        //记录错题个数
        int count = 0;
   /*   Entry将键值对的对应关系封装成了对象，即键值对对象，这样我们在遍历Map集合时，
        就可以从每一个键值对 对象中获取对应的键与对应的值。
        Entry是Map接口中提供的一个静态内部嵌套接口，修饰为静态可以通过类名调用。*/
        for (Map.Entry<Integer, Double> entry1 : hashMap.entrySet()) {
            Double m1value = entry1.getValue();
            Double m2value = hashMap1.get(entry1.getKey());

            //用户结果与实际结果差距在0.1之内都可以认为是正确的
            if (!(Math.abs(m1value - m2value) <= 0.1)) {//!m1value.equals(m2value)
                System.out.println("第" + entry1.getKey() + "题错误，小朋友再仔细看看吧!");
                count++;
            } else {
                System.out.println("恭喜你，第" + entry1.getKey() + "题正确");
            }
        }
        return count;
    }

    //输出结果的格式,每行resultColumns个结果

    public void printResult(int resultColumns) {
        Iterator<Map.Entry<Integer, Double>> iterator = result.entrySet().iterator();

        int t = 0;
        while (iterator.hasNext()) {
            Map.Entry<Integer, Double> entry = iterator.next();

            Integer key = entry.getKey();
            Double resultSet = entry.getValue();
            t++;
            System.out.print(key + "." + resultSet + "\t\t");

            if (t % resultColumns == 0) {
                System.out.println();
                t = 0;
            }
        }
    }

    public static void main(String[] args) {
        Exercise exercise = new Exercise();

    /*    //生成operationCount个加法算式
        exercise.generateAdditionExercise(20);
        //生成operationCount个减法算式
        exercise.generateSubstractExercise(30);

        //生成operationCount个乘法算式
        exercise.generateMultiplicationExercise(30);
        //生成operationCount个除法算式
        exercise.generateDivisionExercise(20);
        */

        //随机生成算式
        exercise.generateBinaryExercise(10);

        //每行打印columns个算式
        exercise.formattedDisplay(6);

        System.out.println();
        exercise.checkResult();

        System.out.println("各题结果如下:");
        exercise.printResult(7);
    }
}


