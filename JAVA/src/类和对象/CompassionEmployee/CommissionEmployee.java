package 类和对象.CompassionEmployee;

public class CommissionEmployee {
    private  String name; //员工姓名
    private  String ID;//员工工号
    private double grossSales;//销售额
    private  double commissionRate; //提成率
    public CommissionEmployee(String name,String ID,double sales,double Rate)
    {
        this.name=name;
        this.ID=ID;
        setGrossSales(sales);
        setCommissionRate(Rate);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public void setGrossSales(double sales) {
     grossSales = (sales<0.0)?0.0:sales;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double rate) {
    commissionRate = (rate>0.0&&rate<1.0)?rate:0;
    }
    public double earnings()
    {
        return commissionRate*grossSales;
    }
    public String toString()
    {
        return  String.format("%s:%s\n%s:%s\n%s:%.2f\n%s:%.2f","员工姓名",name,"员工工号",ID,"销售额",grossSales,"提出率",commissionRate);
    }
}

class CommissionEmployeeTest {
    public static void main(String[] args) {
        CommissionEmployee e=new CommissionEmployee("张自力","000001",1000000,.06);
        System.out.println("员工的基本情况如下:");
        System.out.printf("%s:%s\n","员工姓名 ",e.getName());
        System.out.printf("%s :%s\n","员工工号",e.getID());
        System.out.printf("%s :%.2f\n","销售额",e.getGrossSales());
        System.out.printf("%s :%.2f\n","提成率",e.getCommissionRate());
        System.out.printf("%s :%.2f\n","员工工资",e.earnings());
        e.setGrossSales(5000000);
        e.setCommissionRate(0.1);
        System.out.printf("\n%s:\n\n%s\n","更新后的员工信息",e);
        System.out.printf("%s %.2f\n","员工工资",e.earnings());

    }
}