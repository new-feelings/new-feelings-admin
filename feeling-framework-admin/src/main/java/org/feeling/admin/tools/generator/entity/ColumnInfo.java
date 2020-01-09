package org.feeling.admin.tools.generator.entity;

import lombok.Data;

/**
 * @author lyq on 2020-01-01 6:10 下午
 * @desc 字段信息
 */
@Data
public class ColumnInfo {

    /**
     * 字段名
     */
    private String columnName;

    /**
     * 字段类型
     */
    private String columnType;

    /**
     * 属性名
     */
    private String attrName;

    /**
     * 属性类型
     */
    private String attrType;

    /**
     * 列注释
     */
    private String columnComment;

    /**
     * 检索类型：模糊匹配/精确查询
     */
    private String searchType;

    /**
     * 是否作为列表页搜索条件
     */
    private Boolean enableListQuery;

    /**
     * 是否在列表显示
     */
    private Boolean enableListView;

    /**
     * 是否在表单页显示
     */
    private Boolean enableFormView;

    /**
     * 是否主键
     */
    private Boolean primaryKey;

}
