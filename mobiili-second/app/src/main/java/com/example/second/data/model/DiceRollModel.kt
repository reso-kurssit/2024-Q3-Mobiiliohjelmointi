package com.example.second.data.model

import com.example.second.R

data class DiceRollState(
    val diceResult: Int = 0,
    val finalResult: Int = 0,
    val bonus: Int = 0,
    val penalty: Int = 0,
    val specialMessageSuccess: String = "",
    val specialMessageFailure: String = "",
    val imageResource: Int = R.drawable.d201
)