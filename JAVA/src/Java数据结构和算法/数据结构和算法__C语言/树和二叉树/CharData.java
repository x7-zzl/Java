package Java数据结构和算法.数据结构和算法__C语言.树和二叉树;

import java.util.Scanner;
/*1.	建立一棵节元素类型为char类型的二叉树。
        要求实现计算二叉树的叶子节点个数、计算总结点个数、计算二叉树的高度等算法；
        实现先序、中序、后续遍历，打印出遍历顺序。
        在主函数中设计一个简单的菜单，分别调试上述算法。*/
public class CharData {
    char c;
    CharData left, right;

    public CharData(char c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "[" + c + ']';
    }

    //前序遍历
    public void preOrder() {
        System.out.print(this);
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
        System.out.print(this);
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
        System.out.print(this);
    }
}

class BinaryTree {
    CharData root;

    public void setRoot(CharData root) {
        this.root = root;
    }

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

    //计算二叉树的叶子节点个数
    public int leafSiZe(CharData root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return leafSiZe(root.left) + leafSiZe(root.right);
    }

    //计算总结点个数
    public int size(CharData root) {
        if (root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }

    //计算二叉树的高度
    public int height(CharData root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return leftHeight >= rightHeight ? (leftHeight + 1) : (rightHeight + 1);
    }
}
class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        CharData root = new CharData('a');
        CharData c2 = new CharData('b');
        CharData c3 = new CharData('c');
        CharData c4 = new CharData('d');
        CharData c5 = new CharData('e');
        CharData c6 = new CharData('f');
        CharData c7 = new CharData('g');

        root.left = c2;
        root.right = c5;
        c2.left = c3;
        c2.right = c4;
        c5.left = c6;
        c5.right = c7;

        binaryTree.setRoot(root);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("<------主菜单------>");
            System.out.println("1.先序遍历");
            System.out.println("2.中序遍历");
            System.out.println("3.后序遍历");
            System.out.println("4.计算叶子节点个数");
            System.out.println("5.计算总节点个数");
            System.out.println("6.计算二叉树的高度");
            System.out.println("7.退出系统");
            System.out.println("<---------------->");
            System.out.print("请输入对应选项:");
            String str = scanner.next();
            if (str.matches("\\d")) {//通过正则表达式判断输入的指令
                switch (str) {
                    case "1":
                        System.out.println("正在行先序遍历-->");
                        binaryTree.preOrder();
                        System.out.println();
                        break;
                    case "2":
                        System.out.println("正在进行中序遍历-->");
                        binaryTree.infixOrder();
                        System.out.println();
                        break;
                    case "3":
                        System.out.println("正在进行后序遍历-->");
                        binaryTree.postOrder();
                        System.out.println();
                        break;
                    case "4":
                        System.out.println("二叉树的叶子节点个数:"+binaryTree.leafSiZe(root));
                        break;
                    case "5":
                        System.out.println("总结点个数:"+binaryTree.size(root));
                        break;
                    case "6":
                        System.out.println("二叉树的高度:"+binaryTree.height(root));
                        break;
                    case "7":
                        System.exit(0);
                    default:
                        System.out.println("输入有误，请输入指令范围内的数字");
                        break;
                }
            } else {
                System.out.println("请输入数字选项");
            }

        }

    }
}


