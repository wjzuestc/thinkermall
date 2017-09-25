package com.thinkermall.controller;

import com.thinkermall.pojo.TbItem;
import com.thinkermall.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 商品查询controller
 * Created by wjz on 2017/9/25.
 */
@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;

    /**
     * 按照商品id查询数据，返回json数据
     *
     * @return
     */
    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable Long itemId) {
        TbItem item = itemService.getItemById(itemId);
        return item;
    }
}
