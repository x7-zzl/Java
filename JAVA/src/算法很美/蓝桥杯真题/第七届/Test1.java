package 算法很美.蓝桥杯真题.第七届;
/*
题目描述
小蓝正在学习一门神奇的语言，这门语言中的单词都是由小写英文字母组 成，有些单词很长，远远超过正常英文单词的长度。
小蓝学了很长时间也记不住一些单词，他准备不再完全记忆这些单词，而是根据单词中哪个字母出现得最多来分辨单词。
现在，请你帮助小蓝，给了一个单词后，帮助他找到出现最多的字母和这 个字母出现的次数。
输入描述
输入一行包含一个单词，单词只由小写英文字母组成。

对于所有的评测用例，输入的单词长度不超过 1000。

输出描述
输出两行，第一行包含一个英文字母，表示单词中出现得最多的字母是哪 个。如果有多个字母出现的次数相等，输出字典序最小的那个。

第二行包含一个整数，表示出现得最多的那个字母在单词中出现的次数。
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();// 读取一行字符串
        // 将字符串转化为字符数组
        char[] c = line.toCharArray();
        int[] a = new int[26];
        for (int i = 0; i < line.length(); i++) {
            // 获取某个字符的索引位置
            int n = c[i] - 'a';
            a[n]++;
        }

        // 统计出出现最多字符的次数
        int max = a[0];
        int res = 0;	// 记录出现最多次数的索引
        for (int i = 1; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];	// 记录出现最多的次数
                res = i;	// 记录是哪个字符的索引
            }
        }

        // 统计出是哪一个字符出现最多
        char result = (char) (res + 'a');

        // 输出结果
        System.out.println(result);
        System.out.println(max);
    }

//数组的使用方法
//        int a[]={1,3,34,543,43534,5345,43,3,43,4};
//
//       //排序
//        Arrays.sort(a);
//      for (int i=0;i<a.length;i++)
//      {
//          System.out.print(a[i]+" ");
//      }
//
//      //二分法查找
//     int index= Arrays.binarySearch(a,3);
//        System.out.println("数组下标是"+index);



//        int h=0;
//        for (int i=100;i<=10000;i++)
//        {
//            if(i%2==0)
//            {
//                h=h+i ;
//            }
//        }
//        System.out.println(h);

}
