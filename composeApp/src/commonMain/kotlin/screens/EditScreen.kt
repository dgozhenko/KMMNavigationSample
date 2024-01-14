package screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import navigation.EditScreenComponent
import navigation.EditScreenEvent

@Composable
fun EditScreen(component: EditScreenComponent) {
    val text by component.text.subscribeAsState()
    
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = {
                component.onEvent(EditScreenEvent.UpdateText(it))
            },
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        )
        Button(
            onClick = {
                component.onEvent(EditScreenEvent.ClickSendButton)
            }) {
                Text("Send results")
            }
    }
}

