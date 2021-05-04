package com.rasMainServer.raserver

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class ComputerInfo (
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,

    var ip: String,
    var online: Boolean? = null,
    var temperature: Int? = null,
    var cpuConsumption: Int? = null,
    var ramConsumption: Int? = null,
) {
    fun toDTO(): ComputerInfoDTO {
        return ComputerInfoDTO(
            id = id,
            ip = ip,
            online = online,
            temperature = temperature,
            cpuConsumption = cpuConsumption,
            ramConsumption = ramConsumption
        )
    }
}