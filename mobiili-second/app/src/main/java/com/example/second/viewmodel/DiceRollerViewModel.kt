import androidx.lifecycle.ViewModel
import com.example.second.R
import com.example.second.data.model.DiceRollState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.random.Random

class DiceRollerViewModel : ViewModel() {

    private val _diceRollState = MutableStateFlow(DiceRollState())
    val diceRollState: StateFlow<DiceRollState> = _diceRollState

    fun rollDice(bonus: Int, penalty: Int) {
        val diceResult = Random.nextInt(1, 21)
        val imageResource = when (Random.nextInt(201, 210)) {
            201 -> R.drawable.d201
            202 -> R.drawable.d202
            203 -> R.drawable.d203
            204 -> R.drawable.d204
            205 -> R.drawable.d205
            206 -> R.drawable.d206
            207 -> R.drawable.d207
            208 -> R.drawable.d208
            209 -> R.drawable.d209
            else -> R.drawable.d201
        }

        val finalResult: Int
        var specialMessageSuccess = ""
        var specialMessageFailure = ""

        when (diceResult) {
            20 -> {
                finalResult = diceResult
                specialMessageSuccess = "Critical Success!"
            }
            1 -> {
                finalResult = diceResult
                specialMessageFailure = "Critical Failure!"
            }
            else -> {
                finalResult = diceResult + bonus - penalty
            }
        }

        _diceRollState.value = DiceRollState(
            diceResult = diceResult,
            finalResult = finalResult,
            bonus = bonus,
            penalty = penalty,
            specialMessageSuccess = specialMessageSuccess,
            specialMessageFailure = specialMessageFailure,
            imageResource = imageResource
        )
    }

    fun updateBonus(value: Int) {
        _diceRollState.value = _diceRollState.value.copy(bonus = value)
    }

    fun updatePenalty(value: Int) {
        _diceRollState.value = _diceRollState.value.copy(penalty = value)
    }
}
