package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping(value = "/upload")
public class UploadController{

    @RequestMapping(value = "/editormd", method = RequestMethod.POST)
    @ResponseBody
    public EditormdUploadResult handleFileUpload(@RequestParam("guid") String name,
                                                 @RequestParam("editormd-image-file") MultipartFile file) {
        EditormdUploadResult result = new EditormdUploadResult();
        if (!file.isEmpty()) {
            try {
                result.setSuccess(1);
                result.setUrl(uploadFile(file, UUID.randomUUID().toString(),""));

                return result;
            } catch (Exception e) {
                result.setSuccess(0);
                result.setMessage("图片上传失败！("+e.getMessage()+")");
                return result;
            }

        } else {
            return result;
        }
    }


    /**
     * 获取文件的后缀名
     *
     * @param file
     * @return
     */
    public static String getSuffix(MultipartFile file) {
        return file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
    }

    /**
     * 上传文件
     * @param file       要上传的文件
     * @param newName    文件的新名字
     * @param folderAdd  static下的子级目录，如果不存在，将创建目录。目录后面要加'/'
     * @return
     */
    public static String uploadFile(MultipartFile file, String newName, String folderAdd) {
        File mulu = null;
        if(folderAdd != ""){
            //看看有木有这个目录
            try{
                mulu = new File(ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/" + folderAdd);
                if(!mulu.exists()){
                    System.out.println("目录不存在");
                    mulu.mkdirs();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        String uploadPath = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/" + folderAdd;
        File newFile = new File(uploadPath + newName + getSuffix(file));
        try {
            file.transferTo(newFile);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return folderAdd + newName + getSuffix(file);
    }


}
