package com.thinkermall.service;

import com.thinkermall.common.pojo.EasyUIDataGridResult;
import com.thinkermall.common.pojo.ItemAddResult;
import com.thinkermall.pojo.TbItem;

/**
 * 商品操作接口
 * Created by wjz on 2017/9/25.
 */
public interface ItemService {
    /**
     * 按照商品id查询商品
     *
     * @param itemId
     * @return
     */
    TbItem getItemById(Long itemId);

    /**
     * 商品列表查询
     *
     * @param pageNums 开始页
     * @param rows     查询行数
     * @return 封装的查询结果
     */
    EasyUIDataGridResult getItemList(int pageNums, int rows);

    /**
     * 添加商品
     *
     * @param item 商品
     * @param desc 商品描述
     * @return 返回商品添加状态是否成功
     */
    ItemAddResult addItem(TbItem item, String desc);
}
