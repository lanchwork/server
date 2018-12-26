package com.seal.ljk.controller


import com.seal.ljk.base.VerifyToken
import com.seal.ljk.common.ResVal
import com.seal.ljk.common.success
import com.seal.ljk.model.SysPartner

import com.seal.ljk.service.ISysPartnerService
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*

/**
 * <p>
 * 合作方表 前端控制器
 * </p>
 *
 * @author chenjh
 * @since 2018-12-24
 */
@RestController
@RequestMapping("/sys/partner")
class SysPartnerController{

    lateinit var sysPartnerService: ISysPartnerService


    @PostMapping("/get")
    @ApiOperation(value = "获取合作方表")
    @VerifyToken
    fun getSysPartner(@RequestParam id: String): ResVal = success(sysPartnerService.getSysPartner(id))

    @PostMapping("/list")
    @ApiOperation(value = "合作方表方列表")
    @VerifyToken
    fun listSysPartner(@RequestBody sysPartner: SysPartner): ResVal = success( sysPartnerService.getAllSysPartner(sysPartner))


    @PostMapping("/save")
    @ApiOperation(value = "新增或修改合作方表")
    @VerifyToken
    fun saveSysPartner(@RequestBody sysPartner: SysPartner): ResVal {
        sysPartner.verify()
        if (sysPartner.id.isEmpty()) {
            sysPartnerService.insertSysPartner(sysPartner)
        } else {
            sysPartnerService.updateSysPartner(sysPartner)
        }
        return success( mapOf("id" to sysPartner.id))
    }

//    @PostMapping("/delete")
//    @ApiOperation(value = "删除合作方表")
//    fun deleteSysPartner(@RequestParam id: String): ResVal {
//        sysPartnerService.deleteSysPartner(id)
//        return success("success")
//    }

}
