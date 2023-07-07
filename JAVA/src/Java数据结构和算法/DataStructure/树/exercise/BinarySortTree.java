package Java数据结构和算法.DataStructure.树.exercise;

public class BinarySortTree {
    public static void main(String[] args) {
        BinarySortTree binarySortTree = new BinarySortTree();
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};

        for (int j : arr) {
            binarySortTree.add(new Node(j));
        }

        //中序遍历二叉排序树
        System.out.println("中序遍历二叉排序树~");
        binarySortTree.infixOrder(); // 1, 3, 5, 7, 9, 10, 12

    }


    private Node root;

    public void add(Node node){
        if(root==null){
           root=node;
        }else {
            root.add(node);
        }
    }

    public void infixOrder(){
        if(root==null){
            System.out.println("二叉排序树为空，不能遍历");
        }else {
            root.infixOrder();
        }
    }
}

class Node{
    int value;
    Node left,right;
    public Node(int value){
        this.value=value;
    }

    @Override
    public String toString() {
        return "Node{" + "value=" + value + '}';
    }

    public void add(Node node){
        if(node==null){
            return;
        }
        if(node.value<this.value){
            if(this.left==null){
                this.left=node;
            }else {
                this.left.add(node);
            }
        }else {
            if(this.right==null){
                this.right=node;
            }else {
                this.right.add(node);
            }
        }

    }


    public void infixOrder(){
        if(this.left!=null){
            this.left.infixOrder();
        }

        System.out.println(this);

        if(this.right!=null){
            this.right.infixOrder();
        }
    }
}
