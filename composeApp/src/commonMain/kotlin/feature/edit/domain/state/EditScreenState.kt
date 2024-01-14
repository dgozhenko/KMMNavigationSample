package feature.edit.domain.state

data class EditScreenState(
    val text: String,
    val events: List<Event> = listOf()
) {
    sealed class Event {

    }

    operator fun plus(event: Event) = this.copy(events = events + event)
    operator fun minus(event: Event) = this.copy(events = events - event)
}
