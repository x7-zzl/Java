package JavaEE.泛型.可变参数;

//如果一个方法有多个参数，包含可变参数，可变参数放在其他参数的后面
public class Variable {


    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();

        System.out.println(sum("和",1));
        System.out.println(sum("和",1, 2));
        System.out.println(sum("和",1, 2, 3));
        System.out.println(sum("和",1, 2, 3, 4));
        System.out.println(sum("和",1, 2, 3, 4, 6));
        System.out.println(sum("和",1, 2, 3, 4, 7, 8, 8, 8, 878, 7, 87, 8));
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
    }
    //内部实际是一个数组
    public static String sum(String name,int... a) {
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        return name+","+sum;
    }
}
