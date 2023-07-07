package JavaEE.集合.Set;

import java.util.HashSet;

//在学生类中重写hashCode() 和equal()方法
//实现添加重复元素的去除
public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<Student> hashSet=new HashSet<>();

        Student s1=new Student("杨晓楠",19);
        Student s2=new Student("只狼",91);
        Student s3=new Student("张自力",19);
        Student s4=new Student("张自力",19);

        hashSet.add(s1);
        hashSet.add(s2);
        hashSet.add(s3);
        hashSet.add(s4);
        for (Student s:hashSet){
            System.out.println(s.getName()+","+s.getAge());
        }
    }
}
