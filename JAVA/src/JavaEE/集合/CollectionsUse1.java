package JavaEE.集合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class CollectionsUse1 {
    public static void main(String[] args) {

        HashMap<String, ArrayList<String>> hm = new HashMap<>();

        //创建ArrayList集合，并添加元素
        ArrayList<String> SanGuoYanYi = new ArrayList<>();
        SanGuoYanYi.add("诸葛亮");
        SanGuoYanYi.add("赵云");
        //把ArrayList作为元素添加到HashNap集合
        hm.put("三国演义", SanGuoYanYi);


        ArrayList<String> XiYouJi = new ArrayList<>();
        XiYouJi.add("唐僧");
        XiYouJi.add("孙悟空");
        //把ArrayList作为元素添加到HashMap集合
        hm.put("西游记", XiYouJi);


        ArrayList<String> shz = new ArrayList<>();
        shz.add("武松");
        shz.add("鲁智深");
        //把ArrayList作为元素添加到HashMap集合
        hm.put("水浒传", shz);

        //遍历HashMap集合
        Set<String> keySet = hm.keySet();
        for (String key : keySet) {
            ArrayList<String> value = hm.get(key);
            for (String s : value) {
                System.out.println(key+":"+s);
            }
        }
    }
}