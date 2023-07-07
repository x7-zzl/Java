package 图形用户界面.teacher;

import javax.swing.*;
import java.awt.*;

public class RegisterGui{

    private  JFrame registerJFrame;
    private  JPanel registerJPanle;
    private  JLabel nameJLabel;
    private  JTextField nameJTextField;
    private  JLabel passJLabel;
    private  JPasswordField passJPasswordField;
    private  JButton tijiaoJButton=new JButton("提交") ;
    private  JButton resetJButton=new JButton( " 重设");
    private  JRadioButton sexJRadioButton[]=new JRadioButton[2];
    private  JLabel sexJLabel;
    private  JLabel favaireteJLabel;
    private  JCheckBox favaireteJCheckBox[]=new JCheckBox[6];
    private  JLabel pvovinceJLabel;
    private  JComboBox pvovinceJComboBox;
    private  JLabel commmentJLabel;
    private  JTextArea commmentJTextArea;

    public RegisterGui() {
        registerJFrame=new JFrame("注册界面");
        //registerJFrame.getContentPane().setBackground(Color.CYAN);
        //JFrame设置背景色的方法
        registerJPanle=new JPanel();
        registerJPanle.setPreferredSize(new Dimension(300,300));
        registerJPanle.setBackground(Color.cyan);
        registerJPanle.setLayout(new GridLayout(15,2));
        registerJFrame.add( registerJPanle);


        nameJLabel=new JLabel("用户名：");
        nameJLabel.setForeground(Color.red);
        nameJTextField=new JTextField(15);
        registerJPanle.add(nameJLabel);
        registerJPanle.add(nameJTextField);

        passJLabel=new JLabel("密    码：");
        passJPasswordField=new JPasswordField(15);
        registerJPanle.add(passJLabel);
        registerJPanle.add(passJPasswordField);

        String sex[]={"男","女"};
        sexJLabel=new JLabel("性    别：");
        registerJPanle.add( sexJLabel);

        ButtonGroup sexGroup=new ButtonGroup();
        for(int i=0;i<sexJRadioButton.length;i++) {
            sexJRadioButton[i] = new JRadioButton(sex[i]);
            sexGroup.add(sexJRadioButton[i]);
            registerJPanle.add(sexJRadioButton[i]);
            if(i!=sexJRadioButton.length-1)  registerJPanle.add( new JLabel("      "));
        }




        String fav[]={"小说","电影","逛街","学习","工作","美食"};
        sexJLabel=new JLabel("爱     好：");
        registerJPanle.add( sexJLabel);


        for(int i=0;i<favaireteJCheckBox.length;i++) {
            favaireteJCheckBox[i] = new JCheckBox(fav[i]);
            registerJPanle.add(favaireteJCheckBox[i]);
            if(i!=favaireteJCheckBox.length-1)  registerJPanle.add( new JLabel("      "));
        }


        String prov[]={"河南省","北京市","上海市","重庆市","天津市"};
        pvovinceJLabel= new JLabel("省份");
        registerJPanle.add( pvovinceJLabel);
        pvovinceJComboBox =new JComboBox(prov);
        registerJPanle.add(pvovinceJComboBox);


        commmentJLabel=new JLabel("评论") ;
        commmentJTextArea= new JTextArea(4,8);
        commmentJTextArea.setSize(20,10);
        registerJPanle.add(commmentJLabel);
        registerJPanle.add(commmentJTextArea);


        registerJPanle.add(tijiaoJButton);
        registerJPanle.add(resetJButton);



        registerJFrame.setSize(200,400);
        registerJFrame.setLocationRelativeTo(null);//屏幕中央
        registerJFrame.setVisible(true);
        registerJFrame.setResizable(false);// 不最大化
        registerJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new RegisterGui();
    }

    public Component getRegisterJPanle() {
        return registerJPanle;
    }
}
