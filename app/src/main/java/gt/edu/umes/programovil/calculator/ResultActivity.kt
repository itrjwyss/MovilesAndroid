package gt.edu.umes.programovil.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import gt.edu.umes.programovil.databinding.ActivityResultBinding

class ResultActivity : ComponentActivity() {

    private lateinit var binding: ActivityResultBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvResult.text = "${intent.extras?.getDouble("RESULT")}"
    }
}
