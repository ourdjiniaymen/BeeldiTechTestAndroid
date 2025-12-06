package com.example.beelditechtest.domain.usecase

import com.example.beelditechtest.domain.model.Equipment
import com.example.beelditechtest.domain.model.EquipmentType
import com.example.beelditechtest.domain.repository.EquipmentRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever

class GetEquipmentByIdUseCaseTest {
    private val equipmentRepository = mock<EquipmentRepository>()
    private val useCase = GetEquipmentByIdUseCase(equipmentRepository)

    @Test
    fun `usecase should return equipment by id`() =
        runTest {
            val equipment =
                Equipment(
                    id = "1",
                    name = "Equipment 1",
                    brand = "Brand 1",
                    model = "Model 1",
                    serialNumber = "SN1",
                    location = "Location 1",
                    type = EquipmentType.TYPE_0,
                )

            whenever(equipmentRepository.getEquipmentById("1")).thenReturn(flowOf(equipment))

            val result = useCase("1").first()
            assert(result == equipment)
        }

    @Test
    fun `usecase should return null when equipment not found`() =
        runTest {
            whenever(equipmentRepository.getEquipmentById("999")).thenReturn(flowOf(null))

            val result = useCase("999").first()
            assert(result == null)
        }
}
