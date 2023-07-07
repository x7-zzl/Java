package JavaEE.泛型.泛型实例;

import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

public class Point<T> {
    private T x;
    private T y;
    public T getX() {
        return x;
    }
    public void setX(T x) {
        this.x = x;
    }
    public T getY() {
        return y;
    }
    public void setY(T y) {
        this.y = y;
    }

    public static void main(String[] args) {
            // 构建泛型类的对象 Integer型
            Point<Integer> p = new Point<Integer>();
            p.setX(88);
            Integer x = p.getX();
            System.out.println(x);
            // 构建泛型类的对象 Float型
            Point<Float> p1 = new Point<Float>();
            p1.setX(80F);
            Float x1 = p1.getX();
            System.out.println(x1);
            // 构建泛型类的对象 Student型
            Point<Student>  p3 = new Point<Student>();
            p3.setX(new Student(40,"xiao"));
            System.out.println(p3.getX());

    }
}
