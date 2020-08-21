package cn.sus.edu.partymemberdevelopment.controller;

import cn.sus.edu.partymemberdevelopment.configuration.annotation.LoginRequired;
import cn.sus.edu.partymemberdevelopment.util.AssertUtils;
import cn.sus.edu.partymemberdevelopment.util.ResponseUtils;
import cn.sus.edu.partymemberdevelopment.util.WorldUtils;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述: 文件操作控制器
 * @Author: XinHai.Ma
 * @Date: 2020/8/16 12:53
 */
@Api(tags = "文件接口文档")
@CrossOrigin
@RequestMapping("/file")
@RestController
public class FileController {

    private final static Logger logger = LoggerFactory.getLogger(FileController.class);

    @Value("${upload_file_path}")
    String upload_file_path;

    @Value("${download_file_path}")
    String download_file_path;

    @Value("${template_path}")
    String template_path;

    /**
     * 功能描述: 导出world
     * @Param: [fileType, params]
     * @Return: void
     * @Author: XinHai.Ma
     * @Date: 2020/8/16 12:48
     */
    @LoginRequired
    @RequestMapping(value = "/exportWorld", method = RequestMethod.GET)
    public void exportWorld(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>(6);
        map.put("title", "测试文档");
        map.put("name", "马鑫海");
        map.put("age", "23");
        map.put("sex", "男");
        map.put("address", "山西省阳城县");
        map.put("dateTime", "2020-08-17");
        WorldUtils.exportDoc(map, "templates/maxinhai.ftl", template_path, "测试模板", response);
    }


    /**
     * 功能描述: 上传文件
     * @Param: [file]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: XinHai.Ma
     * @Date: 2020/8/16 13:14
     */
    @LoginRequired
    @RequestMapping(value = "/uploadFile", method = RequestMethod.GET)
    public Map<String, Object> uploadFile(@RequestParam("file") MultipartFile file) throws RuntimeException {
        AssertUtils.assertTrue(file.isEmpty(), "上传失败!请选择文件");
        String fileName = file.getOriginalFilename();
        File dest = new File(upload_file_path + fileName);
        try {
            file.transferTo(dest);
            logger.info("文件: {}, 上传成功!", fileName);
        } catch (IOException e) {
            logger.error(e.toString(), e);
        }
        return ResponseUtils.getSuccess("上传成功");
    }


    /**
     * 功能描述: 下载文件
     * @Param: [filePath, response]
     * @Return: void
     * @Author: XinHai.Ma
     * @Date: 2020/8/16 13:13
     */
    @LoginRequired
    @RequestMapping(value = "/downloadFile", method = RequestMethod.GET)
    public void downloadFile(@RequestParam("fileName") String fileName, HttpServletResponse response) throws RuntimeException {
        File file = new File(download_file_path + fileName);
        if(file.exists()) {
            response.setHeader("content-type", "application/octet-stream");
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);

            byte[] buffer = new byte[1024];
            FileInputStream fileInputStream = null;
            OutputStream outputStream = null;
            BufferedInputStream bufferedInputStream = null;

            try {
                fileInputStream = new FileInputStream(file);
                bufferedInputStream = new BufferedInputStream(fileInputStream);
                outputStream = response.getOutputStream();
                int index = bufferedInputStream.read(buffer);
                while (index != -1) {
                    outputStream.write(buffer, 0, index);
                    index = bufferedInputStream.read(buffer);
                }
                logger.info("Download the file successfully!");
            } catch (IOException e) {
                throw new RuntimeException("文件下载失败!");
            } finally {
                try {
                    if(bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if(fileInputStream != null) {
                        fileInputStream.close();
                    }
                } catch (IOException e) {
                    throw new RuntimeException("bufferedInputStream或fileInputStream无法正常关闭!");
                }
            }
        }
    }


}
