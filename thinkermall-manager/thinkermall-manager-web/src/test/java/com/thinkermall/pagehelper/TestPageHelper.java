package com.thinkermall.pagehelper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.thinkermall.mapper.TbItemMapper;
import com.thinkermall.pojo.TbItem;
import com.thinkermall.pojo.TbItemExample;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 测试分页查询
 * Created by wjz on 2017/9/26.
 */
public class TestPageHelper {

    @Test
    public void testPageHelper() {
        //加载配置文件，执行spring容器，可以采用spring-test来测试
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*");
        TbItemMapper tbItemMapper = applicationContext.getBean(TbItemMapper.class);
        //设置分页拦截器（相当于改变了sql语句）
        PageHelper.startPage(1, 30);
        //执行查询
        TbItemExample example = new TbItemExample();
        List<TbItem> tbItems = tbItemMapper.selectByExample(example);
        //获得分页信息  返回的tbItem也是被List的子类封装成page
        for (TbItem tbitem : tbItems) {
            System.out.println(tbitem);
        }
        PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(tbItems);
        long total = pageInfo.getTotal();
        System.out.println(total);
        System.out.println(pageInfo.getList());

    }
}
