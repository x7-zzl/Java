package JavaEE.集合.List.Arraylist;

import java.util.ArrayList;

//遍历集合
public class Arraylist02 {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("杨");
        arr.add("晓");
        arr.add("楠");
        for (int i = 0; i < arr.size(); i++) {
            String line = arr.get(i);
            System.out.println(line);
        }
    }
}
