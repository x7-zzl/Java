package Java数据结构和算法.数据结构和算法__C语言.查找和排序;
/*
设计并实现一个新冠疫苗接种信息管理系统（假设该系统面向需要接种两剂的疫苗）。
要求定义一个包含接种者的身份证号、姓名、已接种了几剂疫苗、第一剂接种时间、第二剂接种时间等信息的顺序表，系统至少包含以下功能：
        （1）逐个显示信息表中疫苗接种的信息；
        （2）两剂疫苗接种需要间隔14~28天，输出目前满足接种第二剂疫苗的接种者信息；
        （3）给定一个新增接种者的信息，插入到表中指定的位置；
        （4）分别删除指定位置和给定接种者身份证号的图书记录；
        （5）利用直接插入排序或者折半插入排序按照身份证号进行排序；
        （6）分别利用快速排序和堆排序按照第一剂接种的时间进行排序；
        （7）根据身份证号进行折半查找，若查找成功，则返回此接种者的信息；
        （8）为提高检索效率，要求利用利用接种者的姓氏为关键字建立哈希表，并利用链地址法处理冲突。给定接种者的身份证号或姓名，查找疫苗接种信息，并输出冲突次数和平均查找长度；
        （9）提供用户菜单，方便选择执行功能。可以设计成一级或多级菜单。所有功能都可重复执行。
*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class COVIDInfoManageSystem {
    public static void main(String[] args) throws ParseException {
        //设置顺序表的初始长度为10
        HashTab tab = new HashTab(20);

        tab.add(new VaccinatedInfo("413026197701087215", "何畅", 1,
                "2022-06-06", "未接种"));
        tab.add(new VaccinatedInfo("753026199706069436", "土间埋", 1,
                "2022-06-12", "未接种"));
        tab.add(new VaccinatedInfo("645302619380606395", "刘华强", 1,
                "2022-06-27", "未接种"));
        tab.add(new VaccinatedInfo("524353200011357327", "李四", 1,
                "2022-05-27", "未接种"));
        tab.add(new VaccinatedInfo("222222222222222222", "赵大", 2,
                "2022-03-21", "2022-04-16"));
        tab.add(new VaccinatedInfo("411525200207117219", "张自力", 2,
                "2021-03-01", "2021-03-21"));
        System.out.println("<---欢迎使用新冠疫苗接种信息管理系统--->");
        System.out.println("1.逐个显示信息表中疫苗接种的信息");
        System.out.println("2.输出目前满足接种第二剂疫苗的接种者信息");
        System.out.println("3.插入新增接种者的信息到表中指定的位置");
        System.out.println("4.分别删除指定位置和给定接种者身份证号的记录");
        System.out.println("5.利用折半插入排序按照身份证号进行排序");
        System.out.println("6.分别利用快速排序和堆排序按照第一剂接种的时间进行排序");
        System.out.println("7.根据身份证号进行折半查找，若查找成功，则返回此接种者的信息");
        //利用接种者的姓氏为关键字建立哈希表，并利用链地址法处理冲突。给定接种者的身份证号或姓名
        System.out.println("8.查找疫苗接种信息，并输出冲突次数和平均查找长度");
        System.out.println("9.退出系统");
        while (true) {
            System.out.println("<---输入指令前对应的数字实现相应的功能--->");
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            switch (n) {
                case 1:
                    System.out.println("1.逐个显示信息表中疫苗接种的信息");
                    tab.display();
                    break;
                case 2:
                    System.out.println("2.目前满足接种第二剂疫苗的接种者信息如下：");
                    String currentDate = formattedDate(new Date());
                    System.out.println("目前日期是:" + currentDate);
                    tab.canInoculateSecondVaccination();
                    break;
                case 3:
                    System.out.println("3.插入新增接种者的信息到表中指定的位置");
                    Scanner in = new Scanner(System.in);
                    System.out.print("插入位置为:");
                    int index = in.nextInt();
                    System.out.print("接种者身份证号码:");
                    String id = new Scanner(System.in).nextLine();
                    System.out.print("接种者姓名:");
                    String name = new Scanner(System.in).nextLine();
                    System.out.print("已接种剂次:");
                    int t = in.nextInt();
                    System.out.print("第一次接种时间:");
                    String first = new Scanner(System.in).nextLine();
                    System.out.print("第二次接种时间:");
                    String second = new Scanner(System.in).nextLine();
                    tab.addByOrder(index, new VaccinatedInfo(id, name, t, first, second));
                    break;
                case 4:
                    System.out.println("1.指定位置删除");
                    System.out.println("2.根据身份证号删除");
                    int select = new Scanner(System.in).nextInt();
                    if (select == 1) {
                        System.out.print("请输入位置下标:");
                        int anInt = new Scanner(System.in).nextInt();
                        tab.deleteIndex(anInt);
                    } else if (select == 2) {
                        System.out.print("请输入身份证号码:");
                        String SID = new Scanner(System.in).nextLine();
                        tab.deleteID(SID);
                    } else {
                        System.out.println("请输入正确的指令");
                    }
                    break;
                case 5:
                    System.out.println("5.利用折半插入排序按照身份证号进行排序，结果如下：");
                    tab.sortID();
                    break;
                case 6:
                    System.out.println("利用快速排序按照第一剂接种的时间进行排序，结果如下");
                    tab.firstQS();
                    System.out.println("利用堆排序按照第一剂接种的时间进行排序，结果如下");
                    tab.firstDPX();
                    break;
                case 7:
                    System.out.println("7.根据身份证号进行折半查找，若查找成功，则返回此接种者的信息");
                    System.out.print("请输入你要查找的身份证号码：");
                    String choice_id = new Scanner(System.in).nextLine();
//                    tab.firstQS();
                    System.out.println(tab.binarySearchID(Long.parseLong(choice_id)));
                    break;
                case 8:
                    System.out.println("8.查找疫苗接种信息");
                    System.out.println("1.根据姓名查找");
                    System.out.println("2.根据身份证号查找");

                    int nextInt = new Scanner(System.in).nextInt();
                    if (nextInt == 1) {
                        System.out.print("请输入姓名:");
                        String line = new Scanner(System.in).nextLine();
                        tab.findByName(line);

                    } else if (nextInt == 2) {
                        System.out.print("请输入身份证号码:");
                        String s = new Scanner(System.in).nextLine();
                        tab.findByID(s);

                    } else {
                        System.out.println("请输入正确的指令");
                    }
                    break;
                case 9:
                    System.out.println("9.退出系统");
                    System.exit(0);
                default:
                    System.out.println("你输入的指令不合法");
                    break;
            }
        }
    }

    //格式化日期
    public static String formattedDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

}

