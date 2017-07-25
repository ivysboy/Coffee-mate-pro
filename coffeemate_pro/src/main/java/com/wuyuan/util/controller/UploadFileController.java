package com.wuyuan.util.controller;

import com.wuyuan.util.mapper.ArticlesMapper;
import com.wuyuan.util.module.ArticleDto;
import com.wuyuan.util.ServerSetting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by xuwuyuan on 2017/7/23.
 */
@RestController
@RequestMapping("/upload")
public class UploadFileController {

    private static final Logger log = LoggerFactory.getLogger(UploadFileController.class);

    @Autowired
    private ServerSetting serverSetting;

    @Autowired
    private ArticlesMapper articlesMapper;

    /**
     * 上传单个文件
     * @param upfile
     * @return
     */
    @RequestMapping(value = "/uploadImage", method = {RequestMethod.OPTIONS,RequestMethod.POST})
    public
    @ResponseBody
    Map<String,Object> uploadImage(@RequestParam("upfile") MultipartFile upfile,
                                   @RequestParam String articleId) {
        return saveFile(upfile, articleId);
    }

    private Map<String,Object> saveFile(MultipartFile file, String articleId){
        String name = UUID.randomUUID().toString();
        Map<String,Object> result = new HashMap<>();
        if (!file.isEmpty()) {
            try {
                String filename = file.getOriginalFilename();
                String ext = filename.substring(filename.lastIndexOf("."));
                name = name + ext;
                byte[] bytes = file.getBytes();
                File image = new File(serverSetting.getImageStorePath() + name);
                OutputStream outputStream = new FileOutputStream(image);
                BufferedOutputStream stream =
                        new BufferedOutputStream(outputStream);
                stream.write(bytes);
                stream.close();
                image.setReadable(true, false);

                ArticleDto article = new ArticleDto();
                article.setId(articleId);
                article.setImage(serverSetting.getImageContentPath() + name);
                articlesMapper.updateArticle(article);

                result.put("name", name);
                result.put("status","SUCCESS");
                result.put("url","images/"+name);
                result.put("title",name);
                result.put("original",name);
                result.put("readable", image.canRead());

                return result;
            } catch (Exception e) {
                result.put("errorMsg", "You failed to upload " + name + " => " + e.getMessage());
                result.put("status","FAIL");
                return result;
            }
        } else {
            result.put("errorMsg", "You failed to upload " + name + " because the file was empty.");
            result.put("status","FAIL");
            return result;
        }
    }

}
