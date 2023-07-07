package 加减法口算习题.JUnit;

import org.junit.Assert;
import org.junit.Test;

public class CaclulatorTest {


    //导入测试
    @Test
    //测试add方法
    public void addTest() {
        Caculator c = new Caculator();
        int result = c.add(1, 2);

        //预期结果是3，与结果进行比较
        Assert.assertEquals(3, result);

    }
}
