package com.thinkermall.service;

import com.thinkermall.common.pojo.PictureResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * 图片上传service 可以用FastDFS来做分布式图片服务器
 * Created by wjz on 2017/9/29.
 */
public interface PictureService {

    /**
     * 上传图片
     *
     * @param picFile 前端图片上传参数
     * @return 返回dto信息
     */
    PictureResult uploadPic(MultipartFile picFile);
}
