package ${package.Controller}

import ${package.Service}.${table.serviceName}
import com.seal.ljk.base.VerifyToken
import com.seal.ljk.common.ResVal
import com.seal.ljk.common.success
import ${package.Entity}.${entity}
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*
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
    @VerifyToken
    fun get${entity}(@RequestParam id: String): ResVal = success(${table.serviceName?substring(1)?uncap_first}.get${entity}(id))

    @PostMapping("/list")
    @ApiOperation(value = "${table.comment!}方列表")
    @VerifyToken
    fun list${entity}(@RequestBody ${entity?uncap_first}: ${entity}): ResVal = success(${table.serviceName?substring(1)?uncap_first}.getAll${entity}(${entity?uncap_first}))


    @PostMapping("/save")
    @ApiOperation(value = "新增或修改${table.comment!}")
    @VerifyToken
    fun save${entity}(@RequestBody ${entity?uncap_first}: ${entity}): ResVal {
        ${entity?uncap_first}.verify()
        if (${entity?uncap_first}.id.isEmpty()) {
            ${table.serviceName?substring(1)?uncap_first}.insert${entity}(${entity?uncap_first})
        } else {
            ${table.serviceName?substring(1)?uncap_first}.update${entity}(${entity?uncap_first})
        }
        return success(mapOf("id" to ${entity?uncap_first}.id))
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除${table.comment!}")
    @VerifyToken
    fun delete${entity}(@RequestParam id: String): ResVal {
        ${table.serviceName?substring(1)?uncap_first}.delete${entity}(id)
        return success()
    }

}
