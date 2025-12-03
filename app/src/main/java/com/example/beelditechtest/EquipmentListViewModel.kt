package com.example.beelditechtest

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class EquipmentListViewModel(private val dataSource: EquipmentDataSource) : ViewModel() {

    private val _state = MutableStateFlow(EquipmentListState())
    val state : StateFlow<EquipmentListState> = _state.asStateFlow()



    init {
        loadEquipments()
    }

    fun loadEquipments() {
        // TODO
    }
}
