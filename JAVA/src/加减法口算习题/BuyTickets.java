package 加减法口算习题;

public class BuyTickets {

    double price=100;//初始票价
    Strategy strategy;
    public BuyTickets(Strategy strategy){
        this.strategy=strategy;
    }

    public double result(){
        return strategy.finalPrice(price);
    }

    public static void main(String[] args) {

        BuyTickets buyTickets1 = new BuyTickets(new Student());
        BuyTickets buyTickets2= new BuyTickets(new Kid());
        BuyTickets buyTickets3 = new BuyTickets(new VIP());
        BuyTickets buyTickets4 = new BuyTickets(new Soldier());
        BuyTickets buyTickets5 = new BuyTickets(new Old());

        System.out.printf("票价:%.2f\n",buyTickets1.result());
        System.out.printf("票价:%.2f\n",buyTickets2.result());
        System.out.printf("票价:%.2f\n",buyTickets3.result());
        System.out.printf("票价:%.2f\n",buyTickets4.result());
        System.out.printf("票价:%.2f\n",buyTickets5.result());
    }

}
interface Strategy{//为策略对象定义一个接口
    public double finalPrice(double price);
}
//(1)学生凭学生证可享受票价8折优惠
class Student implements Strategy{
    @Override
    public double finalPrice(double price) {
        return  0.8*price;
    }
}

//(2)年龄在10周岁及以下的儿童可享受每张票减免10元的优惠(原始票价需大于等于30元)。
class Kid implements Strategy{
    @Override
    public double finalPrice(double price) {
        if(price>=30) price = price - 10;
        return  price;
    }
}

//(3)影院VIP用户除享受票价半价优惠外还可进行积分，积分累计到一定额度可换取电影院赠送的奖品
class VIP implements Strategy{
    int score=0;//每进行一次购票，用户的积分增加值为用户消费金额
    @Override
    public double finalPrice(double price) {
        score+=price;
        return  0.5*price;
    }
    public int getScore(){
        return score;
    }
}
//(4)军人免费
class Soldier implements Strategy{

    @Override
    public double finalPrice(double price) {
        return 0;
    }
}

//(5) 60岁以上老人半价-
class Old implements Strategy{
    @Override
    public double finalPrice(double price) {
        return  0.5*price;
    }
}