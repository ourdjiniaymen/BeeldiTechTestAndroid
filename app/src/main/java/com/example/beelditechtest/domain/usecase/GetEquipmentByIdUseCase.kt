package com.example.beelditechtest.domain.usecase

import com.example.beelditechtest.domain.model.Equipment
import com.example.beelditechtest.domain.repository.EquipmentRepository
import kotlinx.coroutines.flow.Flow

class GetEquipmentByIdUseCase(private val equipmentRepository: EquipmentRepository) {
    operator fun invoke(id: String): Flow<Equipment?> {
        return equipmentRepository.getEquipmentById(id)
    }
}
