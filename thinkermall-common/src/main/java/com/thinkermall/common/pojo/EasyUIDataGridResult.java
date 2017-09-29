package com.thinkermall.common.pojo;

import java.util.List;

/**
 * 包装前端easyui所需的数据
 * 数据格式：{total:”2”,rows:[{“id”:”1”,”name”,”张三”},{“id”:”2”,”name”,”李四”}]}
 * Created by wjz on 2017/9/26.
 */
public class EasyUIDataGridResult {

    private long total;
    private List<?> rows;

    public EasyUIDataGridResult() {
    }

    public EasyUIDataGridResult(long total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
