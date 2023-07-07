package leetcode;

public class t1108_IP地址无效化 {
    public static void main(String[] args) {
        String address = "1.1.1.1";
        System.out.println(defangIPaddr(address));
    }

    public static String defangIPaddr(String address) {
//        return address.replaceAll("\\.", "[.]");

         return address.replace(".", "[.]");
    }
}
