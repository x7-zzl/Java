package 类和对象.zzl21;

public class Date {
    private int year;
    private int month;
    private int day;
    public Date(int year,int month,int day) //指定参数的构造方法声明
    {
        /*当成员方法的参数和成员变量相同时，在方法体中需要使用this引用成员变量，this不能省略；
        当无同名成员变量时，this可以省略
         */
        this.year=year;
        this.month=month;
        this.day=day;
    }
    public Date()
    {
        this(2021,4,7);
    }
    public Date(Date oday)//构造方法重载
    {
     this(oday.year,oday.month, oday.day);
    }

    public int getYear() {//获取成员变量的值
        return year;
    }

    public void setYear(int year) {//成员变量赋值
        this.year = year;
    }

    public int getMonth() {
        return this.month=((month>=1)&(month<=12))?month:1;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return this.day=((day>=1)&(day<=31))?day:1;
    }

    public void setDay(int day) {
        this.day = day;
    }
    public String toString()//返回年月日的格式
    {
        return this.year+"-"+this.month+"-"+this.day;
    }
    public  void print()
    {
        System.out.println("data is "+this.toString());
    }
}
