package JavaEE.集合.Set.TreeSet;

public class Goal {
    private String name;
    private int chinese;
    private int math;

    public Goal(String name,int chinese,int math) {
        this.name=name;
        this.chinese=chinese;
        this.math=math;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChinese() {
        return chinese;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getSum(){
        return this.chinese+this.math;
    }
}
