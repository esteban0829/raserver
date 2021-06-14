package com.rasMainServer.raserver.controller

import com.rasMainServer.raserver.ComputerInfo
import com.rasMainServer.raserver.ComputerInfoDTO
import com.rasMainServer.raserver.service.ComputerInfoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/computerInfo", produces = ["application/json"])
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
    ): ResponseEntity<ComputerInfoDTO> {
        val computerInfoDTO = computerInfoService.getComputerInfoWithId(id)
        return ResponseEntity.ok()
            .body(computerInfoDTO)
    }

    @Transactional
    @PostMapping("")
    fun saveComputerInformation(
        @RequestBody computerInfoDTO: ComputerInfoDTO
    ): ResponseEntity<ComputerInfoDTO> {
        return try {
            ResponseEntity.accepted().body(computerInfoService.saveComputerInfo(computerInfoDTO))
        }catch (e: Exception){
            ResponseEntity.badRequest().build()
        }
    }

    @Transactional
    @PatchMapping("/{id}")
    fun patchComputerInformation(
        @PathVariable(value = "id") computerInfoId: Long,
        @RequestParam computerInfoDTO: ComputerInfoDTO
    ): ResponseEntity<ComputerInfoDTO> {

        return ResponseEntity.ok().body(computerInfoService.patchComputerInfo(computerInfoId, computerInfoDTO))
    }

    @Transactional
    @DeleteMapping("")
    fun deleteAllComputerInformation(): ResponseEntity<Any> {
        computerInfoService.deleteAllComputerInfo()
        return ResponseEntity.noContent().build()
    }

    @DeleteMapping("/{id}")
    fun deleteComputerInformationWithId(
        @PathVariable(value = "id") id: Long
    ): ResponseEntity<Any> {
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/withIp")
    fun getAllComputerInformation(
        @RequestParam(name = "ip") ip: String
    ): ResponseEntity<ComputerInfoDTO> {
        val computerInfoDTO = computerInfoService.getComputerInfoWithIp(ip) ?:
            return ResponseEntity.noContent().build()
        return ResponseEntity.ok().body(computerInfoDTO)
    }
}