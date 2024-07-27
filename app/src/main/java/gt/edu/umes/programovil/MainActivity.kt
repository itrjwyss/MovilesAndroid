package gt.edu.umes.programovil

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import gt.edu.umes.programovil.calculator.CalculatorActivity
import gt.edu.umes.programovil.ui.theme.PrograMovilTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrograMovilTheme {
                Box(modifier = Modifier.fillMaxSize()) {
                    Greeting(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    ElevatedButton(
        modifier = modifier,
        onClick = {
            context.startActivity(Intent(context, CalculatorActivity::class.java))
        }
    ) {
        Text(text = "Calculadora")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PrograMovilTheme {
        Greeting()
    }
}