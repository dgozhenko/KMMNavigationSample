package navigation

import com.arkivanov.decompose.ComponentContext

class ResultScreenComponent(
    val text: String,
    componentContext: ComponentContext,
    private val onBackClicked: () -> Unit,
): ComponentContext by componentContext {
    
    fun goBack() {
        onBackClicked()
    }
}
