package com.seal.ljk.controller

import com.google.common.io.Files.*
import com.seal.ljk.base.StaticFileConfig
import com.seal.ljk.common.ResVal
import com.seal.ljk.common.UUIDUtil
import com.seal.ljk.common.success
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.*


/**
 * Created by chenjh on 2018/12/27.
 */
@RestController
@RequestMapping("/static")
@Api(description = "静态文件 相关接口")
class StaticController {

    @PostMapping("/upload")
    @ApiOperation(value = "上传文件")
    fun upload(@RequestParam("file") file: MultipartFile,
               @RequestHeader("path", required = false, defaultValue = "") path: String): ResVal {

        var localFilePath: String? = null
        if (!file.isEmpty) {
            val ext = getFileExtension(file.originalFilename ?: "")
            var randomName = UUIDUtil.uuid.substring(0, 16)
            if (ext.isNotEmpty())
                randomName = "$randomName.$ext"

            if (path.isNotEmpty()) {
                var appendPath = path
                if (appendPath.startsWith("/"))
                    appendPath = appendPath.substring(1)
                if (!appendPath.endsWith("/"))
                    appendPath = "$appendPath/"
                randomName = appendPath + randomName
            }

            val localFile = File(StaticFileConfig.fileDir + randomName)
            if (!localFile.parentFile.exists()) {
                localFile.parentFile.mkdirs()
            }
            write(file.bytes, localFile)
            localFilePath = "${StaticFileConfig.path}/$randomName"
        }
        return success(localFilePath)
    }

}
