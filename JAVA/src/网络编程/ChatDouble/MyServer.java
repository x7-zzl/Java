package 网络编程.ChatDouble;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer extends JFrame implements ActionListener{
    JTextField t1;
    JTextArea area;
    JButton b1;
    JScrollPane js;
    JPanel panel;
    PrintWriter out;
    public MyServer(){
        area =new JTextArea();
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        js =new JScrollPane(area);
        t1 =new JTextField(20);
        b1 =new JButton("SEND");
        b1.addActionListener(this);
        panel =new JPanel();
        panel.add(t1);
        panel.add(b1);
        add(panel,"South");
        add(js,"Center");
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        setTitle("THE SERVER");
        setSize(400,300);
        setVisible(true);
        try{
            ServerSocket server = new ServerSocket(1680);
            Socket socket = server.accept();
            InputStreamReader in = new InputStreamReader(socket.getInputStream());
            BufferedReader sin=new BufferedReader(in);
            out=new PrintWriter(socket.getOutputStream(),true);
            while(true){
                String s=sin.readLine();
                area.append("@Client Said@: "+s+"\n");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()== b1){
            String st = t1.getText();
            area.append("#Server Said#: "+st+"\n");
            out.println(st);
            t1.setText("");
        }
    }
    public static void main(String[] args){
        MyServer msr = new MyServer();
    }
}