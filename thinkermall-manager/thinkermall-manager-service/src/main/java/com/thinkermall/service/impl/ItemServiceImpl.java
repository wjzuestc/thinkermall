package com.thinkermall.service.impl;

import com.thinkermall.mapper.TbItemMapper;
import com.thinkermall.pojo.TbItem;
import com.thinkermall.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 商品操作实现类
 * Created by wjz on 2017/9/25.
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper ItemMapper;
    /**
     * 按照商品id查询商品
     *
     * @param itemId
     * @return
     */
    @Override
    public TbItem getItemById(Long itemId) {
        //根据主键查询，也可以利用生成的TbItemExample拼装查询条件进行查询
        TbItem tbItem = ItemMapper.selectByPrimaryKey(itemId);
        return tbItem;
    }
}
