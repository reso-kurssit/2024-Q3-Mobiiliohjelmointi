package com.example.first.screens.bmiAndViewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class BmiViewModel : ViewModel() {

    private val _bmiModel = MutableStateFlow(BmiModel())
    val bmiModel: StateFlow<BmiModel> = _bmiModel.asStateFlow()

    fun updateHeight(newHeight: String) {
        val updatedModel = _bmiModel.value.copy(height = newHeight)
        _bmiModel.value = updatedModel
        calculateBmi(updatedModel)
    }

    fun updateWeight(newWeight: String) {
        val updatedModel = _bmiModel.value.copy(weight = newWeight)
        _bmiModel.value = updatedModel
        calculateBmi(updatedModel)
    }

    private fun calculateBmi(model: BmiModel) {
        val heightValue = model.height.toFloatOrNull()?.let {
            if (model.height.length >= 3) it / 100 else it
        } ?: 0.0f

        val weightValue = model.weight.toFloatOrNull() ?: 0.0f

        val newBmi = if (heightValue > 0 && weightValue > 0) {
            weightValue / (heightValue * heightValue).toDouble()
        } else {
            0.0
        }

        _bmiModel.value = model.copy(bmi = newBmi)

    }
}