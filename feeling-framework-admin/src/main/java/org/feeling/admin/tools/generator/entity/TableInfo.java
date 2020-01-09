package org.feeling.admin.tools.generator.entity;

import lombok.Data;

import java.util.List;

/**
 * @author lyq on 2020-01-01 6:12 下午
 * @desc 表信息
 */
@Data
public class TableInfo {

    /**
     * 数据库名称
     */
    private String database;

    /**
     * 表名称
     */
    private String tableName;

    /**
     * 表对应类名
     */
    private String className;

    /**
     * 表对应类名小写形式，用于controller构建restful url
     */
    private String classNameLower;

    /**
     * 存储引擎类型
     */
    private String tableEngine;

    /**
     *
     */
    private String primaryKey;

    /**
     * 字段
     */
    private List<ColumnInfo> columnList;

}
