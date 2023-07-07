package leetcode;
/*
有两个水壶，容量分别为jug1Capacity和 jug2Capacity 升。水的供应是无限的。确定是否有可能使用这两个壶准确得到targetCapacity 升。

        如果可以得到targetCapacity升水，最后请用以上水壶中的一或两个来盛放取得的targetCapacity升水。

        你可以：
        装满任意一个水壶
        清空任意一个水壶
        从一个水壶向另外一个水壶倒水，直到装满或者倒空

       示例 1:

        输入: jug1Capacity = 3, jug2Capacity = 5, targetCapacity = 4
        输出: true
        解释：来自著名的"Die Hard"
        示例 2:

        输入: jug1Capacity = 2, jug2Capacity = 6, targetCapacity = 5
        输出: false
        示例 3:

        输入: jug1Capacity = 1, jug2Capacity = 2, targetCapacity = 3
        输出: true
*/

public class t365_水壶问题 {
    public static void main(String[] args) {
        System.out.println(canMeasureWater(3,5,4));
    }

    //    int jug1Capacity, int jug2Capacity, int targetCapacity
    public static boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (jug1Capacity + jug2Capacity < targetCapacity) {
            return false;
        }
        if (jug1Capacity == 0 || jug2Capacity == 0) {
            return targetCapacity == 0 || jug1Capacity + jug2Capacity == targetCapacity;
        }
        return targetCapacity % gcd(jug1Capacity, jug2Capacity) == 0;

    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
/*
我们认为，每次操作只会让桶里的水总量增加 x，增加 y，减少 x，或者减少 y。

        你可能认为这有问题：如果往一个不满的桶里放水，或者把它排空呢？那变化量不就不是 x 或者 y 了吗？接下来我们来解释这一点：

        首先要清楚，在题目所给的操作下，两个桶不可能同时有水且不满。因为观察所有题目中的操作，操作的结果都至少有一个桶是空的或者满的；

        其次，对一个不满的桶加水是没有意义的。因为如果另一个桶是空的，那么这个操作的结果等价于直接从初始状态给这个桶加满水；而如果另一个桶是满的，那么这个操作的结果等价于从初始状态分别给两个桶加满；

        再次，把一个不满的桶里面的水倒掉是没有意义的。因为如果另一个桶是空的，那么这个操作的结果等价于回到初始状态；而如果另一个桶是满的，那么这个操作的结果等价于从初始状态直接给另一个桶倒满。

        因此，我们可以认为每次操作只会给水的总量带来 x 或者 y 的变化量。因此我们的目标可以改写成：找到一对整数 a, ba,b，使得

        ax+by=z
        ax+by=z

        而只要满足 z\leq x+yz≤x+y，且这样的 a, ba,b 存在，那么我们的目标就是可以达成的。这是因为：

        若 a\geq 0, b\geq 0a≥0,b≥0，那么显然可以达成目标。

        若 a\lt 0a<0，那么可以进行以下操作：

        往 y 壶倒水；

        把 y 壶的水倒入 x 壶；

        如果 y 壶不为空，那么 x 壶肯定是满的，把 x 壶倒空，然后再把 y 壶的水倒入 x 壶。

        重复以上操作直至某一步时 x 壶进行了 aa 次倒空操作，y 壶进行了 bb 次倒水操作。

        若 b\lt 0b<0，方法同上，x 与 y 互换。

        而贝祖定理告诉我们，ax+by=zax+by=z 有解当且仅当 zz 是 x, yx,y 的最大公约数的倍数。因此我们只需要找到 x, yx,y 的最大公约数并判断 zz 是否是它的倍数即可。
*/
