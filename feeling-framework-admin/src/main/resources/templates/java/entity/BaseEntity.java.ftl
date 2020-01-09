package ${packageName}.${moduleName}.domain;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.common.entity.BaseEntity;

/**
* @author ${author}
* @Date ${date}
*/
@TableName("${tableInfo.tableName}")
@Data
public class ${tableInfo.className} extends BaseEntity<${tableInfo.className}> {

    <#list tableInfo.columnList as column>
    /**
    * ${column.columnComment}
    */
    <#if column.primaryKey>
    @TableId
    </#if>
    @TableField("${column.columnName}")
    private ${column.attrType} ${column.attrName};
    </#list>
}