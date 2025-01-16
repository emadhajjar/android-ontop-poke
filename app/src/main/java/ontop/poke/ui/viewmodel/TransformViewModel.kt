package ontop.poke.ui.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import ontop.poke.ui.viewstate.TransformViewState

class TransformViewModel : ViewModel() {
    private val _viewState = mutableStateOf(TransformViewState())
    val viewState: State<TransformViewState> = _viewState

    private fun transform(text: String): String {
        val result = StringBuilder()
        var capitalizeNext = true

        for (char in text) {
            if (char.isWhitespace()) {
                capitalizeNext = true
                result.append(char)
            } else {
                if (capitalizeNext) {
                    result.append(char.uppercaseChar())
                    capitalizeNext = false
                } else {
                    result.append(char)
                }
            }
        }

        return result.toString()
    }

    fun changeText(text: String) {
        _viewState.value = _viewState.value.copy(
            text = text,
            transformedText = transform(text),
        )
    }
}
