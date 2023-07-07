package JavaEE.集合.Set.TreeSet;

import java.util.Objects;

public class Student{
    private String name;
    private int age;

    public Student() {

    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    //    public int compareTo(Student student) {
//        //        return -1;//降序
////        return  1;//升序
//        int num = this.age - student.age;
//        return num;
//    }


//    @Override
//    public int compareTo(Object o) {
//        return 1;
//    }
}

