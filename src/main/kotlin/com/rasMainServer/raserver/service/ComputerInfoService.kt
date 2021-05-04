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

        val optionalComputerInfo = computerInfoRepository.findByIp(ip)
        if(optionalComputerInfo.isPresent) {
            val optComputerInfo =  optionalComputerInfo.get()
            optComputerInfo.online = computerInfo.online
            optComputerInfo.osName = computerInfo.osName
            optComputerInfo.temperature = computerInfo.temperature
            optComputerInfo.cpuConsumption = computerInfo.cpuConsumption
            optComputerInfo.ramConsumption = computerInfo.ramConsumption
            return optComputerInfo.toDTO()
        }else{
            return computerInfoRepository.save(computerInfo).toDTO()
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