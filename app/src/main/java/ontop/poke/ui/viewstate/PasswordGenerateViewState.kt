package ontop.poke.ui.viewstate

data class PasswordGenerateViewState(
    val password: String? = null,
    val passwordLength: Int = 15,
    val useNumbers: Boolean = false,
    val useSpecialChars: Boolean = false,
    val useUppercase: Boolean = false,
)
