package JavaEE.集合.Set.LinkedHashSet;
//集合取出元素
import java.util.LinkedHashSet;

public class LinkedHashSetUse1 {
    public static void main(String[] args) {
        LinkedHashSet<String> lhs=new LinkedHashSet<>();

        lhs.add("hello");
        lhs.add("world");
        lhs.add("java");

        for (String s:lhs){
            System.out.println(s);
        }
    }
}
