package ${package.Entity}

<#list table.importPackages as pkg>
import ${pkg}
</#list>
import com.seal.ljk.common.using
import com.seal.ljk.base.PrimaryKey

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

    <#if field.comment!?length gt 0>
    /**
     * ${field.comment}
     */
    </#if>
    <#if field.propertyName == "id">
    @PrimaryKey
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
) : Base(), IVerify {

    override fun verify() {
        this.apply {
<#list table.fields as field>
        <#if field.propertyType == "Integer">
            "${field.comment} 不能为空" using (this.${field.propertyName} != null)
        <#elseif field.propertyType == "String">
            "${field.comment} 不能为空" using (this.${field.propertyName}.isNotEmpty())
        <#else>
        </#if>
</#list>
        }
    }
}


