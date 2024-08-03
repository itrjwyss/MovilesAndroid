package gt.edu.umes.programovil.calculator

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import gt.edu.umes.programovil.ResultActivity
import gt.edu.umes.programovil.databinding.ActivityCalculatorBinding

class CalculatorActivity : ComponentActivity() {

    private lateinit var binding: ActivityCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPlus.setOnClickListener {
            processOperation(operation = ::plus)
        }

        binding.btnMinus.setOnClickListener {
            processOperation(operation = ::minus)
        }

        binding.btnMultiplication.setOnClickListener {
            processOperation(operation = ::multiplication)
        }

        binding.btnDivision.setOnClickListener {
            processOperation(operation = ::division)
        }
    }

    private fun processOperation(operation: (Double, Double) -> Double) {
        if (
            !binding.etFirstNumber.text.isNullOrBlank() &&
            !binding.etSecondNumber.text.isNullOrBlank()
        ) {
            val firstNumber = binding.etFirstNumber.text.toDouble()
            val secondNumber = binding.etSecondNumber.text.toDouble()
            val result = operation(firstNumber, secondNumber)

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("RESULT", result)
            startActivity(intent)

            binding.etFirstNumber.text.clear()
            binding.etSecondNumber.text.clear()
            binding.etSecondNumber.clearFocus()
        } else {
            Toast.makeText(this, "Ambos números son requeridos", Toast.LENGTH_LONG).show()
        }
    }

    private fun plus(firstNumber: Double, secondNumber: Double) =
        firstNumber + secondNumber

    private fun minus(firstNumber: Double, secondNumber: Double) =
        firstNumber - secondNumber

    private fun multiplication(firstNumber: Double, secondNumber: Double) =
        firstNumber * secondNumber

    private fun division(firstNumber: Double, secondNumber: Double) =
        firstNumber / secondNumber
}

fun Editable.toDouble() = this.toString().toDouble()
