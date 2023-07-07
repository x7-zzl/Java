package Java数据结构和算法.DataStructure.树.计算器;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

// 此类用于将算术表达式解析成包含操作数和操作符的链表,扮演分词器的角色
public class Lexer {
    private final List<String> list;// 用于存储中序表达式的链表

    public List<String> getInfixList() {
        return list;
    }

    public Lexer(String expression){
        list=new ArrayList<String>();

        // 使用正则表达式分词
        String regExp = "(\\d+(\\.*)\\d*)|(\\+)|(\\-)|(\\*)|(\\/)|(\\()|(\\))";

        Pattern pattern=Pattern.compile(regExp);
        Matcher matcher=pattern.matcher(expression);
        while(matcher.find()){
            list.add(matcher.group(0));
        }
    }

    public void print(){
        for(String str:list){
            System.out.println(str);
        }
    }
}