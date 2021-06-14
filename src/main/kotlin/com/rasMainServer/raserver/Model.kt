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
    var osName: String? = null,
    var online: Boolean? = null,

    var boardInfo: String? = null,
    var cpuFreq0: Long? = null,
    var cpuFreq1: Long? = null,
    var cpuFreq2: Long? = null,
    var cpuFreq3: Long? = null,

    var cpuUsage0: Float? = null,
    var cpuUsage1: Float? = null,
    var cpuUsage2: Float? = null,
    var cpuUsage3: Float? = null,

    var cpuTemp: Float? = null,
    var gpuTemp: Float? = null,
    var memTotal: Int? = null,
    var memFree: Int? = null,

    var swapTotal: Int? = null,
    var swapFree: Int? = null,

    var diskTotal0: Float? = null,
    var diskUsage0: Float? = null,

    var ipInfo: String? = null,

    var macAddr: String? = null,

    var addrBit: Int? = null,
    var hostName: String? = null
) {
    fun toDTO(): ComputerInfoDTO {
        return ComputerInfoDTO(
            id = id,
            ip = ip,
            osName = osName,
            online = online,
            boardInfo = boardInfo,
            cpuFreq0 = cpuFreq0,
            cpuFreq1 = cpuFreq1,
            cpuFreq2 = cpuFreq2,
            cpuFreq3 = cpuFreq3,
            cpuTemp = cpuTemp,
            gpuTemp = gpuTemp,
            memTotal = memTotal,
            memFree = memFree,
            swapTotal = swapTotal,
            swapFree = swapFree,
            diskTotal0 = diskTotal0,
            diskUsage0 = diskUsage0,
            ipInfo = ipInfo,
            macAddr = macAddr,
            addrBit = addrBit,
            hostName = hostName
        )
    }
}