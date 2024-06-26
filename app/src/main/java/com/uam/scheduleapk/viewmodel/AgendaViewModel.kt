package com.uam.scheduleapk.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uam.scheduleapk.model.ListAgenda
import com.uam.scheduleapk.repository.RepositoryAgenda
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AgendaViewModel: ViewModel() {
    private val repository = RepositoryAgenda()

    private val _state = MutableStateFlow<UIState>(UIState())
    val state: StateFlow<UIState> = _state

    init {
        viewModelScope.launch {
            _state.update { it.copy(loading = true) }
            val response = repository.getAll()
            if(response.isSuccess){
                _state.update { it.copy(listAgenda = response.getOrNull()!!) }
            }
            _state.update { it.copy(loading = false) }
        }
    }

    data class UIState(
        val listAgenda: ListAgenda = ListAgenda(),
        val loading: Boolean = false
    )

}