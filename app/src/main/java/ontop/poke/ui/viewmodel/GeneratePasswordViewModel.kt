package ontop.poke.ui.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import ontop.poke.ui.viewstate.PasswordGenerateViewState
import kotlin.random.Random

class GeneratePasswordViewModel : ViewModel() {
    private val random = Random

    private val _viewState = mutableStateOf(PasswordGenerateViewState())
    val viewState: State<PasswordGenerateViewState> = _viewState

    fun toggleUseNumbers() {
        _viewState.value = _viewState.value.copy(
            useNumbers = !viewState.value.useNumbers,
        )
    }

    fun toggleUseUppercase() {
        _viewState.value = _viewState.value.copy(
            useUppercase = !viewState.value.useUppercase,
        )
    }

    fun toggleUseSpecialChars() {
        _viewState.value = _viewState.value.copy(
            useSpecialChars = !viewState.value.useSpecialChars,
        )
    }

    fun changePasswordLength(passwordLength: Int) {
        _viewState.value = _viewState.value.copy(
            passwordLength = passwordLength,
        )
    }

    fun generatePassword() {
        val ranges = mutableListOf('a'..'z')
        if (_viewState.value.useNumbers) {
            ranges.add('0'..'9')
        }
        if (_viewState.value.useSpecialChars) {
            ranges.add('!'..'/')
        }
        if (_viewState.value.useUppercase) {
            ranges.add('A'..'Z')
        }

        val password = CharArray(_viewState.value.passwordLength) {
            val range = ranges.random(random)
            range.random(random)
        }

        _viewState.value = _viewState.value.copy(
            password = password.joinToString(separator = "")
        )
    }
}
