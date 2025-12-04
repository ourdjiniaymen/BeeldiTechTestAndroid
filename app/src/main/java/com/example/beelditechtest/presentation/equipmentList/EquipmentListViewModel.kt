package com.example.beelditechtest.presentation.equipmentList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.beelditechtest.domain.repository.EquipmentRepository
import com.example.beelditechtest.domain.usecase.GetEquipmentsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class EquipmentListViewModel(private val getEquipmentsUseCase: GetEquipmentsUseCase) : ViewModel() {

    private val _state = MutableStateFlow(EquipmentListState())
    val state: StateFlow<EquipmentListState> = _state.asStateFlow()


    init {
        loadEquipments()
    }

    fun loadEquipments() {
        viewModelScope.launch {
            getEquipmentsUseCase()
                .onStart {
                    // Avant de commencer, on met isLoading à true
                    _state.update { currentState ->
                        currentState.copy(isLoading = true, error = null)
                    }
                }
                .catch { exception ->
                    // En cas d'erreur, on met à jour le state avec l'erreur
                    _state.update { currentState ->
                        currentState.copy(
                            isLoading = false,
                            error = exception.message ?: "Erreur inconnue"
                        )
                    }
                }
                .collect { equipments ->
                    // Quand on reçoit les données, on met à jour le state
                    _state.update { currentState ->
                        currentState.copy(
                            equipments = equipments,
                            isLoading = false,
                            error = null
                        )
                    }
                }
        }
    }

}