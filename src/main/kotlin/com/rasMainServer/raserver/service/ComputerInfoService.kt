package com.rasMainServer.raserver.service

import com.rasMainServer.raserver.ComputerInfo
import com.rasMainServer.raserver.ComputerInfoDTO
import com.rasMainServer.raserver.ComputerInfoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ComputerInfoService {
    @Autowired
    lateinit var computerInfoRepository: ComputerInfoRepository

    fun saveComputerInfo(computerInfo: ComputerInfo): ComputerInfoDTO {

        val ip = computerInfo.ip

        val nComputerInfo = computerInfoRepository.findByIp(ip)

        return if(nComputerInfo != null){
            nComputerInfo.online = computerInfo.online
            nComputerInfo.temperature = computerInfo.temperature
            nComputerInfo.osName = computerInfo.osName
            nComputerInfo.cpuConsumption = computerInfo.cpuConsumption
            nComputerInfo.ramConsumption = computerInfo.ramConsumption
            computerInfoRepository.save(nComputerInfo)
            nComputerInfo.toDTO()
        }else{
            computerInfoRepository.save(computerInfo).toDTO()
        }
    }

    fun getAllComputerInfo(): List<ComputerInfoDTO> {
        return computerInfoRepository.findAll().map { it.toDTO() }
    }

    fun getComputerInfoWithId(id: Long): Optional<ComputerInfo> {
        return computerInfoRepository.findById(id)
    }

    fun deleteAllComputerInfo(){
        computerInfoRepository.deleteAll()
    }

    fun deleteComputerInfoWithId(id: Long){
        computerInfoRepository.deleteById(id)
    }
}