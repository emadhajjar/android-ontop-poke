package ontop.poke.ui.fragment

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun CheckboxText(
    text: String,
    modifier: Modifier = Modifier,
    onCheckedChange: (Boolean) -> Unit,
    checked: Boolean = false,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
        )
        TextButton(
            onClick = { onCheckedChange(!checked) }
        ) {
            Text(
                text = text,
            )
        }
    }
}
