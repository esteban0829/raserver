package com.rasMainServer.raserver

import org.springframework.data.repository.CrudRepository
import java.util.*

interface ComputerInfoRepository: CrudRepository<ComputerInfo, Long>{
    fun findByIp(ip: String): Optional<ComputerInfo>
}