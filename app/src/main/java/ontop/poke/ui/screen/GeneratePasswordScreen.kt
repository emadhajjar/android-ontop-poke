package ontop.poke.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ontop.poke.ui.fragment.CheckboxText
import ontop.poke.ui.fragment.VerticalSpacer
import ontop.poke.ui.navigation.Transform
import ontop.poke.ui.viewmodel.GeneratePasswordViewModel

@Composable
fun GeneratePasswordScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val viewModel: GeneratePasswordViewModel = viewModel()
    val viewState by viewModel.viewState

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        if (viewState.password != null) {
            Text(viewState.password ?: "")
            VerticalSpacer()
        }

        Column {
            CheckboxText(
                text = "Use numbers",
                checked = viewState.useNumbers,
                onCheckedChange = { viewModel.toggleUseNumbers() }
            )

            CheckboxText(
                text = "Use Uppercase letters",
                checked = viewState.useUppercase,
                onCheckedChange = { viewModel.toggleUseUppercase() }
            )

            CheckboxText(
                text = "Use special characters",
                checked = viewState.useSpecialChars,
                onCheckedChange = { viewModel.toggleUseSpecialChars() }
            )
        }

        Slider(
            modifier = modifier
                .fillMaxWidth()
                .padding(12.dp),
            value = viewState.passwordLength.toFloat(),
            valueRange = 5f..20f,
            onValueChange = { viewModel.changePasswordLength(it.toInt()) },
        )

        Text("Length: ${viewState.passwordLength}")

        Button(
            onClick = { viewModel.generatePassword() }
        ) {
            Text("Generate Password")
        }

        Button(
            onClick = { navController.navigate(Transform) }
        ) {
            Text("Navigate to Transform")
        }
    }
}
