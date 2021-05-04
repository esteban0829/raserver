package com.rasMainServer.raserver

import org.springframework.data.repository.CrudRepository

interface ComputerInfoRepository: CrudRepository<ComputerInfo, Long>{
    fun findByIp(ip: String): ComputerInfo?
}