package org.feeling.admin.tools.generator.utils;

import org.feeling.admin.tools.generator.entity.GeneratorInfo;
import org.feeling.admin.tools.generator.enums.TemplateTypeEnum;

import java.util.HashMap;

/**
 * @author lyq on 2020-01-01 7:11 下午
 * @desc
 */
public class GeneratorUtil {


    /**
     * Mysql数据类型与Java类型对照表
     */
    public static HashMap<String,String> TYPE_MAPPING = new HashMap<>();

    /**
     * 实体类模板位置
     */
    public static String ENTITY_TEMPLATE_LOCATION = "java/entity/BaseEntity.java.ftl";

    /**
     * mapper接口文件位置
     */
    public static String MAPPER_TEMPLATE_LOCATION = "java/mapper/BaseMapper.java.ftl";

    /**
     * mapper.xml文件位置
     */
    public static String MAPPERXML_TEMPLATE_LOCATION = "java/mapper/BaseMapper.xml.ftl";

    /**
     * service接口文件位置
     */
    public static String ISERVICE_TEMPLATE_LOCATION = "java/service/BaseService.java.ftl";

    /**
     * service文件位置
     */
    public static String SERVICE_TEMPLATE_LOCATION = "java/service/impl/BaseServiceImpl.java.ftl";

    /**
     * controller文件位置
     */
    public static String CONTROLLER_TEMPLATE_LOCATION = "java/controller/BaseController.java.ftl";

    /**
     * vue index文件位置
     */
    public static String VUEINDEX_TEMPLATE_LOCATION = "vue/index.vue.ftl";

    /**
     * vue form文件位置
     */
    public static String VUEFORM_TEMPLATE_LOCATION = "vue/form.vue.ftl";

    /**
     * vue js文件位置
     */
    public static String VUEJS_TEMPLATE_LOCATION = "vue/index.js.ftl";

    /**
     * JAVA包基础路径
     */
    private static final String BASE_JAVA_PATH = "code/java/";

    /**
     * vue包基础路径
     */
    private static final String BASE_VUE_PATH = "/code/vue/";

    static {
        TYPE_MAPPING.put("tinyint", "Boolean");
        TYPE_MAPPING.put("smallint", "Integer");
        TYPE_MAPPING.put("mediumint", "Integer");
        TYPE_MAPPING.put("int", "Integer");
        TYPE_MAPPING.put("integer", "Integer");
        TYPE_MAPPING.put("bigint", "Long");
        TYPE_MAPPING.put("float", "Float");
        TYPE_MAPPING.put("double", "Double");
        TYPE_MAPPING.put("decimal", "BigDecimal");
        TYPE_MAPPING.put("bit", "Boolean");
        TYPE_MAPPING.put("char", "String");
        TYPE_MAPPING.put("varchar", "String");
        TYPE_MAPPING.put("tinytext", "String");
        TYPE_MAPPING.put("text", "String");
        TYPE_MAPPING.put("mediumtext", "String");
        TYPE_MAPPING.put("longtext", "String");
        TYPE_MAPPING.put("time", "LocalTime");
        TYPE_MAPPING.put("date", "LocalDate");
        TYPE_MAPPING.put("datetime", "LocalDateTime");
        TYPE_MAPPING.put("timestamp", "LocalDateTime");
    }

    public static String getJavaFullPath(GeneratorInfo generator, String templateType) {
        String javaPath = BASE_JAVA_PATH + generator.getPackageName().replace('.','/') + "/" + generator.getModuleName();
        String className = generator.getTableInfo().getClassName();
        StringBuilder fullPath = new StringBuilder(javaPath);
        TemplateTypeEnum typeEnum = TemplateTypeEnum.valueOf(templateType.toUpperCase());
        switch (typeEnum) {
            case ENTITY:
                fullPath.append("/entity/" + className + ".java");
                break;
            case MAPPER:
                fullPath.append("/mappers/" + className + "Mapper.java");
                break;
            case MAPPERXML:
                fullPath.append("/mappers/" + className + "Mapper.xml");
                break;
            case SERVICE:
                fullPath.append("/service/I" + className + "Service.java");
                break;
            case SERVICEIMPL:
                fullPath.append("/service/impl/" + className + "Service.java");
                break;
            case CONTROLLER:
                fullPath.append("/controller/" + className + "Controller.java");
                break;
            default: break;
        }
        return fullPath.toString();
    }

    public static String getVueFullPath(GeneratorInfo generator, String templateType) {
        String className = generator.getTableInfo().getClassName();
        StringBuilder fullPath = new StringBuilder(BASE_VUE_PATH);
        TemplateTypeEnum typeEnum = TemplateTypeEnum.valueOf(templateType.toUpperCase());
        switch (typeEnum) {
            case VUE_INDEX:
                fullPath.append("/" + generator.getModuleName() +"/" + className.toLowerCase() + "/index.vue");
                break;
            case VUE_FORM:
                fullPath.append("/" + generator.getModuleName() +"/" + className.toLowerCase() + "/components/form.vue");
                break;
            case VUE_JS:
                fullPath.append("/api/" + generator.getModuleName() +"/" + className.toLowerCase() + "/index.js");
                break;
            default: break;
        }
        return fullPath.toString();
    }
}
