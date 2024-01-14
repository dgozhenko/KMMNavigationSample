package feature.edit.presentation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import feature.edit.domain.state.EditScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class EditScreenComponent(
    componentContext: ComponentContext,
    private val onNavigateToResultScreen: (String) -> Unit
): ComponentContext by componentContext {
    private val _editScreenState = MutableStateFlow(EditScreenState(text = "", events = listOf()))
    val editScreenState = _editScreenState.asStateFlow()

    fun updateTextValue(newValue: String) {
        _editScreenState.update { state ->
            state.copy(text = newValue)
        }
    }

    fun navigateToResultScreen() {
       onNavigateToResultScreen(_editScreenState.value.text)
    }
}