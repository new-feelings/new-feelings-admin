package org.feeling.admin.tools.generator.service;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import freemarker.core.ParseException;
import freemarker.template.*;
import org.apache.commons.io.IOUtils;
import org.feeling.admin.tools.generator.dto.GeneratorQueryDTO;
import org.feeling.admin.tools.generator.entity.ColumnInfo;
import org.feeling.admin.tools.generator.entity.GeneratorInfo;
import org.feeling.admin.tools.generator.entity.TableInfo;
import org.feeling.admin.tools.generator.mapper.GeneratorMapper;
import org.feeling.admin.tools.generator.utils.GeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author lyq on 2020-01-01 6:49 下午
 * @desc
 */
@Service
public class GeneratorService {

    @Autowired
    private GeneratorMapper mapper;
    @Autowired
    private Configuration freeMarkerConfig;

    /**
     * 查询所有数据库
     * @return
     */
    public List<String> selectDatabases(){
        return mapper.selectDatabases();
    }

    /**
     * 查询执行数据库下的表信息
     * @param dto
     * @return
     */
    public List<TableInfo> selectTableList(GeneratorQueryDTO dto){
        return mapper.selectTableList(dto);
    }

    /**
     * 查询指定表的列信息
     * @param dto
     * @return
     */
    public List<ColumnInfo> selectColumnList(GeneratorQueryDTO dto){
        return mapper.selectColumnList(dto);
    }

    /**
     * 代码生成
     * @param generator
     * @return
     */
    public byte[] generate(GeneratorInfo generator) {
        buildInfo(generator);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
        Template template = null;
        try {
            // 实体类文件
            template = freeMarkerConfig.getTemplate(GeneratorUtil.ENTITY_TEMPLATE_LOCATION);
            String entity = FreeMarkerTemplateUtils.processTemplateIntoString(template, generator);
            zipOutputStream.putNextEntry(new ZipEntry(GeneratorUtil.getJavaFullPath(generator,"entity")));
            IOUtils.write(entity, zipOutputStream, "utf-8");
            // mapper接口文件
            template = freeMarkerConfig.getTemplate(GeneratorUtil.MAPPER_TEMPLATE_LOCATION);
            String mapper = FreeMarkerTemplateUtils.processTemplateIntoString(template, generator);
            zipOutputStream.putNextEntry(new ZipEntry(GeneratorUtil.getJavaFullPath(generator, "mapper")));
            IOUtils.write(mapper, zipOutputStream, "utf-8");
            // mapper.xml文件
            template = freeMarkerConfig.getTemplate(GeneratorUtil.MAPPERXML_TEMPLATE_LOCATION);
            String mapperXml = FreeMarkerTemplateUtils.processTemplateIntoString(template, generator);
            zipOutputStream.putNextEntry(new ZipEntry(GeneratorUtil.getJavaFullPath(generator,"mapperXml")));
            IOUtils.write(mapperXml, zipOutputStream, "utf-8");
            // service接口文件
            template = freeMarkerConfig.getTemplate(GeneratorUtil.ISERVICE_TEMPLATE_LOCATION);
            String service = FreeMarkerTemplateUtils.processTemplateIntoString(template, generator);
            zipOutputStream.putNextEntry(new ZipEntry(GeneratorUtil.getJavaFullPath(generator,"service")));
            IOUtils.write(service, zipOutputStream, "utf-8");
            // service文件
            template = freeMarkerConfig.getTemplate(GeneratorUtil.SERVICE_TEMPLATE_LOCATION);
            String serviceImpl = FreeMarkerTemplateUtils.processTemplateIntoString(template, generator);
            zipOutputStream.putNextEntry(new ZipEntry(GeneratorUtil.getJavaFullPath(generator,"serviceImpl")));
            IOUtils.write(serviceImpl, zipOutputStream, "utf-8");
            // controller文件
            template = freeMarkerConfig.getTemplate(GeneratorUtil.CONTROLLER_TEMPLATE_LOCATION);
            String controller = FreeMarkerTemplateUtils.processTemplateIntoString(template, generator);
            zipOutputStream.putNextEntry(new ZipEntry(GeneratorUtil.getJavaFullPath(generator,"controller")));
            IOUtils.write(controller, zipOutputStream, "utf-8");
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (MalformedTemplateNameException e) {
            e.printStackTrace();
        } catch (TemplateNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } finally {
            try {
                zipOutputStream.closeEntry();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return outputStream.toByteArray();
    }

    /**
     * 构建信息
     * @param generatorInfo
     */
    private void buildInfo(GeneratorInfo generatorInfo) {
        generatorInfo.setDate(LocalDateTime.now());
        //构建TableInfo信息
        buildTableInfo(generatorInfo.getTableInfo());
    }

    /**
     * 构建表信息
     * @param tableInfo
     */
    private void buildTableInfo(TableInfo tableInfo) {
        String className = generateClassName(tableInfo.getTableName());
        tableInfo.setClassName(className);
        tableInfo.setClassNameLower(className.toLowerCase());
        buildColumnInfo(tableInfo.getColumnList());
    }

    /**
     * 构建列信息
     * @param columnList
     */
    private void buildColumnInfo(List<ColumnInfo> columnList) {
        columnList.forEach(column -> {
            column.setAttrName(generateAttrName(column.getColumnName()));
            column.setAttrType(GeneratorUtil.TYPE_MAPPING.get(column.getColumnType()));
        });
    }

    /**
     * 根据字段名生成属性名称
     * @param columnName
     * @return
     */
    private String generateAttrName(String columnName) {
        String attrName = StringUtils.underlineToCamel(columnName);
        if(Character.isLowerCase(attrName.charAt(0))) {
            return attrName;
        } else {
            return (new StringBuilder()).append(Character.toLowerCase(attrName.charAt(0))).append(attrName.substring(1)).toString();
        }
    }

    /**
     * 根据表名生成类名
     * @param tableName
     * @return
     */
    private String generateClassName(String tableName) {
        // 去除前缀
        tableName = tableName.substring(tableName.indexOf('_')+1);
        String camel = StringUtils.underlineToCamel(tableName);
        return StringUtils.upperFirst(camel);
    }
}
