package JavaEE.集合.Map;

import java.util.HashMap;
import java.util.Set;

public class MapForStudent {
    public static void main(String[] args) {
        HashMap<String,Student> hm=new HashMap<>();
        Student s1=new Student("关羽",32);
        Student s2=new Student("张飞",33);
        Student s3=new Student("刘备",31);


        hm.put("1",s1);
        hm.put("2",s2);
        hm.put("3",s3);



        Set<String> keySet = hm.keySet();
        for(String key:keySet){
            Student value=hm.get(key);
            System.out.println(key+","+value.getName()+","+value.getAge());
        }
    }
}
