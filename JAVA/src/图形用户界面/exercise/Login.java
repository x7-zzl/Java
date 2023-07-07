package 图形用户界面.exercise;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    JFrame loginFrame;//框架名称
    JPanel loginPanel;//面板
    JLabel nameLabel, passwordLabel;
    JTextField nameTextField;
    JPasswordField passwordTextField;
    JButton loginButton, registerButton;//登录，注册按钮

    public Login() {
        loginFrame = new JFrame("登录界面");
        loginPanel = new JPanel();
        loginFrame.add(loginPanel);

        nameLabel = new JLabel("用户名：");
        loginPanel.add(nameLabel);
        nameTextField = new JTextField(15);
        loginPanel.add(nameTextField);

        passwordLabel = new JLabel("密    码：");
        loginPanel.add(passwordLabel);
        passwordTextField = new JPasswordField(15);
        loginPanel.add(passwordTextField);


        loginButton = new JButton("登录");
        registerButton=new JButton("注册");

        loginButton.addActionListener(new ActionListener() //匿名类开始
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getActionCommand().equals("登录")) {
                    if (nameTextField.getText().equals("1") && String.valueOf(passwordTextField.getPassword()).equals("1"))
                        JOptionPane.showMessageDialog(null, "登录成功!");
                    else
                        JOptionPane.showMessageDialog(null, "登录失败!");
                }
            }
        });//匿名类结束


        ActionListener ssr=new ActionListener() {//通过匿名类对象ssr
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getActionCommand().equals("注册"))
                {
                    new ZhuceGUI();
                }
            }
        };
        registerButton.addActionListener(ssr);//事件监听器的对象

     /* registerButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              if(e.getActionCommand().equals("注册"))
              {
                  new ZhuceGUI();
              }
          }
      });*/

JTabbedPane jTabbedPane=new JTabbedPane();//选项卡窗格，一般容器，与jpanel同级
loginFrame.add(jTabbedPane);
jTabbedPane.add("登录页",loginPanel);
        final Object[] columnName = {"姓名", "性别", "家庭地址"};//一维数组
        Object[][] rowData = {{"tt", "男", "郑州"}, {"def", "女", "洛阳"},   {"ghj", "男", "开封"}, {"wer", "女", "新乡"}, {"cvb", "男", "南阳"},};//二维数组

        JTable example3= new JTable (rowData,columnName);//表格
        JScrollPane jScrollPane =new JScrollPane( example3);//滚动窗格
        jTabbedPane.add("表格页面",  jScrollPane);//滚动窗格选项卡


        JMenuBar mBar=new JMenuBar();//菜单栏对象
        loginFrame.setJMenuBar(mBar);//在框架顶层设置菜单栏

        JMenu[] m={new JMenu("文件"), new JMenu("编辑"),new JMenu("帮助")};
        for(int i=0;i<m.length;i++)
            mBar.add(m[i]); //菜单添加到菜单栏中



        loginPanel.add(nameLabel);
        loginPanel.add(nameTextField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordTextField);
        loginPanel.add( new JLabel("           "));
        loginPanel.add(loginButton);
        loginPanel.add(registerButton);

        loginFrame.setSize(250,300);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);
    }


    public static void main(String[] args) {
        new Login();
    }
}