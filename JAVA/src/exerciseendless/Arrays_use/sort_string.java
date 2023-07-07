package exerciseendless.Arrays_use;

import java.util.Arrays;

public class sort_string {
    public static void main(String[] args) {
        int[] a = {1, 4, 5, 2, 3, 7, 8, 6, 9, 4, 55, 32, 12, 12, 55, 434, 7};
        System.out.println(Arrays.toString(a));

        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
