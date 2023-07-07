package JavaEE.集合.List.Arraylist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorUse1 {
    public static void main(String[] args) {
        Collection<Student> c=new ArrayList<>();
        Student s1=new Student("杨晓楠",1);
        Student s2=new Student("张梦辉",2);
        Student s3=new Student("赵鹏磊",3);
        c.add(s1);
        c.add(s2);
        c.add(s3);

        Iterator<Student> it = c.iterator();
        while (it.hasNext()){
           Student s=it.next();
            System.out.println(s.getName()+","+s.getAge());
        }
    }
}
