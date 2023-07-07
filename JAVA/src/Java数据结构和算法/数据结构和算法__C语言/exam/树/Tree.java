package Java数据结构和算法.数据结构和算法__C语言.exam.树;

class TreeDemo {

}

public class Tree {
    TreeNode root;
    public static void main(String[] args) {
        Tree tree = new Tree();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);


        t1.left = t2;
        t1.right = t5;
        t2.left = t3;
        t2.right = t4;
        t5.left = t6;
        t5.right = t7;

        t4.right = t8;
        t6.left = t9;
        //把数独根节点设置
        tree.root = t1;
//        binaryTree.setRoot(root);
        //空树遍历
//        new BinaryTree().preOrder();
        System.out.println("前序遍历：");//1,2,3,4,8,5,6,9,7
        tree.preOrder();

        System.out.println("中序遍历：");//3,2,4,8,1,9,6,5,7
        tree.infixOrder();

        System.out.println("后序遍历：");//3,8,4,2,9,6,7,5,1
        tree.postOrder();


        System.out.println("总节点个数:" + tree.cNode(t1));
        System.out.println("叶子节点个数:" + tree.leaves(t1));
        System.out.println("树的深度：" + tree.depth(t1));
    }
    public void preOrder() {
        if (this.root != null) {
            this.root.pre();
        } else {
            System.out.println("树为空");
        }
    }

    public void infixOrder() {
        if (this.root != null) {
            this.root.infix();
        } else {
            System.out.println("树为空");
        }
    }

    public void postOrder() {
        if (this.root != null) {
            this.root.post();
        } else {
            System.out.println("树为空");
        }
    }

    //统计节点个数
    public int cNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + cNode(root.left) + cNode(root.right);
    }


    //统计叶子节点的个数
    public int leaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.right != null) {
            return 1;
        }

        return leaves(root.left) + leaves(root.right);
    }

    //统计树的高度（深度）
    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftLength = depth(root.left);
        int rightLength = depth(root.right);

        return leftLength >= rightLength ? (leftLength + 1) : (rightLength + 1);
    }
}


class TreeNode {
    private int node;

    TreeNode left, right;

    public TreeNode(int node) {
        this.node = node;
    }

    public int getNode() {
        return node;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }


    public void setNode(int node) {
        this.node = node;
    }

    public void pre() {
        System.out.println(this);
        if (this.left != null) {
            this.left.pre();
        }
        if (this.right != null) {
            this.right.pre();
        }
    }

    public void infix() {
        if (this.left != null) {
            this.left.infix();
        }
        System.out.println(this);

        if (this.right != null) {
            this.right.infix();
        }
    }

    public void post() {
        if (this.left != null) {
            this.left.post();
        }
        if (this.right != null) {
            this.right.post();
        }
        System.out.println(this);

    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "node=" + node +
                '}';
    }
}