package com.thinkermall.service.impl;

import com.thinkermall.common.pojo.PictureResult;
import com.thinkermall.service.PictureService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by wjz on 2017/9/29.
 */
@Service
public class PictureServiceImpl implements PictureService {

    @Value("${PICTURE_SERVER_URL}")
    private String PICTURE_SERVER_URL;


    /**
     * 上传图片(只是测试。。可以用图片服务器来实现分布式图片服务器)
     *
     * @param picFile 前端图片上传参数
     * @return 返回dto信息
     */
    @Override
    public PictureResult uploadPic(MultipartFile picFile) {
        PictureResult result = new PictureResult();
        //判断图片是否为空
        if (picFile.isEmpty()) {
            result.setError(1);
            result.setMessage("图片为空");
            return result;
        }
        //取文件后缀名
        String originalFilename = picFile.getOriginalFilename();
        String extendName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        //判断是否是图片类型(这步可以在前端判断只能打开图片类型)
        if (!extendName.equals("jsp") && !extendName.equals("png") && !extendName.equals("jpeg")) {
            result.setError(1);
            result.setMessage("图片类型不符合规范");
        }
        String uuid = UUID.randomUUID().toString();
        String path = PICTURE_SERVER_URL + uuid + "." + extendName;
        try {
            picFile.transferTo(new File(path));
            result.setError(0);
            //????  图片url地址。。。
            result.setUrl("127.0.0.1:8080/images/" + uuid + "." + extendName);
        } catch (IOException e) {
            result.setError(1);
            result.setMessage("上传错误！");
            return result;
        }
        return result;
    }
}
