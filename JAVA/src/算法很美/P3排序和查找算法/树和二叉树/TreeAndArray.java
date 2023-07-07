package 算法很美.P3排序和查找算法.树和二叉树;

//通过子节点找父节点，(i-1)/2
//通过父节点找子节点，2i+1,2i+2...;
//从左往右遍历
/* 树的例图
                                 78
                       ///                \\\
                       56                  34
                    /     \              /   \
                   43      4            1     15
                  /  \
                2   23
*/
public class TreeAndArray {
    public static void main(String[] args) {
        int[] arr = new int[]{78, 56, 34, 43, 4, 1, 15, 2, 23};
        System.out.print("先序输出:");
        preOrder(arr, 0);
        System.out.println();
        System.out.print("中序输出:");
        midOrder(arr, 0);
        System.out.println();
        System.out.print("后序输出:");
        endOrder(arr, arr.length - 2);
    }


    /*树的先序输出
    递归输出，从左往右
    78,56,43,2,23,4,34,1,15
   */

    private static void preOrder(int[] arr, int i) {
        if (i >= arr.length) {
            return;
        }

        //输出根节点
        System.out.print(arr[i] + ",");
        //遍历左子树
        preOrder(arr, 2 * i + 1);
        //遍历右子树
        preOrder(arr, 2 * i + 2);
    }

    /*树的中序输出
     2，43，23，56，4，78，1，34，15
    */
    private static void midOrder(int[] arr, int i) {
        if (i >= arr.length) {
            return;
        }
        //递归输出左子树
        midOrder(arr, 2 * i + 1);
        //输出根节点
        System.out.print(arr[i] + ",");
        //递归输出右子树
        midOrder(arr, 2 * i + 2);

    }


    /*树的后序输出
      2，23，43，4，56，1，15，34，78
    */


    private static void endOrder(int[] arr, int i) {

        if (i >= arr.length) {

            return;
        }
        if (2 * i + 1 <= arr.length) {
            endOrder(arr, 2 * i + 1);
        }
        if (2 * i + 2 <= arr.length) {
            endOrder(arr, 2 * i + 2);
        }
        System.out.print(arr[i] + ",");
    }
}
