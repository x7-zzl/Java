package 类和对象.zzl21;

public class DateTest {
    public static void main(String[] args) {
        Date oday1=new Date();
        Date oday2=new Date(2021,4,8);
        Date oday3=new Date(oday1);
       System.out.println(oday3 instanceof Date);;
        oday1.print();
        oday2.print();
        oday3.print();
    }
}
