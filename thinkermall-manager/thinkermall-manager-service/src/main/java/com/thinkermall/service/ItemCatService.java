package com.thinkermall.service;

import com.thinkermall.common.pojo.EasyUITreeNode;

import java.util.List;

/**
 * 类目选择
 * Created by wjz on 2017/9/26.
 */
public interface ItemCatService {
    /**
     * 返回easyui的类目树
     *
     * @param parentId
     * @return
     */
    List<EasyUITreeNode> getItemCatList(long parentId);
}
