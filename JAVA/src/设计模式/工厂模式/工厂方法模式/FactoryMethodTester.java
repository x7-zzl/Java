package 设计模式.工厂模式.工厂方法模式;
//工厂模式简介 ：工厂模式用于对象的创建，使得客户从具体的产品对象中被解耦。
/*
简单工厂模式的主要角色如下：
        简单工厂（SimpleFactory）：是简单工厂模式的核心，负责实现创建所有实例的内部逻辑。工厂类的创建产品类的方法可以被外界直接调用，创建所需的产品对象。
        抽象产品（Product）：是简单工厂创建的所有对象的父类，负责描述所有实例共有的公共接口。
        具体产品（ConcreteProduct）：是简单工厂模式的创建目标。
工厂方法模式结构：工厂(核心)：它负责实现创建所有实例的内部逻辑，抽象产品，具体产品
*/


//抽象的产品
interface Shape{
    public void draw();
}
//具体产品
class Line implements Shape{
    @Override
    public void draw() {
        System.out.println("draw a line.");
    }
}
class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("draw a square.");
    }
}
class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("draw a circle.");
    }
}
//创建一个工厂方法，根据创建的类，选择不同的draw
class DrawFactory{
    public Shape pen(String type){
        if("Line".equals(type)){
            return new Line();
        }else if("Square".equals(type)){
            return new Square();
        }else if("Circle".equals(type)){
            return new Circle();
        }else {
            System.out.println("请输入正确的类型");
            return null;
        }
    }
}
//测试工厂方法
public class FactoryMethodTester {
    public static void main(String[] args) {
        DrawFactory factory=new DrawFactory();
        Shape shape=factory.pen("Square");
        shape.draw();
    }
}
