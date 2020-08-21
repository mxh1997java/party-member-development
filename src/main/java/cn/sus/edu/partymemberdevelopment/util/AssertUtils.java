package cn.sus.edu.partymemberdevelopment.util;

/**
 * 类描述: 断言工具类
 * @Author: XinHai.Ma
 * @Date: 2020/8/15 16:33
 */
public class AssertUtils {

    private AssertUtils() {}

    /**
     * 功能描述: 条件成立，抛异常
     * @Param: [flag, message]
     * @Return: void
     * @Author: XinHai.Ma
     * @Date: 2020/8/15 16:34
     */
    public static void assertTrue(boolean flag, String message) throws RuntimeException {
        if(flag) {
            throw new RuntimeException(message);
        }
    }

    /**
     * 功能描述: 条件不成立，抛异常
     * @Param: [flag, message]
     * @Return: void
     * @Author: XinHai.Ma
     * @Date: 2020/8/15 16:34
     */
    public static void assertFalse(boolean flag, String message) throws RuntimeException {
        if(!flag) {
            throw new RuntimeException(message);
        }
    }

}
