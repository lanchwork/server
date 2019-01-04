package com.seal.ljk.controller

import com.seal.ljk.service.ISysDictItemService
import com.seal.ljk.base.VerifyToken
import com.seal.ljk.common.ResVal
import com.seal.ljk.common.success
import com.seal.ljk.common.getPageInfo
import com.seal.ljk.model.SysDictItem
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
/**
 * <p>
 *  数据项列表前端控制器
 * </p>
 *
 * @author lanch
 * @since 2019-01-03
 */
@Api(description = " 功能相关接口")
@RestController
@RequestMapping("/ljk/sys-dict-item")
class SysDictItemController{

    @Autowired
    lateinit var sysDictItemService: ISysDictItemService


    @PostMapping("/get")
    @ApiOperation(value = "获取")
    @VerifyToken
    fun getSysDictItem(@RequestParam id: String): ResVal = success(sysDictItemService.getSysDictItem(id))

    @PostMapping("/list")
    @ApiOperation(value = "方列表")
    @VerifyToken
    fun listSysDictItem(@RequestBody sysDictItem: SysDictItem): ResVal {
        if (sysDictItem.orderByInfo == null) {
            sysDictItem.orderByInfo = arrayOf("value")
        }
        return success(sysDictItemService.getAllSysDictItemByPage(sysDictItem).getPageInfo())
    }


    @PostMapping("/save")
    @ApiOperation(value = "新增或修改")
    @VerifyToken
    fun saveSysDictItem(@RequestBody sysDictItem: SysDictItem): ResVal {
        if (sysDictItem.id.isEmpty()) {
            sysDictItem.verify()
            sysDictItemService.insertSysDictItem(sysDictItem)
        } else {
            sysDictItemService.updateSysDictItem(sysDictItem)
        }
        return success(mapOf("id" to sysDictItem.id))
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除表")
    @VerifyToken
    fun deleteSysMenu(@RequestParam id: String): ResVal {
        sysDictItemService.deleteSysDictItem(id)
        return success("success")
    }
}
