package exerciseendless.StringAndDateUse.StringUse;

//利用StringBuilder进行字符串连接方法
//节省空间，提升效率
public class StringBuilderlinkwith {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 5, 6, 65, 7, 6767, 9};
        String s = link(a);
        System.out.println(s);
    }

    //拼接方法，在数组元素中添加了","和"[]"
    public static String link(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                sb.append(arr[i]);
            } else sb.append(arr[i] + ",");
        }
        sb.append("]");
        String s = sb.toString();
        return s;
    }

}
