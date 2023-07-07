package JavaEE.集合.List.Arraylist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Arraylist_student {
    public static void main(String[] args) {

        Collection<Student> array =new ArrayList<Student>();
        Student s1=new Student("关羽",32);
        Student s2=new Student("张飞",33);
        Student s3=new Student("刘备",31);

        array.add(s1);
        array.add(s2);
        array.add(s3);

        //迭代器
        Iterator<Student> iterator = array.iterator();
        //判断集合对象中是否有元素
        while (iterator.hasNext()){
            Student s= iterator.next();
            System.out.println(s.getName()+","+s.getAge());
        }
    }
}
