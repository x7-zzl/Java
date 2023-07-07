package 图形用户界面.exercise;


public class A{
    public static void main(String[] args) {
        int i=0;
        int a[]= {2,3,4,0,5,6,7,8,9,0,9};
        for( i=0;i<a.length;i++)
        {
            int b=i;
            for (int j=i+1;j<a.length;j++)
                if(a[j]>a[i])
                {
                    b=j;
                }
            int temp=a[b];
            a[b]=a[i];
            a[i]=temp;
        }
        for( i=0;i<a.length;i++)
        {
        System.out.println(a[i]);
    }}
}
