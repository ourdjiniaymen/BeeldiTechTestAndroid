package com.example.beelditechtest.presentation.equipmentDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.beelditechtest.domain.usecase.GetEquipmentByIdUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class EquipmentDetailsViewModel(
    private val getEquipmentByIdUseCase: GetEquipmentByIdUseCase,
    private val id: String,
) : ViewModel() {
    private val _state = MutableStateFlow(EquipmentDetailsState())
    val state: StateFlow<EquipmentDetailsState> = _state.asStateFlow()

    init {
        loadEquipment()
    }

    fun loadEquipment() {
        viewModelScope.launch {
            getEquipmentByIdUseCase(id).onStart {
                _state.update { currentState ->
                    currentState.copy(isLoading = true, error = null)
                }
            }.catch { exception ->
                _state.update { currentState ->
                    currentState.copy(isLoading = false, error = exception.message ?: "Erreur inconnue")
                }
            }.collect { equipment ->
                _state.update { currentState ->
                    currentState.copy(equipment = equipment, isLoading = false, error = null)
                }
            }
        }
    }
}
