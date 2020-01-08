package org.common.result;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {
    private long total;
    private List<T> rows;

    public static PageResult success(List list) {
        PageResult result = new PageResult();
        result.setRows(list);
        result.setTotal(new PageInfo(list).getTotal());
        return result;
    }
}
