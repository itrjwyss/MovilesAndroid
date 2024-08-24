package gt.edu.umes.programovil.presentation.imc

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import com.google.android.material.slider.Slider
import gt.edu.umes.programovil.R
import gt.edu.umes.programovil.presentation.ResultActivity
import gt.edu.umes.programovil.databinding.ActivityImcBinding
import kotlin.math.pow

class ImcActivity : ComponentActivity() {

    private lateinit var binding: ActivityImcBinding
    private var gender = ""
    private var height = 80
    private var weight = 70

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityImcBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cvMale.setOnClickListener {
            gender = "MALE"
            binding.cvMale.setCardBackgroundColor(getColor(R.color.background_selected))
            binding.cvFemale.setCardBackgroundColor(getColor(R.color.background_component))
        }

        binding.cvFemale.setOnClickListener {
            gender = "FEMALE"
            binding.cvFemale.setCardBackgroundColor(getColor(R.color.background_selected))
            binding.cvMale.setCardBackgroundColor(getColor(R.color.background_component))
        }

        binding.sliderHeight.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: Slider) { }

            override fun onStopTrackingTouch(slider: Slider) {
                height = slider.value.toInt()
                binding.tvHeightLabel.text = "$height cm"
            }
        })

        binding.fabMinus.setOnClickListener {
            if (weight > 0) {
                weight--
                binding.tvWeightLabel.text = "$weight Kg"
            }
        }

        binding.fabPlus.setOnClickListener {
            weight++
            binding.tvWeightLabel.text = "$weight Kg"
        }

        binding.bCalc.setOnClickListener {
            val result = weight / ((height / 100.0).pow(2))
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("RESULT", result)
            startActivity(intent)
        }
    }
}
