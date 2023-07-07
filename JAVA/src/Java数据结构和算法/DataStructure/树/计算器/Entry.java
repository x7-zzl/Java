package Java数据结构和算法.DataStructure.树.计算器;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 此类用于把算术表达式送入解析器
public class Entry {
    public static void main(String[] args) throws IOException {
        // 取得用户输入的表达式
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("请输入算术表达式:");
        String rawExpression = br.readLine();
        // 得到合法的算术表达式
        StringBuilder expression = new StringBuilder();
        for (int i = 0; i < rawExpression.length(); i++) {
            // 拿到表达式的每个字符
            char c = rawExpression.charAt(i);
            //System.out.print(c+",");

            if (Character.isDigit(c) || c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')' || c == '.') {
                //System.out.print(c);
                expression.append(c);
            } else {
                System.out.print(" " + c + "不是合法的算术表达式字符.");
                System.exit(0);
            }
        }

        // 送去解析
        Lexer p = new Lexer(expression.toString());
        //p.print();

        //
        Tree t = new Tree(p.getInfixList());
        try {
            System.out.println(t.evaluate());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}