<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${packageName}.${moduleName}.mapper.${tableInfo.className}Mapper">

    <!-- 基本列 -->
    <sql id="baseColumns">
        <#list tableInfo.columnList as column>
        ${column.columnName}<#if column_index != tableInfo.columnList?size-1>,</#if>
        </#list>
    </sql>

    <!-- 基础映射 -->
    <resultMap id="BaseResultMap" type="${packageName}.${moduleName}.entity.${tableInfo.className}">
    <#list tableInfo.columnList as column>
        <#if column.primaryKey>
        <id column="${column.columnName}" jdbcType="${column.columnType}" property="${column.attrName}"/>
        <#else>
        <result column="${column.columnName}" jdbcType="${column.columnType}" property="${column.attrName}"/>
        </#if>
    </#list>
    </resultMap>

</mapper>