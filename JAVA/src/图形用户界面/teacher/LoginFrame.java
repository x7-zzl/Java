package 图形用户界面.teacher;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame implements ActionListener{
    JFrame loginFrame;
    JPanel loginPanel;
    JLabel nameLabel,passwordLabel;
    JTextField nameTextField;
    JPasswordField passwordTextField;
    JButton loginButton,registerButton;
    public LoginFrame(){
        loginFrame =new JFrame("登录界面");
        loginPanel =new JPanel();
        loginFrame.add(loginPanel);

        nameLabel =new JLabel("用户名：");
        loginPanel.add(nameLabel);
        nameTextField =new JTextField(15);
        loginPanel.add(nameTextField );

        passwordLabel =new JLabel("密    码：");
        loginPanel.add(passwordLabel);
        passwordTextField =new  JPasswordField(15);
        loginPanel.add(passwordTextField );


        loginButton=new JButton("登录");
        loginPanel.add(loginButton );
        //loginButton是事件源对象，发生ActionEvent

        //本身所在的类对的对象充当监听器
        //  loginButton.addActionListener(this);

        //匿名类的对象充当监听器

        ActionListener ae= new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                if(e.getActionCommand().equals("登录")) {
                    if (nameTextField.getText().equals("111111") &&
                            String.valueOf(passwordTextField.getPassword()).equals("111111")
                    )
                        JOptionPane.showMessageDialog(null, "登录成功!");

                    else
                        JOptionPane.showMessageDialog(null, "登录失败!");

                }
                else  new RegisterGui();
            }
        };
        loginButton.addActionListener( ae);


        //ActionEvent事件监听器对象
        // ActionClass ActionObject =new ActionClass();
        //建立关系
        // loginButton.addActionListener(ActionObject);



        registerButton=new JButton("注册");
        loginPanel.add(registerButton );
        //事件源对象registerButton发生ActionEvent
        //    registerButton.addActionListener( ActionObject);
        //同一个ActionObject对象充当了监听器

        //本身充当监听器对象 registerButton.addActionListener(this);


        //匿名类对象ae充当监听器
        registerButton.addActionListener( ae);


        JTabbedPane jTabbedPane =new JTabbedPane();

        loginFrame.add(jTabbedPane ) ;
        jTabbedPane.add("登录页面",loginPanel);

        final Object[] columnName = {"姓名", "性别", "家庭地址"};
        Object[][] rowData = {{"tt", "男", "郑州"}, {"def", "女", "洛阳"},   {"ghj", "男", "开封"}, {"wer", "女", "新乡"}, {"cvb", "男", "南阳"},};
        JTable example3= new JTable (rowData,columnName);
        JScrollPane jScrollPane =new JScrollPane( example3);


        jTabbedPane.add("表格页面",  jScrollPane);


        JMenuBar mBar=new JMenuBar( );//菜单栏对象
        loginFrame.setJMenuBar(mBar);
        JMenu[] m={new JMenu("文件(F)"), new JMenu("编辑(E)")};

        for(int i=0;i<m.length;i++)
            mBar.add(m[i]); //菜单添加到菜单栏中

        loginFrame.setSize(280,300);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b=(JButton) e.getSource();//获取事件源对象
        if(e.getActionCommand().equals("登录")) {
            if (nameTextField.getText().equals("111111") &&
                    String.valueOf(passwordTextField.getPassword()).equals("111111")
            )
                JOptionPane.showMessageDialog(null, "登录成功!");

            else
                JOptionPane.showMessageDialog(null, "登录失败!");

        }
        else  new RegisterGui();


    }




    //内部类ActionClass充当ActionEvent的监听器
    class ActionClass implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton b=(JButton) e.getSource();//获取事件源对象
            e.getActionCommand();

            nameTextField.getText().equals("111111");//字符串
            passwordTextField.getPassword().equals("111111");//字符数组
            if(e.getActionCommand().equals("登录")) {
                if (nameTextField.getText().equals("111111") &&
                        String.valueOf(passwordTextField.getPassword()).equals("111111")
                )
                    JOptionPane.showMessageDialog(null, "登录成功!");

                else
                    JOptionPane.showMessageDialog(null, "登录失败!");

            }
            else  new RegisterGui();


        }
    }


    public static void main(String[] args) {
        new LoginFrame();
    }
}
