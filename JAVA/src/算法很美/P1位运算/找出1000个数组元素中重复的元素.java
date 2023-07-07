package 算法很美.P1位运算;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

//亦或运算符:Parent^0=Parent,Parent^Parent=0
//找出1000个数组元素中重复的那个元素，这个数组储存1-1000的所有整数，有且只有一个数重复
@SuppressWarnings("ALL")
public class 找出1000个数组元素中重复的元素 {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int n = 19000;
        //加入元素1-999
        for (int i = 1; i < n; i++) {
            arrayList.add(i);
        }

        //随机产生重复的元素
        arrayList.add(new Random().nextInt(n - 1) + 1);
        //打乱顺序
        Collections.shuffle(arrayList);

        int flag = 0;
        for (int i = 1; i <= n - 1; i++) {
            flag = flag ^ (i);
        }

        for (Integer i : arrayList) {
            flag = flag ^ i;
        }
        System.out.println("所有元素为:" + arrayList);
        System.out.println("重复元素是:" + flag);

        System.out.println("---------------------------------");
        System.out.println("开辟辅助空间，暴力解法");

        for (Integer i : arrayList) {
            int count = 0;
            //标记，出现一次结束循环
            boolean b = false;
            for (Integer i1 : arrayList) {
                if (i.equals(i1)) {
                    count++;
                    if (count == 2) {
                        System.out.println(i + "         " + i1);
                        b = true;
                        break;
                    }
                }
            }
            if (b) {
                break;
            }
        }
    }
}
