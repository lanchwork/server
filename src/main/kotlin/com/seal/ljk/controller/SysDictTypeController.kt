package com.seal.ljk.controller

import com.seal.ljk.base.SealException
import com.seal.ljk.service.ISysDictTypeService
import com.seal.ljk.base.VerifyToken
import com.seal.ljk.common.ResVal
import com.seal.ljk.common.success
import com.seal.ljk.common.getPageInfo
import com.seal.ljk.model.SysDictType
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
/**
 * <p>
 * 数据字典类型 前端控制器
 * </p>
 *
 * @author tingyx
 * @since 2019-01-03
 */
@Api(description = "数据字典类型 功能相关接口")
@RestController
@RequestMapping("/ljk/sys-dict-type")
class SysDictTypeController{

    @Autowired
    lateinit var sysDictTypeService: ISysDictTypeService


    @PostMapping("/get")
    @ApiOperation(value = "获取数据字典类型")
    @VerifyToken
    fun getSysDictType(@RequestParam id: String): ResVal = success(sysDictTypeService.getSysDictType(id))

    @PostMapping("/list")
    @ApiOperation(value = "数据字典类型列表")
    @VerifyToken
    fun listSysDictType(@RequestBody sysDictType: SysDictType): ResVal {
        //获取的是删除标识为0(未删除)的类型
        sysDictType.delFlag = "0"
        return success(sysDictTypeService.getAllSysDictTypeByPage(sysDictType).getPageInfo())
    }


    @PostMapping("/save")
    @ApiOperation(value = "新增或修改数据字典类型")
    @VerifyToken
    fun saveSysDictType(@RequestBody sysDictType: SysDictType): ResVal {
        if (sysDictType.id.isEmpty()) {
            sysDictType.delFlag = "0"
            sysDictType.verify()
            sysDictTypeService.insertSysDictType(sysDictType)
        } else {
            sysDictTypeService.updateSysDictType(sysDictType)
        }
        return success(mapOf("id" to sysDictType.id))
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除数据字典类型")
    @VerifyToken
    fun deleteSysDictType(@RequestParam id: String): ResVal {
        val sysDictType = sysDictTypeService.getSysDictType(id) ?: throw SealException(message = "dictType does not exist!")
        //删除，置删除标识位为1
        sysDictType.delFlag = "1"
        sysDictTypeService.updateSysDictType(sysDictType)
        return success()
    }

}
