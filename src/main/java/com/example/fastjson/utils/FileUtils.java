package com.example.fastjson.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @ProjectName: fastjson
 * @Package: com.example.fastjson.utils
 * @ClassName: FileUtils
 * @Author: jgp
 * @Description: ${DESCRIPTION}
 * @Date: 2019/4/29 19:59
 * @Version: 1.0
 */
@Component
public class FileUtils {

    public  String upLoad(MultipartFile file , HttpServletRequest request){

        String dir = request.getServletContext().getRealPath("/upload");
        File fileDir = new File(dir);
        if (!fileDir.exists()){
            fileDir.mkdir();
        }
        String fileSuffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String fileNewName = fileDir+"/"+UUID.randomUUID().toString()+fileSuffix;
        File f = new File(fileNewName);
        try {
            file.transferTo(f);
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";
    }

}
