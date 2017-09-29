package com.thinkermall.controller;

import com.thinkermall.common.pojo.PictureResult;
import com.thinkermall.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 图片上传controller
 * Created by wjz on 2017/9/29.
 */
@Controller
public class PictureController {

    @Autowired
    PictureService pictureService;

    @RequestMapping("/pic/upload")
    @ResponseBody
    public PictureResult uploadPic(MultipartFile uploadFile) {
        PictureResult result = pictureService.uploadPic(uploadFile);
        return result;
    }

}
