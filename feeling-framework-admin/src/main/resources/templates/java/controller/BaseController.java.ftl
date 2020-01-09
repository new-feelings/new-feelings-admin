package ${packageName}.${moduleName}.controller;

import org.common.controller.BaseController;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import ${packageName}.${moduleName}.entity.${tableInfo.className};
import ${packageName}.${moduleName}.service.I${tableInfo.className}Service;
import org.springframework.web.bind.annotation.*;

/**
  * @author ${author}
  * @create ${date}
*/
@RestController
@RequestMapping("/${tableInfo.classNameLower}s")
public class ${tableInfo.className}Controller extends BaseController<I${tableInfo.className}Service, ${tableInfo.className}> {

  @Override
  protected QueryWrapper createQueryWrapper(${tableInfo.className} ${tableInfo.classNameLower}) {
    QueryWrapper<${tableInfo.className}> wrapper = new QueryWrapper<>();
    return wrapper;
  }

}