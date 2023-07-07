package 类和对象.zzl20;

public class StaticTest {
    public static  String toChar (double x)
    {
        return Double.toString(x);

    }
    public  static void main(String args[]){
        System.out.println(Math.round(6.1));
        String s=toChar(12.6);
        System.out.println("e="+s);
    }
}
