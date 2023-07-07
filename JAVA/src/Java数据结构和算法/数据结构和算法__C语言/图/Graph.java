package Java数据结构和算法.数据结构和算法__C语言.图;
/*
根据郑州市方特欢乐主题公园设计一个简单的游玩路线，设计数据结构和算法实现相应功能。
要求所含景点不少于8个（方特城堡为其中一个景点，其他的例如极地快车、海螺湾、恐龙岛等）。
以图中顶点表示公园内各景点，包含景点名称、景点介绍等信息；以边表示路径，存放路径长度信息。要求：
        （1）根据上述信息创建一个图，使用邻接矩阵存储；
        （2）景点信息查询：为游玩客人提供公园内任意景点相关信息的介绍；
        （3）问路查询：为游玩客人提供从旋转飞车到达任意其它景点之间的一条最短路径。
*/

import java.util.*;

//图
//以边表示路径，存放路径长度信息
public class Graph {
    //存储顶点对象的集合
    public static ArrayList<Vertex> vertexArrayList = new ArrayList<>();
    public final int[][] adjacentMatrix;//邻接矩阵
    //定义给数组boolean[], 记录某个结点是否被访问
    public boolean[] isVisited;
    //以图中顶点表示公园内各景点，包含景点名称、景点介绍等信息；
    //方特城堡（1）、极地快车（2）、海螺塆（3）、恐龙危机（4）、飞越极限（5）、恐龙岛（6）、旋转飞车（7）、飞翔之歌（8）
    public static Vertex v1 = new Vertex("方特城堡", "方特城堡是大型儿童参与式体验项目。在这儿，您不仅能现场观看生动有趣的手偶剧表演，还能够亲身感受虚拟仿真、多媒体互动等妙趣横生的游艺技术，淘气堡、小滑梯、充气屋、卡通秀等玩乐设施装点成的童梦天地。");
    public static Vertex v2 = new Vertex("极地快车", "集合战斗机特技动作，模拟飞行员身心体验，极地快车来自久负盛名的过山车生产国度——荷兰，是经典的回旋式过山车。奇异的倒退提升，迅猛的极速俯冲，多次上下捻转颠倒，似鹰击长空，若剑指苍穹，令观者欢欣惊叹，能带来失重、离心状态下的惊险体验。");
    public static Vertex v3 = new Vertex("海螺湾", "蔚蓝色的海洋世界里，一场盛大的海底嘉年华表演正在进行！危险突然降临，鱼儿们能否勇敢的打败那些侵略者，保卫自己美丽的家园——海螺湾？让我们戴上4D眼镜，一起进入这个五色斑斓的海底世界，给鱼儿们加油，共同度过这惊心动魄的一刻，感受海洋动物的神奇与可爱。");
    public static Vertex v4 = new Vertex("恐龙危机", "恐龙试验室里恐龙基因变异，一夜之间恐龙大量繁殖并逃出试验室，破坏城市、伤害人类。在空中警察带领下，人们开始了前途未卜的生死大逃亡。大型恐龙复活灾难体验项目——恐龙危机，让您经历一场不容错过的惊险之旅。");
    public static Vertex v5 = new Vertex("飞越极限", "悬挂式球幕剧场“飞越极限”带您飞翔于天际，或坠落深渊峡谷，或穿越埃菲尔铁塔，或盘旋于珠穆朗玛之巅，或呼啸在延绵的万里长城，或鸟瞰东方之珠璀璨的夜景，圆您一个翱翔的梦想。在饱览世间美景的同时，体验凌空飞行真实感受。");
    public static Vertex v6 = new Vertex("恐龙岛", "逃出恐龙岛是以吴哥窟为主要建筑风格的大型室内漂流历险主题项目，游客将乘坐小船进入危险的侏罗纪时代，在茂密丛林里展开一场惊心动魄的冒险。巨型恐龙的隆隆脚步震动着大地、头顶上盘旋着空中猎手、巨石突然从眼前滚落，紧张和恐怖弥漫四周。随后游船从几十米高的悬崖瀑布上急速下坠，让游客在惊叫声中经历一场永生难忘的恐龙岛冒险之旅。");
    public static Vertex v7 = new Vertex("旋转飞车", "旋转飞车是设在公园等大型游乐场所的娱乐机械。");
    public static Vertex v8 = new Vertex("飞翔之歌", "大型原创魔幻秀——《飞翔之歌》，将丰富的科技手段和文化的现实意义巧妙结合，惟妙惟肖地描述了人类肆意开发自然背景下鸟类的生活变迁和情感波动，生动而深刻地阐释了生态保护的主题。");

    //构造方法
    public Graph(int[][] adjacentMatrix) {
        this.adjacentMatrix = adjacentMatrix;
    }

    //显示邻接矩阵
    public void showAdjacentMatrix() {
        for (int[] a : adjacentMatrix) {
            System.out.print("[");
            for (int i : a) {
                System.out.print(i + "\t");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    //找到当前节点的邻接节点
    public int getNeighbor(int i) {
        for (int j = 0; j < vertexArrayList.size(); j++) {
            if (adjacentMatrix[i][j] > 0) {
                return j;//返回节点的下标
            }
        }
        return -1;//没找到
    }

    //根据前一个邻接结点的下标来获取下一个邻接结点
    public int getNext(int v1, int v2) {
        for (int j = v2 + 1; j < vertexArrayList.size(); j++) {
            if (adjacentMatrix[v1][j] > 0) {
                return j;//返回节点的下标
            }
        }
        return -1;
    }

    //图的深度优先，遍历所有节点
    public void dfs() {
        isVisited = new boolean[vertexArrayList.size()];
        for (int i = 0; i < vertexArrayList.size(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    //传入参数
    public void dfs(boolean[] isVisited, int i) {
        //输出当前节点
        System.out.println(vertexArrayList.get(i) + "->");
        //标记当前节点已经访问
        isVisited[i] = true;
        int v = getNeighbor(i);
        while (v != -1) {//有
            if (!isVisited[v]) {//节点未被访问
                dfs(isVisited, v);
            } else {
                v = getNext(i, v); //节点访问过，访问下一个节点
            }

        }

    }

    //图的广度优先遍历
    public void bfs() {
        isVisited = new boolean[vertexArrayList.size()];//初始化数组
        for (int i = 0; i < vertexArrayList.size(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }

    public void bfs(boolean[] isVisited, int i) {
        System.out.println(vertexArrayList.get(i));
        //使用LinkedList集合表示队列，记录结点访问的顺序
        LinkedList<Integer> queue = new LinkedList<>();
        isVisited[i] = true;
        queue.addLast(i);//入队列
        while (!queue.isEmpty()) {
            //取出队列的头结点下标
            int first = queue.removeFirst();
            int v = getNeighbor(i);//第一个邻接节点
            while (v != -1) {
                if (!isVisited[v]) {//未访问
                    System.out.println(vertexArrayList.get(v));
                    isVisited[v] = true;
                    queue.addLast(v);
                } else {
                    v = getNext(first, v);
                }
            }
        }
    }

    //dijkstra算法，传入参数邻接矩阵和算法开始的点
    //本次实验中以旋转飞车（7）为起点，在集合中下标为6
    public int[] dijkstra(int[][] adjacentMatrix, int startVertex) {
        int[] result = new int[adjacentMatrix.length];
        //初始化已经求出最短路径的数组result[]，将result数组赋值-1
        Arrays.fill(result, -1);
        result[startVertex] = 0;//自身之间的距离为0
        // 初始化未求出最短路径的数组 notFound[]
        int[] notFound = new int[adjacentMatrix.length];
        System.arraycopy(adjacentMatrix[startVertex], 0, notFound, 0, notFound.length);
        notFound[startVertex] = -1;//notFound数组值为-1时表示为已经求出最短路径

        for (int i = 1; i < adjacentMatrix.length; i++) {
            //从「未求出最短路径的点」notFound 中取出 最短路径的点
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int j = 0; j < adjacentMatrix.length; j++) {
                if (notFound[j] > 0 && notFound[j] < min) {
                    min = notFound[j];
                    minIndex = j;
                }
            }

            //将最短距离的点 取出 放入结果中
            result[minIndex] = min;
            notFound[minIndex] = -1;
            //刷新 「未求出最短距离的点」 notFound[] 中的距离
            for (int j = 0; j < adjacentMatrix.length; j++) {
                //遍历刚刚找到最短距离的点
                //不能已经在结果集 result中
                if (adjacentMatrix[minIndex][j] > 0  && result[j] == -1) {
                    int distance = result[minIndex] + adjacentMatrix[minIndex][j];

                    //notFound数组值为-1时表示为已经求出最短路径
                    if (distance < notFound[j] || notFound[j] == -1) {
                        notFound[j] = distance;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        //插入结点
        vertexArrayList.add(v1);
        vertexArrayList.add(v2);
        vertexArrayList.add(v3);
        vertexArrayList.add(v4);
        vertexArrayList.add(v5);
        vertexArrayList.add(v6);
        vertexArrayList.add(v7);
        vertexArrayList.add(v8);

//        int n=Integer.MAX_VALUE;
        int n = -1;//用-1来表示两点之间距离很大
        int[][] adjacentMatrix = new int[][]{
                {0, 3, 8, n, n, n, 7, n},
                {3, 0, n, n, 7, n, 5, n},
                {8, n, 0, n, n, 10, 9, n},
                {n, n, n, 0, 11, n, n, 14},
                {n, 7, n, 11, 0, n, n, 27},
                {n, n, 10, n, n, 0, 6, 13},
                {7, 5, 9, n, n, 6, 0, n},
                {n, n, n, 14, 27, 13, n, 0}
        };


        Graph graph = new Graph(adjacentMatrix);

        System.out.println("邻接矩阵如下:");
        graph.showAdjacentMatrix();
        System.out.println("景点信息查询:");
        while (true) {
            System.out.println("输入1(深度优先遍历)或2(广度优先遍历),输入其他内容退出景点查询");
            String str = new Scanner(System.in).next();
            if (str.equals("1")) {
                graph.dfs();
            } else if (str.equals("2")) {
                graph.bfs();
            } else {
                break;//退出循环
            }
        }

        System.out.println("问路查询:");
        //返回从旋转飞车开始的点到其他景点的距离
        //本次实验中以旋转飞车（7）为起点，在集合中下标为6
        int[] dijkstra = graph.dijkstra(adjacentMatrix, 6);

        //方特城堡（1）、极地快车（2）、海螺塆（3）、恐龙危机（4）、飞越极限（5）、恐龙岛（6）、旋转飞车（7）、飞翔之歌（8）
        for (int i = 0; i < vertexArrayList.size(); i++) {
            System.out.println("从旋转飞车到"+vertexArrayList.get(i).name+"最短距离为"+dijkstra[i]);
        }
//        System.out.println(Arrays.toString(dijkstra));z
    }

}


//顶点
class Vertex {
    public String name;//景点名称
    public String introduction;//景点介绍

    public Vertex(String name, String introduction) {
        this.name = name;
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return "景点名称：[" + name + "]\n景点介绍：" + introduction;
    }

}

