package JavaEE.集合.Set;

//在对象类中通过方法重写可以使Object类中返回相同的Hash值
public class HashCodeDemo {
    public static void main(String[] args) {
        Student s1=new Student("杨晓楠",19);
        System.out.println(s1.hashCode());//968514068
        System.out.println(s1.hashCode());//968514068

        //默认情况下，不同的对象的Hash值不同
        Student s2=new Student("只狼",91);
        System.out.println(s2.hashCode());//1360767589

        System.out.println("杨晓楠".hashCode());//99162322
        System.out.println("张慧:"+"张慧".hashCode());// 779847
        System.out.println("zzl".hashCode());// 121132
        System.out.println("张自力:"+"张自力".hashCode());//24454417

        System.out.println("重地".hashCode());//1179395
        System.out.println("通话".hashCode());// 1179395

      /*  “Aa”和“BB”，“Ba”和“CB”，“Ca”和“DB”*/
        System.out.println("Aa".hashCode());
        System.out.println("BB".hashCode());
    }
}
