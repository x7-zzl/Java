package Java数据结构和算法.数据结构和算法__C语言.线性表;
/*
利用链表实现一个简单的学生成绩管理系统：
        （1）学生成绩信息包括学号、姓名、性别、班级、高等数学成绩、大学英语成绩、C语言程序设计成绩和软件工程导论成绩等；
        （2）系统的主要功能包括：学生成绩信息的创建、输出学生成绩信息、查询学生成绩、增加学生成绩、删除学生成绩。
*/


import java.util.Scanner;

public class Student {
    public long no;
    public String name;
    public String sex;
    public int grade;
    public int math_score;
    public int english_score;
    public int c_score;
    public int software_program;
    Student next;

    public Student(int no, String name, String sex, int grade, int math_score, int english_score, int c_score, int software_program) {
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.grade = grade;
        this.math_score = math_score;
        this.english_score = english_score;
        this.c_score = c_score;
        this.software_program = software_program;
    }

    @Override
    public String toString() {
        return "{" + "学号:" + no + ", 姓名:" + name + ", 性别:" + sex + ", 班级:" + grade +
                ", 高等数学成绩" + math_score + ", 大学英语成绩" + english_score +
                ", C语言程序设计成绩:" + c_score + ", 软件工程导论成绩:" + software_program + '}';
    }
}

class SingleList {
    private Student head = new Student(0, "", "", 0, 0, 0, 0, 0);

    //增加学生成绩
    public void addStudent(Student s) {
        Student temp = head;
        while (temp.next != null) {
            //遍历到链表的结尾，跳出循环
            temp = temp.next;
        }
        //跳出循环后，让最后一个对象的指针指向要增加的对象
        temp.next = s;
    }


    //删除学生成绩
    public void deleteStudent(int no) {
        Student temp = head;
        //设置标记来判断是否找到学生学号
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            } else if (temp.next.no == no) {//找到需要删除学号的前一个
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("无此学生成绩信息");
        }
    }

    //查询学生成绩
    //输出学生成绩信息
    public void list() {
        //链表为空，输出提示信息，返回
        if (head.next == null) {
            System.out.println("无学生成绩信息");
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            //遍历到链表的结尾，跳出循环
            temp = temp.next;
            //输出
            System.out.println(temp);
        }
    }

    public static void main(String[] args) {
        SingleList singleList = new SingleList();
        System.out.println("欢迎使用学生成绩管理系统");
        System.out.println("输入序号以使用对应的功能");
        while (true) {
            System.out.println("1:增加学生成绩信息");
            System.out.println("2:删除学生成绩信息");
            System.out.println("3:查询学生成绩信息");
            System.out.println("4：退出系统");
            //读取用户的输入信息
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            switch (n) {
                case 1:
                    System.out.println("你正在增加学生成绩信息");
                    System.out.println("输入学生学号:");
                    int no = in.nextInt();
                    System.out.println("输入学生姓名:");
                    String name = new Scanner(System.in).nextLine();
                    System.out.println("输入学生性别:");
                    String sex = new Scanner(System.in).nextLine();
                    System.out.println("输入学生年级:");
                    int grade = in.nextInt();
                    System.out.println("输入学生高等数学成绩:");
                    int math = in.nextInt();
                    System.out.println("输入学生大学英语成绩:");
                    int english = in.nextInt();
                    System.out.println("输入学生C语言程序设计成绩:");
                    int c = in.nextInt();
                    System.out.println("输入学生软件工程导论成绩:");
                    int dao_lun = in.nextInt();
                    Student s = new Student(no, name, sex, grade, math, english, c, dao_lun);
                    singleList.addStudent(s);
                    System.out.println("添加学生信息成功");
                    break;

                case 2:
                    System.out.println("你正在删除学生成绩信息");
                    System.out.println("输入学生学号:");
                    int num = in.nextInt();
                    singleList.deleteStudent(num);
                    System.out.println("删除学生信息成功");
                    break;

                case 3:
                    System.out.println("你正在查询学生成绩信息");
                    singleList.list();
                    break;

                case 4:
                    System.out.println("你正在退出系统");
                    System.exit(0);
            }
        }
    }
}