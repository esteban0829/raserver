package com.rasMainServer.raserver.service

import com.rasMainServer.raserver.ComputerInfo
import com.rasMainServer.raserver.ComputerInfoDTO
import com.rasMainServer.raserver.ComputerInfoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class ComputerInfoService {
    @Autowired
    lateinit var computerInfoRepository: ComputerInfoRepository

    @Transactional
    fun saveComputerInfo(computerInfoDTO: ComputerInfoDTO): ComputerInfoDTO {

        val ip = computerInfoDTO.ip

        val isDuplicateIpComputerExist = computerInfoRepository.findByIp(ip)

        if(isDuplicateIpComputerExist.isEmpty){
            return computerInfoRepository.save(computerInfoDTO.toEntity()).toDTO()
        }else{
            throw Exception("duplicate ip in database")
        }
    }

    @Transactional
    fun patchComputerInfo(computerId: Long, computerInfoDTO: ComputerInfoDTO): ComputerInfoDTO {
        val computerInfo = computerInfoRepository.findById(computerId)
            .orElseThrow{ throw Exception("computerInfo with id : ${computerId} doesn't exist") }
        computerInfo.apply {
            ip = computerInfoDTO.ip
            osName = computerInfoDTO.osName
            online = computerInfoDTO.online
            boardInfo = computerInfoDTO.boardInfo
            cpuFreq0 = computerInfoDTO.cpuFreq0
            cpuFreq1 = computerInfoDTO.cpuFreq1
            cpuFreq2 = computerInfoDTO.cpuFreq2
            cpuFreq3 = computerInfoDTO.cpuFreq3
            cpuTemp = computerInfoDTO.cpuTemp
            gpuTemp = computerInfoDTO.gpuTemp
            memTotal = computerInfoDTO.memTotal
            memFree = computerInfoDTO.memFree
            swapTotal = computerInfoDTO.swapTotal
            swapFree = computerInfoDTO.swapFree
            diskTotal0 = computerInfoDTO.diskTotal0
            diskUsage0 = computerInfoDTO.diskUsage0
            ipInfo = computerInfoDTO.ipInfo
            macAddr = computerInfoDTO.macAddr
            addrBit = computerInfoDTO.addrBit
            hostName = computerInfoDTO.hostName
        }

        return computerInfoRepository.save(computerInfo).toDTO()
    }

    @Transactional
    fun deleteAllComputerInfo(){
        computerInfoRepository.deleteAll()
    }

    @Transactional
    fun deleteComputerInfoWithId(id: Long){
        computerInfoRepository.deleteById(id)
    }

    fun getAllComputerInfo(): List<ComputerInfoDTO> {
        return computerInfoRepository.findAll().map { it.toDTO() }
    }

    fun getComputerInfoWithId(id: Long): ComputerInfoDTO {
        return computerInfoRepository.findById(id)
            .orElseThrow{ throw Exception("can't find computerInfo with id : $id") }.toDTO()
    }

    fun getComputerInfoWithIp(ip: String): ComputerInfoDTO? {
        val computerInfo = computerInfoRepository.findByIp(ip)
        return if (computerInfo.isPresent) {
            computerInfo.get().toDTO()
        } else {
            null
        }
    }
}