package com.thinkermall.service;

import com.thinkermall.pojo.TbItem;

/**
 * 商品操作接口
 * Created by wjz on 2017/9/25.
 */
public interface ItemService {
    /**
     * 按照商品id查询商品
     * @param itemId
     * @return
     */
    TbItem getItemById(Long itemId);
}
