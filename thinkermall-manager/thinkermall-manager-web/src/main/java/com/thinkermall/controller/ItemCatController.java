package com.thinkermall.controller;

import com.thinkermall.common.pojo.EasyUITreeNode;
import com.thinkermall.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by wjz on 2017/9/26.
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

    @Autowired
    ItemCatService itemCatService;

    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUITreeNode> getItemCatList(@RequestParam(value = "id", defaultValue = "0") long id) {
        List<EasyUITreeNode> itemCatList = itemCatService.getItemCatList(id);
        return itemCatList;
    }
}
