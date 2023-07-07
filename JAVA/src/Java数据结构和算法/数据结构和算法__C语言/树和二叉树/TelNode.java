package Java数据结构和算法.数据结构和算法__C语言.树和二叉树;
/*2.一个单位有5个部门，每个部门都有一部电话，但是整个单位只有一根外线，
当有电话打过来的时候，由转接员转到内线电话，已知各部门使用外线电话的频率为（次/天）：
5 16 9 12 19。利用哈夫曼树算法思想设计内线电话号码，使得接线员拨号次数尽可能少。
要求：
        （1）依据使用外线电话的频率构造二叉树；
        （2）输出设计出的各部门内线电话号码。*/


import java.util.*;

//实现Comparable接口的compareTo方法，实现权值大小的比较
public class TelNode implements Comparable<TelNode> {
    String name;
    int weight;//权值：频率
    TelNode left, right;

    public TelNode(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "weight=" + weight;
    }

    //前序遍历
    public void preOrder() {
        System.out.print(this+" ");
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    @Override
    public int compareTo(TelNode o) {//通过比较器从小到大排序
        return this.weight - o.weight;
    }
}

class HaFuManTree {

    public static void main(String[] args) {

        //创建一个集合将对象存储起来
        int[] a = {5, 16, 9, 12, 19};//2,3,5,7,11,13,17,19,23,29,31
        ArrayList<TelNode> list = new ArrayList<>();
        //按数组元素的顺序给部门命名
        for (int i = 0; i < a.length; i++) {
            list.add(new TelNode("部门" + (i + 1), a[i]));
        }

        //通过对象集合创建对应的哈夫曼树
        //获得哈夫曼树的根节点
        TelNode haFuManRoot = createHuFuManTree(list);
        //对生成的哈夫曼树进行前序遍历
        System.out.println("对生成的哈夫曼树进行前序遍历:");
        preOrder(haFuManRoot);
        System.out.println();
        //向左递归生成0，向右递归生成1
        Map<String, String> map = getCodes(haFuManRoot);

//        List<Map.Entry<String, String>> list_map_sort = new ArrayList<Map.Entry<String, String>>(map.entrySet());
//        list_map_sort.sort(new Comparator<Map.Entry<String, String>>() {
//            @Override
//            public int compare(Map.Entry<String, String> o1,
//                               Map.Entry<String, String> o2) {
//                return o1.getKey().compareTo(o2.getKey());
//            }
//        });

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    public static void preOrder(TelNode root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("生成哈夫曼树为空");
        }
    }

    //通过对象集合创建对应的哈夫曼树的方法
    public static TelNode createHuFuManTree(List<TelNode> list) {
        while (list.size() > 1) {
            Collections.sort(list);
            //取出第一颗最小的二叉树
            TelNode leftTelNode = list.get(0);
            //取出第二颗最小的二叉树
            TelNode rightTelNode = list.get(1);
            //创建一颗新的二叉树
            TelNode parent = new TelNode(null, leftTelNode.weight + rightTelNode.weight);
            parent.left = leftTelNode;
            parent.right = rightTelNode;
            //将已经处理的两颗二叉树删除
            list.remove(leftTelNode);
            list.remove(rightTelNode);
            //将新的二叉树加入
            list.add(parent);
        }
        return list.get(0);
    }

    //使用StringBuilder拼接
    static StringBuilder stringBuilder = new StringBuilder();
    static Map<String, String> haFuManTelCode = new HashMap<String, String>();

    //方法重载
    private static Map<String, String> getCodes(TelNode root) {
        if (root == null) {
            return null;
        }
        //处理root的左子树
        getCodes(root.left, "0", stringBuilder);
        //处理root的右子树
        getCodes(root.right, "1", stringBuilder);
        return haFuManTelCode;
    }

    //使用map集合存入部门名称和拼接的哈夫曼编码
    private static void getCodes(TelNode telNode, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        //将code加入到 stringBuilder2
        //code为0或1，用来生成哈夫曼编码，拼接得到的即是哈夫曼编码
        stringBuilder2.append(code);
        if (telNode != null) {
            //向左递归
            getCodes(telNode.left, "0", stringBuilder2);
            //向右递归
            getCodes(telNode.right, "1", stringBuilder2);
            //输出name为空的路径，即叶子节点的对应编码
            if (telNode.name != null) {
                haFuManTelCode.put(telNode.name, stringBuilder2.toString());
            }
        }
    }

}