package cn.sus.edu.partymemberdevelopment.util;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 类描述: 接口响应封装工具类
 * @Author: XinHai.Ma
 * @Date: 2020/8/15 15:30
 */
public class ResponseUtils {

    private ResponseUtils() {}

    private static Map<String, Object> createResponse() {
        return new LinkedHashMap<>(4);
    }


    /**
     * 功能描述: 分页查询成功响应结果
     * @Param: [message, data, total]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: XinHai.Ma
     * @Date: 2020/8/15 15:26
     */
    public static Map<String, Object> getSuccess(String message, Object data, long total) {
        Map<String, Object> response = createResponse();
        response.put("code", 200);
        response.put("message", message);
        response.put("data", data);
        response.put("total", total);
        return response;
    }


    /**
     * 功能描述: 包含message和data的成功响应结果
     * @Param: [message, data]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: XinHai.Ma
     * @Date: 2020/8/15 15:26
     */
    public static Map<String, Object> getSuccess(String message, Object data) {
        Map<String, Object> response = createResponse();
        response.put("code", 200);
        response.put("message", message);
        response.put("data", data);
        return response;
    }


    /**
     * 功能描述: 只包含message的成功响应结果
     * @Param: [message]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: XinHai.Ma
     * @Date: 2020/8/15 15:27
     */
    public static Map<String, Object> getSuccess(String message) {
        Map<String, Object> response = createResponse();
        response.put("code", 200);
        response.put("message", message);
        return response;
    }

    /**
     * 功能描述: 只包含message的失败响应结果
     * @Param: [message]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: XinHai.Ma
     * @Date: 2020/8/15 15:27
     */
    public static Map<String, Object> getFailure(String message) {
        Map<String, Object> response = createResponse();
        response.put("code", 500);
        response.put("message", message);
        return response;
    }


    /**
     * 功能描述: 包含code和message的失败响应结果
     * @Param: [code, message]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: XinHai.Ma
     * @Date: 2020/8/15 15:29
     */
    public static Map<String, Object> getFailure(String code, String message) {
        Map<String, Object> response = createResponse();
        response.put("code", code);
        response.put("message", message);
        return response;
    }

}
