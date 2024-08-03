package gt.edu.umes.programovil

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import gt.edu.umes.programovil.calculator.CalculatorActivity
import gt.edu.umes.programovil.imc.ImcActivity
import gt.edu.umes.programovil.ui.theme.PrograMovilTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrograMovilTheme {
                Greeting()
            }
        }
    }
}

@Composable
fun Greeting() {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = colorResource(id = R.color.background_screen)
            ),
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center)
        ) {
            ElevatedButton(
                onClick = {
                    context.startActivity(Intent(context, CalculatorActivity::class.java))
                }
            ) {
                Text(
                    text = "Calculadora"
                )
            }

            ElevatedButton(
                onClick = {
                    context.startActivity(Intent(context, ImcActivity::class.java))
                }
            ) {
                Text(text = "Cálculo IMC")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PrograMovilTheme {
        Greeting()
    }
}