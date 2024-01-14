package navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

class EditScreenComponent(
    componentContext: ComponentContext,
    private val onNavigateToResultScreen: (String) -> Unit
): ComponentContext by componentContext {
    private var _text = MutableValue("")
    val text: Value<String> = _text
    
    fun onEvent(event: EditScreenEvent) {
        when(event) {
            EditScreenEvent.ClickSendButton -> onNavigateToResultScreen(text.value)
            is EditScreenEvent.UpdateText -> TODO()
        }
    }
}