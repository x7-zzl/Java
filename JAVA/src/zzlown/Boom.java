package zzlown;

import java.awt.*;
import java.awt.datatransfer.Clipboard; //Clipboard类实现一种使用剪切/复制/粘贴操作传输数据的机制。
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
public class Boom {
    public static void main(String[] args) throws AWTException {
        String sentence = "[旺柴][旺柴][旺柴]";// 定义要发送的话
        Robot robot = new Robot();// 创建Robot对象（机器人）
        robot.delay(3000);// 延迟三秒，主要是为了预留出打开窗口的时间，括号内的单位为毫秒
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        // 字符串根据,分割
        String[] authors = sentence.split("[,]");
        for (int j = 0; j < 70; j++) {//循环次数
            for (String txt : authors) {
                Transferable tText = new StringSelection(txt);
                clip.setContents(tText, null);
                // 按下了ctrl+v，完成粘贴功能
                robot.keyPress(KeyEvent.VK_CONTROL);// 按下Control键
                robot.keyPress(KeyEvent.VK_V);// 按下V键
                robot.keyRelease(KeyEvent.VK_CONTROL);// 释放ctrl按键
                robot.delay(500);// 延迟一秒再发送
                robot.keyPress(KeyEvent.VK_ENTER);// 回车
            }
        }
    }
}
