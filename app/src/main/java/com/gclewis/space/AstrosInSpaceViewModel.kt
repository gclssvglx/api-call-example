package com.gclewis.space

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class AstrosInSpaceViewModel : ViewModel() {
    private val repository = AstrosInSpaceRepository()
    private val _astros = MutableLiveData<List<Astro>>()

    val astros: LiveData<List<Astro>> = _astros

    fun fetchAstros() {
        viewModelScope.launch {
            try {
                val people = repository.getAstrosInSpace()
                _astros.value = people.people
            } catch (e: Exception) {
                println("Error fetching astronauts: ${e.message}")
            }
        }
    }
}
