package JavaEE.集合.Set.TreeSet;

import java.util.Comparator;
import java.util.TreeSet;

public class CompareGoal {
    public static void main(String[] args) {
        TreeSet<Goal> ts=new TreeSet<>(new Comparator<Goal>() {
            @Override
            public int compare(Goal s1, Goal s2) {
                int num=s2.getSum()-s1.getSum();
                int num2=num==0?s1.getChinese()-s2.getChinese():num;
                int num3=num2==0?s1.getName().compareTo(s2.getName()):num2;
                return num3;
            }
        });


        Goal g1=new Goal("芭芭拉",100,100);
        Goal g2=new Goal("砂糖",90,99);
        Goal g3=new Goal("琴",80,88);
        Goal g4=new Goal("迪卢克",70,80);
        Goal g5=new Goal("甘雨",88,99);
        Goal g6=new Goal("胡桃",88,98);
        Goal g7=new Goal("刻晴",88,80);

        ts.add(g1);
        ts.add(g2);
        ts.add(g3);
        ts.add(g4);
        ts.add(g5);
        ts.add(g6);
        ts.add(g7);

        for (Goal goal:ts){
            System.out.println(goal.getName()+","+goal.getChinese()+","+goal.getMath()+",总分:"+goal.getSum());
        }
    }
}
