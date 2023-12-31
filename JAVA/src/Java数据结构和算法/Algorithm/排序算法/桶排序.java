package Java数据结构和算法.Algorithm.排序算法;

import java.util.ArrayList;
import java.util.Collections;

/*桶排序可以看成是计数排序的升级版，它将要排的数据分到多个有序的桶里，
每个桶里的数据再单独排序，再把每个桶的数据依次取出，即可完成排序。
        桶排序：将值为i的元素放入i号桶，最后依次把桶里的元素倒出来。
        桶排序序思路：

        设置一个定量的数组当作空桶子。
        寻访序列，并且把项目一个一个放到对应的桶子去。
        对每个不是空的桶子进行排序。
        从不是空的桶子里把项目再放回原来的序列中。*/
public class 桶排序 {
    public static void sort(int[] arr) {
        //最大最小值
        int max = arr[0];
        int min = arr[0];
        int length = arr.length;

        for (int i = 1; i < length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < min) {
                min = arr[i];
            }
        }

        //最大值和最小值的差
        int diff = max - min;

        //桶列表
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            bucketList.add(new ArrayList<>());
        }

        //每个桶的存数区间
        float section = (float) diff / (float) (length - 1);

        //数据入桶
        for (int i = 0; i < length; i++) {
            //当前数除以区间得出存放桶的位置 减1后得出桶的下标
            int num = (int) (arr[i] / section) - 1;
            if (num < 0) {
                num = 0;
            }
            bucketList.get(num).add(arr[i]);
        }

        //桶内排序
        for (ArrayList<Integer> integers : bucketList) {
            //jdk的排序速度当然信得过
            Collections.sort(integers);
        }

        //写入原数组
        int index = 0;
        for (ArrayList<Integer> arrayList : bucketList) {
            for (int value : arrayList) {
                arr[index] = value;
                index++;
            }
        }
    }
}
