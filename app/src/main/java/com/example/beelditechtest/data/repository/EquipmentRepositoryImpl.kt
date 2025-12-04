package com.example.beelditechtest.data.repository

import com.example.beelditechtest.data.datasource.EquipmentDataSource
import com.example.beelditechtest.data.mapper.toDomain
import com.example.beelditechtest.domain.model.Equipment
import com.example.beelditechtest.domain.repository.EquipmentRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class EquipmentRepositoryImpl(private val dataSource: EquipmentDataSource) : EquipmentRepository {
    override fun getEquipments(): Flow<List<Equipment>> {
        return dataSource.getEquipmentsFlow().map { equipmentEntities ->
            equipmentEntities.map {
                it.toDomain()
            }
        }
    }

}