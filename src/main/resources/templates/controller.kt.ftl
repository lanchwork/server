package ${package.Controller}


import org.springframework.web.bind.annotation.RequestMapping

import org.springframework.web.bind.annotation.RestController
import ${package.Service}.${table.serviceName}
/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@RestController
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>{

    lateinit var ${table.serviceName?substring(1)?uncap_first}: ${table.serviceName}


    @PostMapping("/get")
    @ApiOperation(value = "获取${table.comment!}")
    fun get${entity}(@RequestParam id: String): ResVal = ResVal(0, ${table.serviceName?substring(1)?uncap_first}.get${entity}(id))

    @PostMapping("/list")
    @ApiOperation(value = "${table.comment!}方列表")
    fun list${entity}(@RequestBody ${entity?uncap_first}: ${entity}): ResVal = ResVal(0, ${table.serviceName?substring(1)?uncap_first}.getAll${entity}(${entity?uncap_first}))


    @PostMapping("/save")
    @ApiOperation(value = "新增或修改${table.comment!}")
    fun save${entity}(@RequestBody ${entity?uncap_first}: ${entity}): ResVal {
        ${entity?uncap_first}.verify()
        if (${entity?uncap_first}.id.isEmpty()) {
            ${table.serviceName?substring(1)?uncap_first}.insert${entity}(${entity?uncap_first})
        } else {
            ${table.serviceName?substring(1)?uncap_first}.update${entity}(${entity?uncap_first})
        }
        return ResVal(0, mapOf("id" to ${entity?uncap_first}.id))
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除${table.comment!}")
    fun delete${entity}(@RequestParam id: String): ResVal {
        ${table.serviceName?substring(1)?uncap_first}.delete${entity}(id)
        return ResVal(0, "success")
    }

}
