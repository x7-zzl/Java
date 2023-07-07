package 网络编程.ChatDouble;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatFrame extends JFrame implements ActionListener{

    JTextField tf;
    JTextArea ta;
    JScrollPane sp;
    JButton send;
    JPanel p;
    int port;
    String s="";
    String myID;
    Date date;
    ServerSocket server;
    Socket mySocket;
    BufferedReader is;
    PrintWriter os;
    String line;

    public ChatFrame(String ID, String remoteID, String IP, int port, boolean isServer)
    {
        super(ID);
        myID = ID;
        this.port = port;
        ta = new JTextArea();
        ta.setEditable(false);
        sp = new JScrollPane(ta);
        this.setSize(330,400);
        this.setResizable(false);
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e)
        {
            System.out.println("UI error");
        }
        this.getContentPane().add(sp,"Center");
        p = new JPanel();
        this.getContentPane().add(p,"South");
        send = new JButton("发送");
        tf = new JTextField(20);
        tf.requestFocus();
        p.add(tf);
        p.add(send);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        send.addActionListener(this);
        tf.addActionListener(this);
        if(isServer)
        {
            try
            {
                server=null;
                try
                {
                    server=new ServerSocket(port);
                }
                catch(Exception e)
                {
                    System.out.println("can not listen to:"+e);
                }
                mySocket=null;
                try
                {
                    mySocket=server.accept();
                }
                catch(Exception e)
                {
                    System.out.println("Error:"+e);
                }
                is = new BufferedReader(new
                        InputStreamReader(mySocket.getInputStream()));
                os = new PrintWriter(mySocket.getOutputStream());
            }
            catch(Exception e)
            {
                System.out.println("Error:in server client socket"+e);
            }
        }
        else
        {
            try
            {
                mySocket=new Socket(IP,port);
                os = new PrintWriter(mySocket.getOutputStream());
                is = new BufferedReader(new
                        InputStreamReader(mySocket.getInputStream()));
            }
            catch(Exception e)
            {
                System.out.println("Error:in Client Socket"+e);
            }
        }
        while(true)
        {
            try
            {
                line = is.readLine();
                date = new Date();
                SimpleDateFormat formatter = new
                        SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String currentTime = formatter.format(date);
                s+=currentTime+""+remoteID+"说:\n"+line+"\n";
                ta.setText(s);
            }
            catch(Exception e)
            {
                System.out.println("Error:in receive remote information"+e);
            }
        }
    }
    public void actionPerformed(ActionEvent e)
    {
        date=new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = formatter.format(date);
        s+=currentTime+""+myID+"说:\n"+tf.getText()+"\n";
        ta.setText(s);
        os.println(tf.getText());
        os.flush();
        tf.setText("");
        tf.requestFocus();
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
}
