package com.example.beelditechtest.data.mapper

import com.example.beelditechtest.data.model.EquipmentEntity
import com.example.beelditechtest.domain.model.Equipment
import com.example.beelditechtest.domain.model.EquipmentType

fun EquipmentEntity.toDomain(): Equipment {
    return Equipment(
        id = this.id,
        name = this.name,
        brand = this.brand,
        model = this.model,
        serialNumber = this.serialNumber,
        location = this.location,
        type =
            when (this.type) {
                0 -> EquipmentType.TYPE_0
                1 -> EquipmentType.TYPE_1
                2 -> EquipmentType.TYPE_2
                else -> EquipmentType.UNKNOWN
            },
    )
}
