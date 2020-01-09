package org.feeling.admin.tools.generator.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author lyq on 2020-01-01 6:14 下午
 * @desc 生成信息
 */
@Data
public class GeneratorInfo {

    /**
     * 包名
     */
    private String packageName;

    /**
     * 模块名称
     */
    private String moduleName;

    /**
     * 作者
     */
    private String author;

    /**
     * 前端样式：list/tree
     */
    private String viewType;

    /**
     * 是否生成Form组件
     */
    private Boolean enableForm;

    /**
     * 表信息
     */
    private TableInfo tableInfo;

    /**
     * 代码生成日期
     */
    private LocalDateTime date;

}
