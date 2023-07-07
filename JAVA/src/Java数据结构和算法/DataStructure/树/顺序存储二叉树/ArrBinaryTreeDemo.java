package Java数据结构和算法.DataStructure.树.顺序存储二叉树;
/*              1
           2        3
         4  5      6   7
*/

/*
1).将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆;
2).将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
3).重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，
直到整个序列有序。
*/
public class ArrBinaryTreeDemo {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        //创建一个 ArrBinaryTree
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder(); // 1,2,4,5,3,6,7
        System.out.println();
        arrBinaryTree.infixOrder();//4 2 5 1 6 3 7
        System.out.println();
        arrBinaryTree.postOrder();//4 5 2 6 7 3 1
    }

}

//编写一个ArrayBinaryTree, 实现顺序存储二叉树遍历

class ArrBinaryTree {
    private int[] arr;//存储数据结点的数组

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //重载preOrder
    public void preOrder() {
        this.preOrder(0);
    }

    public void infixOrder() {
        this.infixOrder(0);
    }

    public void postOrder() {
        this.postOrder(0);
    }

    //编写一个方法，完成顺序存储二叉树的前序遍历
    public void preOrder(int index) {
        //如果数组为空，或者 arr.length = 0
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        //输出当前这个元素
        System.out.print(arr[index]+" ");
        //向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            preOrder(2 * index + 1);
        }
        //向右递归遍历
        if ((index * 2 + 2) < arr.length) {
            preOrder(2 * index + 2);
        }
    }

    //编写一个方法，完成顺序存储二叉树的中序遍历
    public void infixOrder(int index) {
        //如果数组为空，或者 arr.length = 0
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的中序遍历");
            return;
        }

        //向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            infixOrder(2 * index + 1);
        }

        //输出当前这个元素
        System.out.print(arr[index]+" ");
        //向右递归遍历
        if ((index * 2 + 2) < arr.length) {
            infixOrder(2 * index + 2);
        }

    }

    //编写一个方法，完成顺序存储二叉树的后序遍历
    public void postOrder(int index) {
        //如果数组为空，或者 arr.length = 0
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的后序遍历");
        }

        //向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            postOrder(2 * index + 1);
        }
        //向右递归遍历
        if ((index * 2 + 2) < arr.length) {
            postOrder(2 * index + 2);
        }
        //输出当前这个元素
        System.out.print(arr[index]+" ");

    }

}