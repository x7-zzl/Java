package 设计模式.适配器模式;
/*适配器模式的结构:
        适配器模式（Adapter）包含以下主要角色。
        目标（Target）接口：当前系统业务所期待的接口，它可以是抽象类或接口。
        适配者（Adaptee）类：它是被访问和适配的现存组件库中的组件接口。
        适配器（Adapter）类：它是一个转换器，通过继承或引用适配者的对象，把适配者接口转换成目标接口，让客户按目标接口的格式访问适配者。*/

//目前已有的类
interface Printer {
    public void print();
}

class Printer_L implements Printer {

    @Override
    public void print() {
        System.out.println("Type L Printer is printing");
    }
}

public class AdapterTester {
    public static void main(String[] args) {
        Printer_L pl = new Printer_L();
        pl.print();

        //新增的打印测试
        Printer ph = new AdapterH();
        ph.print();

    }
}

//现在引入一个类，它的打印方法是display(),通过复用display()提供print()方法
class Printer_H {
    public void display() {
        System.out.println("Type H Printer is printing");
    }
}

class AdapterH extends Printer_H implements Printer {
    @Override
    public void print() {
        display();
    }
}