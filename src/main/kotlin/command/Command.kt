package command

sealed interface Command {
    fun isValid(): Boolean
}