package Java数据结构和算法.DataStructure.树.exercise;

/*                             root(1)
                            2            5
                         3   4         6   7
                              8       9
                           前序遍历://1,2,3,4,8,5,6,9,7
                           中序遍历：//3,2,4,8,1,9,6,5,7
                           后序遍历：//3,8,4,2,9,6,7,5,1
 */
class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Elves root = new Elves(1, "鸢一折纸");
        Elves elves2 = new Elves(2, "本条二亚");
        Elves elves3 = new Elves(3, "时崎狂三");
        Elves elves4 = new Elves(4, "四糸乃");
        Elves elves5 = new Elves(5, "五河琴里");
        Elves elves6 = new Elves(6, "星宫六飱");
        Elves elves7 = new Elves(7, "七罪");
        Elves elves8 = new Elves(8, "八舞");
        Elves elves9 = new Elves(9, "诱宵美九");
//        root.setLeft(elves2);
//        root.setRight(elves3);
        root.left = elves2;
        root.right = elves5;
        elves2.left = elves3;
        elves2.right = elves4;
        elves5.left = elves6;
        elves5.right = elves7;

        elves4.right = elves8;
        elves6.left = elves9;
        //把数独根节点设置
        binaryTree.root = root;
//        binaryTree.setRoot(root);
        //空树遍历
//        new BinaryTree().preOrder();
        System.out.println("前序遍历：");//1,2,3,4,8,5,6,9,7
        binaryTree.preOrder();

        System.out.println("中序遍历：");//3,2,4,8,1,9,6,5,7
        binaryTree.infixOrder();

        System.out.println("后序遍历：");//3,8,4,2,9,6,7,5,1
        binaryTree.postOrder();


        System.out.println("总节点个数:" + binaryTree.size(root));
        System.out.println("叶子节点个数:" + binaryTree.leafSize(root));
        System.out.println("树的深度：" + binaryTree.treeDepth(root));
    }
}

//定义二叉树
class BinaryTree {
    Elves root;

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //计算树的节点个数
    public int size(Elves root) {
        if (root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }

    //求二叉树叶子节点的个数
    //一个节点拥有的子树的数目称为节点的度，度为0的节点称为叶子节点。
    // 把叶子节点找出来之后其他的都是非叶子节点
    public int leafSize(Elves root) {

        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            //此时的root没有子树,root自己就是叶子节点.
            return 1;
        }
        return leafSize(root.left) + leafSize(root.right);
    }

    //求树的深度
    public int treeDepth(Elves root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);
        return leftDepth >= rightDepth ?(leftDepth+1)  : (rightDepth + 1);
    }

}

public class Elves {
    int no;
    String name;
    Elves left;
    Elves right;

    public Elves(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Elves getLeft() {
        return left;
    }

    public void setLeft(Elves left) {
        this.left = left;
    }

    public Elves getRight() {
        return right;
    }

    public void setRight(Elves right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "{no=" + no + ", name=" + name + '}';
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);

        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }


}
