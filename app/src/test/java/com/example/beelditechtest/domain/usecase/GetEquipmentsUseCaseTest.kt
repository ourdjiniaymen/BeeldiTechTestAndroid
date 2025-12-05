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

class GetEquipmentsUseCaseTest {
    private val equipmentRepository = mock<EquipmentRepository>()
    private val useCase = GetEquipmentsUseCase(equipmentRepository)

    @Test
    fun `usecase should return equipments`() =
        runTest {
            val equipments =
                listOf<Equipment>(
                    Equipment(
                        id = "1",
                        name = "Equipment 1",
                        brand = "Brand 1",
                        model = "Model 1",
                        serialNumber = "SN1",
                        location = "Location 1",
                        type = EquipmentType.TYPE_0,
                    ),
                )

            whenever(equipmentRepository.getEquipments()).thenReturn(flowOf(equipments))

            val result = useCase().first()
            assert(result == equipments)
        }
}
