package org.feeling.admin.tools.generator.mapper;

import org.feeling.admin.tools.generator.dto.GeneratorQueryDTO;
import org.feeling.admin.tools.generator.entity.ColumnInfo;
import org.feeling.admin.tools.generator.entity.TableInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lyq
 */
@Repository
public interface GeneratorMapper {

    /**
     * 查询所有数据库
     * @return
     */
    List<String> selectDatabases();

    /**
     * 查询表信息
     * @param dto
     * @return
     */
    List<TableInfo> selectTableList(GeneratorQueryDTO dto);

    /**
     * 查询表详细信息
     * @param dto
     * @return
     */
    List<ColumnInfo> selectColumnList(GeneratorQueryDTO dto);

}
