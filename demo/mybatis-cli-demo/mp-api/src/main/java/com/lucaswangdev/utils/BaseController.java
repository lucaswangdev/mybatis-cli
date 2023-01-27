package com.lucaswangdev.utils;

import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class BaseController {
    /**
     * logger
     */
    protected final Logger logger = LoggerFactory.getLogger(BaseController.class);

    /**
     * 响应请求分页数据
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    protected TableDataInfo getDataTable(List<?> list) {
        TableDataInfo resData = new TableDataInfo();
        resData.setRows(list);
        resData.setTotal(new PageInfo(list).getTotal());
        return resData;
    }
}