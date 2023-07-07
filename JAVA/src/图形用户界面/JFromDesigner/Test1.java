/*
 * Created by JFormDesigner on Sat Jan 01 16:31:07 CST 2022
 */

package 图形用户界面.JFromDesigner;

import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class Test1 extends JFrame {
    public Test1() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        ResourceBundle bundle = ResourceBundle.getBundle("JFormDesigner.form");
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout(3, 3));

        //---- button1 ----
        button1.setText(bundle.getString("button1.text"));
        contentPane.add(button1, BorderLayout.WEST);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
