package Util;

import org.junit.Assert;
import org.junit.Test;
import util.DbUtil;

public class DButilTest {
    @Test
    public void test(){
        Assert.assertNotNull(DbUtil.getConnection());
        System.out.println("完成数据库连接测试");
    }
}
