package zzlown;
//Clipboard类实现一种使用剪切/复制/粘贴操作传输数据的机制。
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;

/*
   操作类中，注意：Clipboard类的使用{Clipboard类实现一种使用剪切/复制/粘贴操作传输数据的机制。}
 */
public class WordsRepeated {
    public static void main(String[] args) throws AWTException {
        String str = "傻";// “要重复输出的话”
        Robot robot = new Robot();
        robot.delay(4000);// 预留出打开窗口的时间
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        String[] authors = str.split("[,]");// 字符串根据,分割
        for (int j = 0; j < 200; j++) {
            for (int i = 0; i < authors.length; i++) {
                String str1 = authors[i];
                Transferable text = new StringSelection(str1);
                clip.setContents(text, null);

                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                robot.delay(500);
                robot.keyPress(KeyEvent.VK_ENTER);
            }
        }
    }
}
