package com.thinkermall.service.impl;

import com.thinkermall.common.pojo.EasyUITreeNode;
import com.thinkermall.mapper.TbItemCatMapper;
import com.thinkermall.pojo.TbItemCat;
import com.thinkermall.pojo.TbItemCatExample;
import com.thinkermall.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wjz on 2017/9/26.
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    /**
     * 返回easyui的类目树
     *
     * @param parentId
     * @return
     */
    @Override
    public List<EasyUITreeNode> getItemCatList(long parentId) {
        //设置条件
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        //执行查询
        List<TbItemCat> tbItemCatsList = tbItemCatMapper.selectByExample(example);
        List<EasyUITreeNode> easyUITreeNodeList = new ArrayList<>();
        for (TbItemCat tbItemCat : tbItemCatsList) {
            EasyUITreeNode easyUITreeNode = new EasyUITreeNode();
            easyUITreeNode.setId(tbItemCat.getId());
            easyUITreeNode.setText(tbItemCat.getName());
            easyUITreeNode.setState(tbItemCat.getIsParent() ? "closed" : "open");
            easyUITreeNodeList.add(easyUITreeNode);
        }
        return easyUITreeNodeList;
    }
}
