package JavaEE.集合;


import java.util.*;

/*
需求:
通过程序实现斗地主过程中的洗牌，发牌和看牌。要求:对牌进行排序
思路:
i:创建HashMap，键是编号，值是牌2:创建ArrayList，存储编号
3:创建花色数组和点数数组
4:从o开始往HashMap里面存储编号，并存储对应的牌。同时往ArrayList里面存储编号5 :洗牌(洗的是编号)，用Collections的shuffle()方法实现
6:发牌(发的也是编号，为了保证编号是排序的，创建TreeSet集合接收)
7:定义方法看牌(遍历TreeSet集合，获取编号，到HashMap集合找对应的牌)8:调用看牌方法
 */
public class MoNiDouDiZhu {
    public static void main(String[] args) {
        HashMap<Integer, String> hm = new HashMap<>();

        ArrayList<Integer> arrayList = new ArrayList<>();

//        String[] colors = {"红桃", "黑桃", "方片", "梅花"};

        String[] colors = {"♠", "♥", "♦", "♣"};

        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "Parent", "2"};

        int index = 0;
        for (String num : numbers) {
            for (String color : colors) {
                hm.put(index, color + num);
                arrayList.add(index);
                index++;
            }
        }

        hm.put(index, "小王");
        arrayList.add(index);
        index++;
        hm.put(index, "大王");
        arrayList.add(index);

        Collections.shuffle(arrayList);

        TreeSet<Integer> HuTaoSet = new TreeSet<>();
        TreeSet<Integer> XiaoSet = new TreeSet<>();
        TreeSet<Integer> GanYuSet = new TreeSet<>();
        TreeSet<Integer> DiPaiSet = new TreeSet<>();

        for (int i = 0; i < arrayList.size(); i++) {
            int x = arrayList.get(i);
            if (i >= arrayList.size() - 3) {
                DiPaiSet.add(x);
            } else if (i % 3 == 0) {
                HuTaoSet.add(x);
            } else if (i % 3 == 1) {
                XiaoSet.add(x);
            } else {
                GanYuSet.add(x);
            }
        }
        lookPoker("胡桃", HuTaoSet, hm);
        lookPoker("魈", XiaoSet, hm);
        lookPoker("甘雨", GanYuSet, hm);
        lookPoker("底牌", DiPaiSet, hm);
    }


    public static void lookPoker(String name, TreeSet<Integer> ts, HashMap<Integer, String> hm) {
        System.out.println(name + "的牌是:");
        int count = 0;
        for (Integer key : ts) {

            String poker = hm.get(key);
            System.out.print(poker + " ");
            count++;
            if (count == 6) {
                System.out.println();
                count = 0;
            }
        }
        System.out.println();
        System.gc();
    }


}
