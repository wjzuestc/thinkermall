package com.thinkermall.controller;

import com.thinkermall.common.pojo.EasyUIDataGridResult;
import com.thinkermall.common.pojo.ItemAddResult;
import com.thinkermall.pojo.TbItem;
import com.thinkermall.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 返回商品查询列表，并分页
     * /item/list?page=1&rows=30
     *
     * @param page 前端get格式
     * @param rows
     * @return
     */
    @RequestMapping("/item/list")
    @ResponseBody
    public EasyUIDataGridResult getItemList(@RequestParam Integer page, @RequestParam Integer rows) {
        EasyUIDataGridResult itemList = itemService.getItemList(page, rows);
        return itemList;
    }

    /**
     * 添加商品
     *
     * @param item 其字段是跟前端一一对应的
     * @param desc
     * @return
     */
    @RequestMapping(value = "/item/save", method = RequestMethod.POST)
    @ResponseBody
    public ItemAddResult addItem(TbItem item, String desc) {
        ItemAddResult itemAddResult = itemService.addItem(item, desc);
        return itemAddResult;
    }

}
