package com.thinkermall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.thinkermall.common.pojo.EasyUIDataGridResult;
import com.thinkermall.common.pojo.ItemAddResult;
import com.thinkermall.common.utils.IDUtils;
import com.thinkermall.mapper.TbItemDescMapper;
import com.thinkermall.mapper.TbItemMapper;
import com.thinkermall.pojo.TbItem;
import com.thinkermall.pojo.TbItemDesc;
import com.thinkermall.pojo.TbItemExample;
import com.thinkermall.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 商品操作实现类
 * Created by wjz on 2017/9/25.
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper ItemMapper;
    @Autowired
    private TbItemDescMapper tbItemDescMapper;

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

    /**
     * 商品列表查询
     *
     * @param pageNums 开始页
     * @param rows     查询行数
     * @return 封装的查询结果
     */
    @Override
    public EasyUIDataGridResult getItemList(int pageNums, int rows) {
        PageHelper.startPage(pageNums, rows);
        TbItemExample example = new TbItemExample();
        List<TbItem> tbItemsList = ItemMapper.selectByExample(example);
        PageInfo<TbItem> pageInfo = new PageInfo<>(tbItemsList);
        EasyUIDataGridResult easyUIDataGridResult = new EasyUIDataGridResult();
        easyUIDataGridResult.setTotal(pageInfo.getTotal());
        easyUIDataGridResult.setRows(pageInfo.getList());
        return easyUIDataGridResult;
    }

    /**
     * 添加商品
     *
     * @param item 商品
     * @param desc 商品描述
     * @return 返回商品添加状态是否成功
     */
    @Override
    public ItemAddResult addItem(TbItem item, String desc) {
        //生成商品id 唯一的
        long itemId = IDUtils.genItemId();
        //生成创建时间
        Date date = new Date();
        //插入商品表
        item.setStatus((byte) 1);//商品状态，1-正常，2-下架，3-删除',
        item.setId(itemId);
        item.setCreated(date);
        item.setUpdated(date);
        ItemMapper.insert(item);
        //插入商品描述表
        TbItemDesc tbItemDesc = new TbItemDesc();
        tbItemDesc.setItemId(itemId);
        tbItemDesc.setItemDesc(desc);
        tbItemDesc.setCreated(date);
        tbItemDesc.setUpdated(date);
        tbItemDescMapper.insert(tbItemDesc);
        return ItemAddResult.ok();
    }
}
