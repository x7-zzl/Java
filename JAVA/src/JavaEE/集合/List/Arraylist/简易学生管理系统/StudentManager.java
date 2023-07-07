package JavaEE.集合.List.Arraylist.简易学生管理系统;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        while (true) {
            System.out.println("-------欢迎使用学生管理系统-------");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看所有学生");
            System.out.println("5 退出");
            System.out.println("请输入你的选择：");

            Scanner in = new Scanner(System.in);
            int line = in.nextInt();

            switch (line) {
                case 1:
                    add(students);
                    break;
                case 2:
                    delete(students);
                    break;
                case 3:
                    update(students);
                    break;
                case 4:
                    select(students);
                    break;
                case 5:
                    System.out.println("谢谢使用");
                    System.exit(0);
            }
        }
    }


    private static void add(ArrayList<Student> students) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入学生学号");
        String id = sc.nextLine();

        System.out.println("请输入学生姓名");
        String name = sc.nextLine();

        System.out.println("请输入学生年龄");
        String age = sc.nextLine();

        System.out.println("请输入学生地址");
        String address = sc.nextLine();

        Student s = new Student();
        s.setId(id);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);

        students.add(s);

        System.out.println("添加学生成功");
    }

    private static void select(ArrayList<Student> students) {
        if(students.size()==0){
            System.out.println("无信息，请先添加信息在查询");
            return;
        }
        System.out.println("学号\t姓名\t年龄\t地址");
       for (int i=0;i<students.size();i++){
           Student s= students.get(i);
           System.out.println(s.getId()+"\t"+s.getName()+"\t"+s.getAge()+"\t"+s.getAddress()+"\t");
       }
        System.out.println("查看学生成功");
    }

    private static void update(ArrayList<Student> students) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入要修改的学生学号");
        String id = sc.nextLine();

        System.out.println("请输入学生新的姓名");
        String name = sc.nextLine();

        System.out.println("请输入学生新的年龄");
        String age = sc.nextLine();

        System.out.println("请输入学生新的地址");
        String address = sc.nextLine();

        Student s = new Student();
        s.setId(id);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);


        for(int i=0;i<students.size();i++){
            Student student=students.get(i);
            if(student.getId().equals(id)){
              students.set(i,s);
              break;

            }
        }


        System.out.println("修改学生成功");
    }

    private static void delete(ArrayList<Student> students) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入你要删除学生的学号");
        String id = sc.nextLine();
        for (int i=0;i<students.size();i++){
            Student s=students.get(i);
            if(s.getId().equals(id)){
                students.remove(i);
                break;
            }
        }
        System.out.println("删除学生成功");
    }

}
