package ${packageName}.${moduleName}.mapper;

import ${packageName}.${moduleName}.entity.${tableInfo.className};
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author ${author}
 * @Date ${date}
 */
@Repository
public interface ${tableInfo.className}Mapper extends BaseMapper<${tableInfo.className}> {
}