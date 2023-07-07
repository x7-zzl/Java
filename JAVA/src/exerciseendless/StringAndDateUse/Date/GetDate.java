package exerciseendless.StringAndDateUse.Date;
//输出当前的时间

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetDate {
    public static void main(String[] args) {

        //输出当前时间
        Date now = new Date();
        //设置日期格式(年-月-日-时-分-秒)
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //格式化然后放入字符串中
        String createTime = dateFormat.format(now);
        System.out.println(createTime);

        //获取时间
        //从1970年1月1日0:00到现在时间的毫秒值
        Date date = new Date();
        //从1970年1月1日0:00到现在时间的毫秒值
        System.out.println(date.getTime());
        //获取当前的时间
        long time = System.currentTimeMillis();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //格式化然后放入字符串中
        String e = f.format(time);
        System.out.println(e);
        date.setTime(time);
        System.out.println(date);


        //用Calendar类提供的方法获取年、月、日、时、分、秒
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);   //年
        int month = cal.get(Calendar.MONTH) + 1;  //月  默认是从0开始  即1月获取到的是0
        int day = cal.get(Calendar.DAY_OF_MONTH);  //日，即一个月中的第几天
        int hour = cal.get(Calendar.HOUR_OF_DAY);  //小时
        int minute = cal.get(Calendar.MINUTE);   //分
        int second = cal.get(Calendar.SECOND);  //秒
        //拼接成字符串
        String line = year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;
        System.out.println(line);


        Calendar calendar = Calendar.getInstance();
        // 转换格式 使用format将这个日期转换成我们需要的格式
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String line1 = formatter.format(calendar.getTime());
        System.out.println(line1);
    }
}
