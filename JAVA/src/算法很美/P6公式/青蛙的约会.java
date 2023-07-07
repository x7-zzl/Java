package 算法很美.P6公式;
@SuppressWarnings("ALL")
/*
题目描述
        两只青蛙在网上相识了，它们聊得很开心，于是觉得很有必要见一面。
        它们很高兴地发现它们住在同一条纬度线上，于是它们约定各自朝西跳，直到碰面为止。
        可是它们出发之前忘记了一件很重要的事情，既没有问清楚对方的特征，也没有约定见面的具体位置。
        不过青蛙们都是很乐观的，它们觉得只要一直朝着某个方向跳下去，总能碰到对方的。
        但是除非这两只青蛙在同一时间跳到同一点上，不然是永远都不可能碰面的。
        为了帮助这两只乐观的青蛙，你被要求写一个程序来判断这两只青蛙是否能够碰面，会在什么时候碰面。

        我们把这两只青蛙分别叫做青蛙A和青蛙B，并且规定纬度线上东经0度处为原点，由东往西为正方向，
        单位长度1米，这样我们就得到了一条首尾相接的数轴。设青蛙A的出发点坐标是x，青蛙B的出发点坐标是y。
        青蛙A一次能跳m米，青蛙B一次能跳n米，两只青蛙跳一次所花费的时间相同。纬度线总长L米。现在要你求出它们跳了几次以后才会碰面。

        输入输出格式
        输入格式：


        输入只包括一行5个整数x，y，m，n，L

        其中0<x≠y < =2000000000，0 < m、n < =2000000000，0 < L < =2100000000。

        输出格式：

        输出碰面所需要的天数，如果永远不可能碰面则输出一行"Impossible"。

        输入输出样例
        输入样例#1：
        1 2 3 4 5
        输出样例#1：
        4

        分析：
        假设跳了T 次以后，青蛙 1 的坐标便是x+m*T,青蛙2 的坐标为y+n*T 。
        它们能够相遇的情况为（x+m*T)-(y+n*T)==P*L，其中P为某一个整数，变
        形一下得到(n-m)*T-P*L==x-y我们设 a=(n-m),b=L,c=x-y,T=x,P=y.于是便得到 ax+by==c，
        直接利用欧几里得扩展定理可以得到一组 x,y 但是这组 x,y不一定是符合条件的最优解，
        首先,当gcd(a,b)不能整除c 的时候是无解的，当c 能整除gcd(a,b)时，把x 和y 都要变为原来的c/gcd(a,b)倍,
        我们知道它的通解为 x0+b/gcd(a,b)*t要保证这个解是不小于零的最小的数，
        我们先计算当x0+b/gcd(a,b)*t=0时的t值，此时的t记为t0=-x0/b/gcd(a,b)（整数除法），
        代入t0如果得到的x小于零再加上一个b/gcd(a,b)就可以了。
*/
public class 青蛙的约会 {
    public static void main(String[] args) {
        int x = 11, y = 21, m = 31, n = 41, l = 44;
        int ar = n - m, br = 0, cr = x - y;
        int M = exGcd(n - m, l, ar, br);

        System.out.println("M:" + M);

        if ((x - y) % M != 0 || m == n)
            System.out.println("Impossible");
        else {
            int s = l / M;
            ar = ar * ((x - y) / M);
            ar = (ar % s + s) % s;
            System.out.println("ar : " + ar);
        }
    }

    private static int Gcd(int a, int b) {
        while (b != 0) {
            int r = b;
            b = a % b;
            a = r;
        }
        return a;
    }

    private static int exGcd(int a, int b, int x, int y) {
        if (b == 0) {
            x = 1;
            y = 0;
            return a;
        }
        int r = exGcd(b, a % b, x, y);
        int t = x;
        x = y;
        y = t - a / b * y;
        return r;
    }

}