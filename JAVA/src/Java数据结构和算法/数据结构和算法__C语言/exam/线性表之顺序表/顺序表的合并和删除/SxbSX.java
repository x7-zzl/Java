package Java数据结构和算法.数据结构和算法__C语言.exam.线性表之顺序表.顺序表的合并和删除;

public class SxbSX {
    int elem[];
    int length;

    SxbSX() {        //构造函数
        elem = new int[100];
        length = 0;
    }

    void display()//遍历
    {
        for (int i = 0; i < length; i++) {
            System.out.print(elem[i] + " ");
        }
        System.out.print(" ");
    }

}

class SxbHB {
    public static void main(String args[]) throws Exception {

        SxbSX LA = new SxbSX();
        LA.length = 5;
        LA.elem[0] = 12;
        LA.elem[1] = 23;
        LA.elem[2] = 34;
        LA.elem[3] = 45;
        LA.elem[4] = 56;


        SxbSX LB = new SxbSX();
        LB.length = 6;
        LB.elem[0] = 1;
        LB.elem[1] = 2;
        LB.elem[2] = 3;
        LB.elem[3] = 4;
        LB.elem[4] = 5;
        LB.elem[5] = 6;


        SxbHB SH = new SxbHB();
        System.out.println("合并结果：");
        SH.merge(LA, LB);
        System.out.println("相减结果：");
        SH.jian(LA, LB);
    }

    //相减
    public static void jian(SxbSX LA, SxbSX LB) throws Exception {
        int i = 0, j = 0, k = 0;
        SxbSX LC = new SxbSX();
        LC.length = 10;
        while (i < LA.length && j < LB.length) {
            if (LA.elem[i] > LB.elem[j]) {
                LC.elem[k++] = LA.elem[i++] - LB.elem[j++];
            } else {
                LC.elem[k++] = LB.elem[j++] - LA.elem[i++];
            }

        }


        while (i < LA.length) {
            LC.elem[k] = LA.elem[i];
            i++;
            k++;

        }

        while (j < LB.length) {
            LC.elem[k] = LB.elem[j];
            j++;
            k++;

        }

        LC.display();
        System.out.print(" ");
    }


    //合并
    public static void merge(SxbSX LA, SxbSX LB) throws Exception {

        int i = 0;
        int j = 0;
        SxbSX LC = new SxbSX();
        LC.length = 10;
//发现for循环行不通，有点复杂，不够灵活
        /* for(int x=0;x<LA.length;){
         *     for(int y=0;y<LB.length;){
         *        for(int k=0;k<10;k++){
         *             if(LA.elem[i]>LB.elem[j])
         *            {LC.elem[k]=LB.elem[j];j++;}
         *                       else
         *              {  LC.elem[k]=LA.elem[i];i++;}
         *
         *        }
         *
         *    }
         *}
         */
        int k = 0;
        while (i < LA.length && LB.length > j) {
            if (LA.elem[i] > LB.elem[j]) {
                LC.elem[k++] = LB.elem[j++];
            } else {
                LC.elem[k++] = LA.elem[i++];
            }
        }
        while (i < LA.length) {
            LC.elem[k] = LA.elem[i];
            i++;
            k++;

        }

        while (j < LB.length) {
            LC.elem[k] = LB.elem[j];
            j++;
            k++;

        }
        LC.display();
        System.out.print(" ");
    }
}