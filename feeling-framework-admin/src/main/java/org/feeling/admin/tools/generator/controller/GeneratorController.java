package org.feeling.admin.tools.generator.controller;

import com.baomidou.mybatisplus.extension.api.R;
import org.feeling.admin.tools.generator.dto.GeneratorQueryDTO;
import org.feeling.admin.tools.generator.entity.ColumnInfo;
import org.feeling.admin.tools.generator.entity.GeneratorInfo;
import org.feeling.admin.tools.generator.entity.TableInfo;
import org.feeling.admin.tools.generator.service.GeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author lyq on 2020-01-01 6:47 下午
 * @desc
 */
@RestController
@RequestMapping("/generator")
public class GeneratorController {

    @Autowired
    private GeneratorService service;

    @GetMapping("/databases")
    public R getDatabases(){
        List<String> databases = service.selectDatabases();
        return R.ok(databases);
    }

    @GetMapping("/tables")
    public R getTableList(GeneratorQueryDTO dto){
        List<TableInfo> tableInfos = service.selectTableList(dto);
        return R.ok(tableInfos);
    }

    @GetMapping("/columns")
    public R getColumnList(GeneratorQueryDTO dto){
        List<ColumnInfo> columnInfos = service.selectColumnList(dto);
        return R.ok(columnInfos);
    }

    @PostMapping("/generate")
    public byte[] generate(@RequestBody GeneratorInfo generatorInfo){
        return service.generate(generatorInfo);
    }

}
