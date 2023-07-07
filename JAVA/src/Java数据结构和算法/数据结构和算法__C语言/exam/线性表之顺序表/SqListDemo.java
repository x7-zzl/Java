package Java数据结构和算法.数据结构和算法__C语言.exam.线性表之顺序表;

//测试类
public class SqListDemo {
    public static void main(String[] args) throws Exception {
        //长度为10
        SqList sqList = new SqList(3);

        SqList sqList2 = new SqList(3);

        ElemType elem1 = new ElemType(1, "鸢一折纸", "女", 19);
        ElemType elem2 = new ElemType(2, "本条二亚", "女", 32);
        ElemType elem3 = new ElemType(3, "时崎狂三", "女", 18);
        ElemType elem4 = new ElemType(4, "四糸乃", "女", 16);
        ElemType elem5 = new ElemType(6, "星宫六飱", "女", 17);
        sqList.clear();
        System.out.println("是否为空:" + sqList.isEmpty());
        System.out.println("插入操作：");
        try {
            sqList.insert(0, elem1);
            sqList.insert(1, elem2);
            sqList.insert(2, elem3);

            sqList.insert(2, elem4);
            sqList.insert(3, elem5);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        System.out.println("是否为空:" + sqList.isEmpty());
        sqList.show();
        System.out.println("删除操作：");
        sqList.delete(1);
        sqList.show();
        System.out.println("修改操作：");
        sqList.update(4, new ElemType(1, "1", "1", 1));
        sqList.show();
        System.out.println("查询操作：");
        System.out.println("对象" + elem1 + "在顺序表的下标为" + sqList.getIndex(elem1) + "位置");
    }

    //顺序表的合并和删除

}
