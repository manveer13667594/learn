import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.learn.topics.ColorBox

@Composable
fun AlertDialogBox() {
    var showDialog by remember { mutableStateOf(false) }
    var option by remember { mutableStateOf(false) }
    Column(modifier = Modifier.padding(16.dp)) {
        Button(onClick = { showDialog = true }) {
            Text("Show Alert")
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = {
                    showDialog = false // Dismiss when touched outside
                },
                title = {
                    Text(text = "Alert Dialog Box Title")
                },
                text = {
                    Text("This is an alert dialog box. Click OK to show a colored box or Cancel to dismiss it.")
                },
                confirmButton = {
                    TextButton(onClick = {
                        option = true
                        showDialog = false
                    }
                    ) {
                        Text("OK")
                    }
                },
                dismissButton = {
                    TextButton(onClick = {
                        option = false
                        showDialog = false
                    }) {
                        Text("Cancel")
                    }
                }
            )
        }
        if (option) {
            ColorBox()
        } else {
            Text(
                text = "Click the button to show the alert dialog box.",
                modifier = Modifier.padding(16.dp),
            )
        }
        //logic to show result based on alert box option
    }
}
