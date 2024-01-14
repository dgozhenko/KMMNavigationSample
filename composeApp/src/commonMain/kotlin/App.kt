import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import common.navigation.RootComponent
import org.jetbrains.compose.resources.ExperimentalResourceApi
import feature.edit.presentation.EditScreen
import feature.result.presentation.ResultScreen

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App(rootComponent: RootComponent) {
    MaterialTheme {
        val childStack by rootComponent.childStack.subscribeAsState()
        Children(
            stack = childStack,
            animation = stackAnimation(fade())
        ) { child ->
            when (val instance = child.instance) {
                is RootComponent.Child.EditScreen -> EditScreen(component = instance.component)
                is RootComponent.Child.ResultScreen -> ResultScreen(component = instance.component)
            }
        }
    }
}