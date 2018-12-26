package ${package.ServiceImpl}

import ${package.Entity}.${entity}
import ${package.Mapper}.${table.mapperName}
import ${package.Service}.${table.serviceName}
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import com.github.pagehelper.Page
import com.seal.ljk.base.AuthException
import com.seal.ljk.base.loggerFor
import com.seal.ljk.common.getSessionUser

/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
class ${table.serviceImplName} : ${table.serviceName} {

    val log = loggerFor(this.javaClass)

    @Autowired
    lateinit var ${table.mapperName?uncap_first}: ${table.mapperName}

    override fun get${entity}(id: String): ${entity}? {
        return ${table.mapperName?uncap_first}.get(id)
    }

    override fun getAll${entity}(${entity?uncap_first}: ${entity}): List<${entity}> {
        val user = getSessionUser() ?: throw AuthException()
        if (user.isSeal()) {
           ${entity?uncap_first}.channelMark = ""
        } else {
           ${entity?uncap_first}.channelMark = user.channelMark
        }
        return ${table.mapperName?uncap_first}.getAll(${entity?uncap_first})
    }

    override fun getAll${entity}ByPage(${entity?uncap_first}: ${entity}): Page<${entity}> {
        val user = getSessionUser() ?: throw AuthException()
        if (user.isSeal()) {
           ${entity?uncap_first}.channelMark = ""
        } else {
           ${entity?uncap_first}.channelMark = user.channelMark
        }
        return ${table.mapperName?uncap_first}.getAll(${entity?uncap_first})
    }

    override fun insert${entity}(${entity?uncap_first}: ${entity}) {
        ${table.mapperName?uncap_first}.insert(${entity?uncap_first})
    }

    override fun update${entity}(${entity?uncap_first}: ${entity}) {
        ${table.mapperName?uncap_first}.update(${entity?uncap_first})
    }

    override fun delete${entity}(id: String) {
        ${table.mapperName?uncap_first}.delete(id)
    }

}
