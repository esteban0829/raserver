package com.rasMainServer.raserver.Service

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

    fun saveComputerInfo(ComputerInfo: ComputerInfo): ComputerInfoDTO {
        return computerInfoRepository.save(ComputerInfo).toDTO()
    }

    fun getAllComputerInfo(): List<ComputerInfoDTO> {
        return computerInfoRepository.findAll().map { it.toDTO() }
    }

    fun getComputerInfoWithId(id: Long): Optional<ComputerInfo> {
        return computerInfoRepository.findById(id)
    }
}