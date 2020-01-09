package ${packageName}.${moduleName}.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ${packageName}.${moduleName}.entity.${tableInfo.className};
import ${packageName}.${moduleName}.mapper.${tableInfo.className}Mapper;
import ${packageName}.${moduleName}.service.I${tableInfo.className}Service;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Primary;

/**
* @author ${author}
* @create ${date}
*/
@Service
@Primary
public class ${tableInfo.className}Service extends ServiceImpl<${tableInfo.className}Mapper, ${tableInfo.className}> implements I${tableInfo.className}Service{
}
