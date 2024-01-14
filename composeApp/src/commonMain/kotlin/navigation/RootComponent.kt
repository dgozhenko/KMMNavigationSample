package navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.stack.*
import kotlinx.serialization.Serializable

class RootComponent(
    componentContext: ComponentContext
) : ComponentContext by componentContext {
    private val navigation = StackNavigation<Configuration>()
    
    val childStack = childStack(
        source = navigation,
        serializer = Configuration.serializer(),
        initialConfiguration = Configuration.EditScreen,
        handleBackButton = true,
        childFactory = ::createChild
    )
    
    @OptIn(ExperimentalDecomposeApi::class)
    private fun createChild(
        configuration: Configuration,
        context: ComponentContext
    ): Child {
        return when (configuration) {
            Configuration.EditScreen -> {
                Child.EditScreen(EditScreenComponent(componentContext = context, onNavigateToResultScreen = { text ->
                    navigation.pushNew(Configuration.ResultScreen(text = text))
                }))
            }
            is Configuration.ResultScreen -> Child.ResultScreen(
                ResultScreenComponent(
                    text = configuration.text,
                    componentContext = context,
                    onBackClicked = {
                        navigation.pop()
                    }
                )
            )
        }
    }

    sealed class Child {
        data class EditScreen(val component: EditScreenComponent) : Child()
        data class ResultScreen(val component: ResultScreenComponent) : Child()
    }

    @Serializable
    sealed class Configuration {
        @Serializable
        data object EditScreen : Configuration()

        @Serializable
        data class ResultScreen(val text: String) : Configuration()
    }
}