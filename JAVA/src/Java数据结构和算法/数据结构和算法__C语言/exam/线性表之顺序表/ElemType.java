package Java数据结构和算法.数据结构和算法__C语言.exam.线性表之顺序表;

//数据
public class ElemType {
    private int no;
    private String name;
    private String sex;
    private int age;

    //无参构造方法
    public ElemType() {
    }
    public ElemType(int no, String name, String sex, int age) {
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ElemType{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
