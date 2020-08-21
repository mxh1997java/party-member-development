package cn.sus.edu.partymemberdevelopment.configuration.exception;

import cn.sus.edu.partymemberdevelopment.util.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 功能描述: 异常处理器
 * @Author: XinHai.Ma
 * @Date: 2020/8/15 15:43
 */
@ControllerAdvice(annotations = {RestController.class})
public class BaseExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(BaseExceptionHandler.class);

    /**
     * 处理空指针的异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Map<String, Object> nullPointerExceptionHandler(NullPointerException e){
        logger.error("发生空指针异常! 原因是: {}", e);
        Map<String, Object> response = ResponseUtils.getFailure("空指针异常:" + e.getMessage());
        return response;
    }

    /**
     * 处理运行时异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Map<String, Object> runtimeExceptionHandler(RuntimeException e) {
        logger.error("发生运行时异常! 原因:", e);
        Map<String, Object> response = ResponseUtils.getFailure("运行时异常: " + e.getMessage());
        return response;
    }

}
