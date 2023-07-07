package 网络编程.ChatDouble;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MyClient extends JFrame implements ActionListener{
    JTextField t1;
    JTextArea area;
    JButton b1;
    PrintWriter out;
    public MyClient(){
        t1 =new JTextField(20);
        area =new JTextArea();
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        JPanel panel1=new JPanel();
        JScrollPane js=new JScrollPane(area);
        add(js,"Center");
        b1 =new JButton("SEND");
        b1.addActionListener(this);
        panel1.add(t1);
        panel1.add(b1);
        add(panel1,"South");
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        setTitle("THE CLIENT");
        setSize(400,300);
        setVisible(true);
        try{
            Socket socket=new Socket("127.0.0.1",1680);
            out=new PrintWriter(socket.getOutputStream(),true);
            InputStreamReader in = new InputStreamReader(socket.getInputStream());
            BufferedReader sin=new BufferedReader(in);
            String s;
            while(true){
                s=sin.readLine();
                area.append("#Server Said#: "+s+"\n");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()== b1){
            area.append("@Client Said@: "+ t1.getText()+"\n");
            out.println(t1.getText());
            t1.setText("");
        }
    }
    public static void main(String[] args){
        MyClient mct = new MyClient();
    }
}