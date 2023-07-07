package 加减法口算习题.Version3;
/*具有加减法功能的答题系统。基本需求：命令行界面、答题功能、批改功能。*/
import java.util.*;

abstract class BinaryOperation {
    //定义变量
    static final int upper = 100;
    private int left_operand = 0, right_operand = 0;
    //运算符号
    private char operator = '+';

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

    public boolean equals(BinaryOperation anOperation) {
        return left_operand == anOperation.getLeft_operand() &
                right_operand == anOperation.getRight_operand() &
                operator == anOperation.getOperator();
    }


    public String toString() {
        return getLeft_operand() + " " + getOperator() + " " + getRight_operand() + "=";
    }
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
class SubstractOperation extends BinaryOperation {
    SubstractOperation() {
        generateBinaryOperation('-');
    }

    //判断算式的结果是否大于等于0且小于等于100
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

class Exercise {
    BinaryOperation binaryOperation;

    //记录题号
    int count = 0;
    //使用map双列集合，记录题号和算术题目
    //记录算术对象
    Map<Integer, BinaryOperation> binaryOperations = new HashMap<>();

    //创建集合用来记录结果
    Map<Integer, Integer> result = new HashMap<>();

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

    //通过生成随机数的方式随机生成加减法的算式
    private BinaryOperation generateOperation() {
        Random random = new Random();
        int opValue = random.nextInt(2);
        if (opValue == 1) {
            return new AdditionOperation();
        }
        return new SubstractOperation();
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
        Map<Integer, Integer> answers = new HashMap<>();
        int amount = 0;
        System.out.println("请输入各题的答案；");
        //用户输入的结果
        Scanner in = new Scanner(System.in);

        //根据算术的题数来让用户输入对应个数的答案
        for (int i = 0; i < result.size(); i++) {
            amount++;
            System.out.print(amount + ".");
            int answer = in.nextInt();
            //将用户输入的结果存放在集合中
            answers.put(amount, answer);
        }
        System.out.println("本次答题过程中，你一共答错了" + mapCompare(result, answers) + "题");
    }

    //对用户输入的答案和算式正确的结果进行比较
    private static int mapCompare(Map<Integer, Integer> hashMap, Map<Integer, Integer> hashMap1) {

        //记录错题个数
        int count = 0;
   /*   Entry将键值对的对应关系封装成了对象，即键值对对象，这样我们在遍历Map集合时，
        就可以从每一个键值对（Entry）对象中获取对应的键与对应的值。
        Entry是Map接口中提供的一个静态内部嵌套接口，修饰为静态可以通过类名调用。*/
        for (Map.Entry<Integer, Integer> entry1 : hashMap.entrySet()) {
            Integer m1value = entry1.getValue();
            Integer m2value = hashMap1.get(entry1.getKey());
            if (!m1value.equals(m2value)) {
                System.out.println("第" + entry1.getKey() + "题错误，小朋友再仔细看看吧!");
                count++;
            }
        }
        return count;
    }

    //输出结果的格式,每行resultColumns个结果
    public void printResult(int resultColumns) {
        Iterator<Map.Entry<Integer, Integer>> iterator = result.entrySet().iterator();

        int t = 0;
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();

            Integer key = entry.getKey();
            Integer resultSet = entry.getValue();
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



      //生成加法operationCount给加法算式
//        exercise.generateAdditionExercise(60);
      //生成加法operationCount给加法算式
//        exercise.generateSubstractExercise(40);

        exercise.generateBinaryExercise(20);
        //每行打印columns个算式
        exercise.formattedDisplay(6);

        System.out.println();
        exercise.checkResult();

        System.out.println("各题结果如下:");
        exercise.printResult(7);
    }
}
