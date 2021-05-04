package com.rasMainServer.raserver.Controller

import com.rasMainServer.raserver.ComputerInfo
import com.rasMainServer.raserver.ComputerInfoDTO
import com.rasMainServer.raserver.Service.ComputerInfoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/ComputerInfoInformation", produces = ["application/json"])
class RestController {

    @Autowired
    lateinit var computerInfoService: ComputerInfoService

    @GetMapping("")
    fun getAllComputerInformation(): ResponseEntity<List<ComputerInfoDTO>> {
        return ResponseEntity.ok()
            .body(computerInfoService.getAllComputerInfo())
    }

    @GetMapping("/{id}")
    fun getComputerInformationWithId(
        @PathVariable(value = "id") id: Long
    ): ResponseEntity<Optional<ComputerInfo>> {

        val computerInfoDTO = computerInfoService.getComputerInfoWithId(id)

        return ResponseEntity.ok()
            .body(computerInfoDTO)
    }

    @PostMapping("")
    fun saveComputerInformation(
        @RequestBody computerInfo: ComputerInfo
    ): ResponseEntity<ComputerInfoDTO> {

        val computerInfoTemp = computerInfoService.saveComputerInfo(computerInfo)

        return ResponseEntity.accepted()
            .body(computerInfoTemp)
    }

    @GetMapping("")
    fun deleteAllComputerInformation(): ResponseEntity.HeadersBuilder<*> {

        computerInfoService.deleteAllComputerInfo()

        return ResponseEntity.noContent()
    }

    @GetMapping("/{id}")
    fun deleteComputerInformationWithId(
        @PathVariable(value = "id") id: Long
    ): ResponseEntity.HeadersBuilder<*> {

        computerInfoService.deleteComputerInfoWithId(id)

        return ResponseEntity.noContent()
    }
}