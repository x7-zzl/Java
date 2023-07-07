package Java数据结构和算法.DataStructure.树.二叉树.二叉树计算器;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.*;

public class MyCalculator extends JFrame implements ActionListener, MouseListener {
    private String buttonNames[] = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "/", "0", ".", "*", "="};
    private JButton buttons[] = new JButton[buttonNames.length];//储存按钮的数组
    private JButton clear;
    private JTextField textField;
    private boolean isFirstNumber = true;//作为是不是第一个数字的标志
    private LinkStack stack = new LinkStack();//初始化一个运算符栈
    private LinkStack tempStack = new LinkStack();//储存后缀表达式的结果
    private LinkQueue zhongQueue = new LinkQueue();//初始化一个存中缀的队列
    private LinkQueue houQueue = new LinkQueue();//初始化一个存后缀的队列

    //构造方法
    public MyCalculator() {
        // TODO Auto-generated constructor stub
        init();
        this.setBackground(Color.LIGHT_GRAY);
        this.setTitle("计算器");
        // 在屏幕(500, 300)坐标处显示计算器
        this.setLocation(500, 300);
        // 允许修改计算器的大小
        this.setResizable(true);
        // 使计算器中各组件大小合适
        this.pack();
        this.setVisible(true);
        this.setBounds(400, 200, 320, 320);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //界面初始方法
    public void init() {
        Container c = getContentPane();
        c.setLayout(new BorderLayout(3, 5));//整体布局
        JPanel panel1 = new JPanel(new FlowLayout());
        textField = new JTextField(20);
        textField.setEditable(false);//不允许修改
        textField.setBackground(Color.WHITE);
        panel1.add(textField);
        clear = new JButton("C");
        clear.setBackground(Color.PINK);
        panel1.add(clear);
        clear.addActionListener(this);
        c.add("North", panel1);
        JPanel panel2 = new JPanel(new GridLayout(4, 4, 4, 4));
        for (int i = 0; i < 16; i++) {
            buttons[i] = new JButton(buttonNames[i]);
            buttons[i].setBackground(Color.white);
            panel2.add(buttons[i]);
            buttons[i].addActionListener(this);
            buttons[i].addMouseListener(this);
        }
        c.add("Center", panel2);
    }

    //事件监听
    @Override
    public void actionPerformed(ActionEvent a) {
        // TODO Auto-generated method stub
        //获取事件源的名字
        String bName = a.getActionCommand();
        if (bName.equals("C")) {//当事件源为clear键时
            doClear();
        } else if ("1234567890.".indexOf(bName) >= 0) {//当事件源为数字键时
            doNumber(bName);
        } else if (bName.equals("=")) {
            try {
                doAnswer();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            try {
                doYunsuan(bName);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    //响应=的指令
    public void doAnswer() throws Exception {
        zhongQueue.offer(textField.getText());
//		System.out.println(zhongQueue.length());
        int temp = zhongQueue.length();//因为这队列是动态的，所以只能用固定的长度值
        for (int i = 0; (zhongQueue != null) && i < temp; i++) {
            String c = (String) zhongQueue.poll();//从中缀表达式中出队第一个
            if (!c.equals("")) {
                if (isOpenParenthesis(c)) {
                    stack.push(c);//为开括号，压栈
                } else if (isCloseParenthesis(c)) {//为闭括号
                    String ac = (String) stack.pop();//弹出栈顶元素
                    while (!isOpenParenthesis(ac)) {//一直到开括号为止
                        houQueue.offer(ac);//添加到后缀表达式的队列
                        ac = (String) stack.pop();
                    }
                } else if (isOperator(c)) {//为运算符
                    if (!stack.isEmpty()) {//栈非空，取栈顶优先级高的运算符送往后缀表达式
                        String ac = (String) stack.pop();
                        while (ac != null && priority(ac) >= priority(c)) {
                            houQueue.offer(ac);
                            ac = (String) stack.pop();
                        }
                        if (ac != null) {//若最后一次取出的优先级低的操作符，重新压栈
                            stack.push(ac);
                        }
                    }
                    stack.push(c);
                } else {//为操作数，将其添加到后缀表达式的队列末尾
                    houQueue.offer(c);
                }
            }
        }
        while (!stack.isEmpty()) {//栈中剩余的所有操作符挨个进入后缀表达式
            houQueue.offer(stack.pop());
        }
        //到现在为止，已经将中缀表达式转换成后缀表达式，以链队形式存储
        //对后缀表达式进行求值计算

        int temp2 = houQueue.length();
        for (int i = 0; houQueue != null && i < temp2; i++) {
            String c = (String) houQueue.poll();//从后缀表达式中取出第一个
            if (isOperator(c)) {//当为操作符的时候
                double d2 = 0;
                double d1 = 0;
                if (tempStack.length() > 1) {
                    d2 = Double.parseDouble((String) tempStack.pop());
                    d1 = Double.parseDouble((String) tempStack.pop());
                }
                //取出两个操作数
//				double d2 = Double.valueOf(tempStack.pop().toString());
//				double d1 = Double.valueOf(tempStack.pop().toString());

                double d3 = 0;
                if (c.equals("+")) {
                    d3 = d2 + d1;
                } else if (c.equals("-")) {
                    d3 = d2 - d1;
                } else if (c.equals("*")) {
                    d3 = d2 * d1;
                } else if (c.equals("/")) {
                    d3 = d1 / d2;
                }
                tempStack.push(d3);
            } else {
                tempStack.push(c);
            }
        }
        textField.setText("" + tempStack.pop());//返回运算结果
    }

    //判断字符串是否为运算符
    public boolean isOperator(String c) {
        if (c.equals("+") || c.equals("*") || c.equals("/") || c.equals("-")) {
            return true;
        } else {
            return false;
        }
    }

    //判断字符是否为开括号，此计算器比价简单，此方法不需要写
    public boolean isOpenParenthesis(String c) {
        return "(".equals(c);
    }

    //判断字符是否为闭括号，此计算器比价简单，此方法不需要写
    public boolean isCloseParenthesis(String c) {
        return ")".equals(c);
    }

    //判断运算法的优先级
    public int priority(String c) {
        if (c.equals("*") || c.equals("/")) {
            return 2;
        } else if (c.equals("-") || c.equals("+")) {
            return 1;
        } else {
            return 0;
        }
    }

    //按到了数字键执行操作
    public void doNumber(String name) {
        if (isFirstNumber) {//如果是第一个数字
            textField.setText(name);
        } else if (name.equals(".") && textField.getText().indexOf(".") < 0) {//当前面没有小数点的时候添加()
            textField.setText(textField.getText() + name);
        } else if (!name.equals(".")) {
            textField.setText(textField.getText() + name);
        }
        isFirstNumber = false;//然后就不是第一个数字了
    }

    //按到清除键执行操作
    public void doClear() {
        textField.setText("");//文本区域置空
        zhongQueue.clear();//中缀表达式置空
        houQueue.clear();//后缀表达式置空
        tempStack.clear();//后缀栈结果置空
        stack.clear();//中间栈结果置空
        isFirstNumber = true;
    }

    //按到运算键执行操作
    public void doYunsuan(String name) throws Exception {
        if (textField.getText() != "" && "+-*/.=".indexOf(textField.getText()) < 0) {//如果此运算符之前是数字
            zhongQueue.offer(textField.getText());
            zhongQueue.offer(name);
//			 System.out.println(zhongQueue.length());
            textField.setText(name);
            isFirstNumber = true;
        }
    }

    //主方法
    public static void main(String[] args) {
        MyCalculator mc = new MyCalculator();
    }

    //以下是完善部分，可以不看
    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        JButton b = (JButton) e.getSource();
        b.setBackground(Color.cyan);
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        JButton b = (JButton) e.getSource();
        b.setBackground(Color.white);
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
    }
}

