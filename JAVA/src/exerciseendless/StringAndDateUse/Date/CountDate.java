package exerciseendless.StringAndDateUse.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CountDate {

    public static void main(String[] args) {

        //比较两段日期的差值
        String startTime = "2020-07-11 17:21:36";

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String parentTime = dateFormat.format(date);

        String start = "2020-01-11 17:22:51";
        String end = "2021-01-11 17:22:51";

        try {
            System.out.println(getTime(startTime, parentTime));
            System.out.println(getTime(start, end));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    // 获取两个时间相差毫秒数
    public static long getTime(String oldTime, String newTime) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long now = df.parse(newTime).getTime();
        //从对象中拿到时间
        long end = df.parse(oldTime).getTime();
        return (now - end);
    }


}
