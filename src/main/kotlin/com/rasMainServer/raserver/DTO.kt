package com.rasMainServer.raserver

data class ComputerInfoDTO(
    var id: Long?,
    var ip: String,
    var osName: String? = null,
    var online: Boolean? = null,
    var temperature: Int? = null,
    var cpuConsumption: Int? = null,
    var ramConsumption: Int? = null,
) {
    fun toEntity(): ComputerInfo {
        return ComputerInfo(
            id = id,
            ip = ip,
            osName = osName,
            online = online,
            temperature = temperature,
            cpuConsumption = cpuConsumption,
            ramConsumption = ramConsumption
        )
    }
}