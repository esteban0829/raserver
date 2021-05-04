package com.rasMainServer.raserver

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Computer (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var ip: String,
    var online: Boolean? = null,
    var temperature: Int? = null,
    var cpuConsumption: Int? = null,
    var ramConsumption: Int? = null,
)