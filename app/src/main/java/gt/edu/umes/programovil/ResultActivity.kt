package gt.edu.umes.programovil

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import gt.edu.umes.programovil.databinding.ActivityResultBinding
import java.text.DecimalFormat

class ResultActivity : ComponentActivity() {

    private lateinit var binding: ActivityResultBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val result = intent.extras?.getDouble("RESULT") ?: 0.0 // Handle null case
        val formatter = DecimalFormat("#.00")
        binding.tvResult.text = formatter.format(result)
    }
}
