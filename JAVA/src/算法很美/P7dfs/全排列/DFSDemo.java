package 算法很美.P7dfs.全排列;
//简单全排列
public class DFSDemo {
    int[] num = new int[3];

    public void dfsExample(int index) {
        // 边界条件
        if (index == 3) {

            for (int i = 0; i < 3; i++) {
                System.out.print(num[i] + " ");
            }

            System.out.println();

            //走不下去了就 return了
            return;
        }

        for (int i = 1; i <= 3; i++) {
            num[index] = i;
            // index+1 枚举下一种情况
            dfsExample(index + 1);
        }

    }

    public static void main(String[] args) {
        DFSDemo dfsdemo = new DFSDemo();
        dfsdemo.dfsExample(0);
    }
}
