package JavaEE.集合.Set.TreeSet;

import java.util.Comparator;
import java.util.TreeSet;

//使用比较器进行排序
//按年龄由小到大进行排序，年龄相同时，按照姓名的字母顺序
public class TreeSetUse2 {
    public static void main(String[] args) {
        TreeSet<Student> ts = new TreeSet<Student>(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                //按年龄由小到大进行排序，年龄相同时，按照姓名的字母顺序
//                int num=s1.getAge()-s2.getAge();
//                return num==0?s1.getName().compareTo(s2.getName()):num;
                //按姓名进行排序
//                return s1.getName().compareTo(s2.getName());


                //按姓名顺序排列，如果相同按年龄进行排序
                boolean s = s1.getName().equals(s2.getName());
                return s ? s1.getAge() - s2.getAge() : s1.getName().compareTo(s2.getName());
            }
        });

        Student s1 = new Student("ccc", 20);
        Student s2 = new Student("bbb", 29);
        Student s3 = new Student("ddd", 21);
        Student s4 = new Student("aaa", 19);

        Student s5 = new Student("yxn", 21);
        Student s6 = new Student("zzl", 20);
        Student s7 = new Student("zzl", 19);

        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        ts.add(s5);
        ts.add(s6);
        ts.add(s7);
        for (Student s : ts) {
            System.out.println(s.getName() + "," + s.getAge());
        }
        /*class 集合.Collection.Set.TreeSet.Student cannot be cast to
         class java.lang.Comparable (集合.Collection.Set.TreeSet.Student is in unnamed
         module of loader 'app'; java.lang.Comparable is in module java.base of loader 'bootstrap')*/

    }
}
