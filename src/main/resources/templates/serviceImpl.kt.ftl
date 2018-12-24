package ${package.ServiceImpl}

import ${package.Entity}.${entity}
import ${package.Mapper}.${table.mapperName}
import ${package.Service}.${table.serviceName}
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import com.github.pagehelper.Page

/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service(value = "${table.serviceName?substring(1)?uncap_first}")
open class ${table.serviceImplName} : ${table.serviceName} {

    @Autowired
    lateinit var mapper: ${table.mapperName}

    override fun get(id: String): ${entity} {
        return mapper.get(id)
    }

    override fun getAll(data: ${entity}): Page<${entity}> {
        return mapper.getAll(data)
    }

    override fun insert(data: ${entity}) {
        if(data.id == ""){
            data.id = UUIDUtil.uuid
        }
        mapper.insert(data)
    }

    override fun update(data: ${entity}) {
        mapper.update(data)
    }

    override fun delete(id: String) {
        mapper.delete(id)
    }

}
