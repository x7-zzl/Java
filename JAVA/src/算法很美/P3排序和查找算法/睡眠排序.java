package 算法很美.P3排序和查找算法;

public class 睡眠排序 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4,4, 5, 6, 2, 3, 8, 9, 7};
        sleepSort(nums);
    }


    public static void sleepSort(int[] nums) {
        for (final int j : nums) {
            new Thread(() -> {
                try {
                    Thread.sleep(j);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.print(j+" ");
            }).start();
        }
    }
}
