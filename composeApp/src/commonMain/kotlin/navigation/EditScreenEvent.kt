package navigation

sealed class EditScreenEvent {
    data object ClickSendButton: EditScreenEvent()
    data class UpdateText(val text: String): EditScreenEvent()
}