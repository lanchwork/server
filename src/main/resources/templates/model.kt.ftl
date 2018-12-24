package ${package.Entity}

<#list table.importPackages as pkg>
import ${pkg}
</#list>

/**
 * ${table.comment}
 * @author ${author}
 * @since ${date}
 */
<#if table.convert>
@TableName("${table.name}")
</#if>
data class ${entity}(
<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>
    <#if field.keyFlag>
        <#assign keyPropertyName="${field.propertyName}"/>
    </#if>

    <#if field.comment!?length gt 0>
    /**
     * ${field.comment}
     */
    </#if>
    <#if field.keyFlag>
    <#-- 主键 -->
        <#if field.keyIdentityFlag>
    @TableId(value = "${field.name}", type = IdType.AUTO)
        <#elseif idType ??>
    @TableId(value = "${field.name}", type = IdType.${idType})
        <#elseif field.convert>
    @TableId("${field.name}")
        </#if>
    <#-- 普通字段 -->
    <#elseif field.fill??>
    <#-- -----   存在字段填充设置   ----->
        <#if field.convert>
    @TableField(value = "${field.name}", fill = FieldFill.${field.fill})
        <#else>
    @TableField(fill = FieldFill.${field.fill})
        </#if>
    <#elseif field.convert>
    @TableField("${field.name}")
    </#if>
<#-- 乐观锁注解 -->
    <#if (versionFieldName!"") == field.name>
    @Version
    </#if>
<#-- 逻辑删除注解 -->
    <#if (logicDeleteFieldName!"") == field.name>
    @TableLogic
    </#if>
    <#if field.propertyType == "Integer">
    var ${field.propertyName}: Int? = null<#if field_has_next>,</#if>
    <#elseif field.propertyType == "String">
    var ${field.propertyName}: String = ""<#if field_has_next>,</#if>
    <#else>
    var ${field.propertyName}: ${field.propertyType}? = null<#if field_has_next>,</#if>
    </#if>
</#list>
<#-- ----------  END 字段循环遍历  ---------->
) : ${superEntityClass}()


