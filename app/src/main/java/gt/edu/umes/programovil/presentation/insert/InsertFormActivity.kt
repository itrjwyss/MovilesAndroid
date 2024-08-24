package gt.edu.umes.programovil.presentation.insert

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import gt.edu.umes.programovil.databinding.ActivityInsertFormBinding
import gt.edu.umes.programovil.domain.DomainResult
import gt.edu.umes.programovil.util.FullPathUtil
import org.koin.android.ext.android.inject

class InsertFormActivity: ComponentActivity() {

    private val viewModel: InsertFormViewModel by inject()
    private lateinit var binding: ActivityInsertFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInsertFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (!allPermissionsGranted()) {
            requestPermissions()
        }

        binding.btnSelectPicture.setOnClickListener { takePhoto() }
        binding.btnSave.setOnClickListener {
            viewModel.insertInformation(
                description = binding.etDescription.text.toString(),
                path = FullPathUtil.mCurrentPhotoPath!!
            )
        }

        viewModel.domainState.observe(this) {
            when (it!!) {
                is DomainResult.Error -> {
                    val builder = AlertDialog.Builder(this)
                    val data = it as DomainResult.Error
                    builder.setCancelable(false)
                    builder.setMessage(data.message)
                    builder.setNeutralButton("Aceptar") { dialog, _ -> dialog.dismiss() }
                    builder.create().show()
                }

                DomainResult.Loading -> Toast.makeText(
                    this,
                    "Guardando información ...",
                    Toast.LENGTH_SHORT
                ).show()

                is DomainResult.Message -> {
                    val builder = AlertDialog.Builder(this)
                    val data = it as DomainResult.Message
                    builder.setCancelable(false)
                    builder.setMessage(data.message)
                    builder.setNeutralButton("Aceptar") { dialog, _ ->
                        binding.etDescription.text.clear()
                        Glide.with(baseContext)
                            .clear(binding.ivPicture)

                        dialog.dismiss()
                    }
                    builder.create().show()
                }
            }
        }
    }

    private val activityResultLauncher = registerForActivityResult(
        RequestMultiplePermissions()
    ) { permissions ->
        var permissionGranted = true

        permissions.entries.forEach { permission ->
            if (permission.key in REQUIRED_PERMISSIONS && !permission.value)
                permissionGranted = false
        }

        if (!permissionGranted) {
            Toast.makeText(
                baseContext,
                "Los permisos han sido negados.",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private val takePictureResultLauncher = registerForActivityResult(
        StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            Glide.with(baseContext)
                .load(FullPathUtil.mCurrentPhotoPath)
                .fitCenter()
                .into(binding.ivPicture)
        }
    }

    private fun takePhoto() {
        FullPathUtil.takePicture(this, takePictureResultLauncher)
    }

    private fun requestPermissions() {
        activityResultLauncher.launch(REQUIRED_PERMISSIONS)
    }

    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(baseContext, it) == PackageManager.PERMISSION_GRANTED
    }

    companion object {
        private val REQUIRED_PERMISSIONS = mutableListOf(
            Manifest.permission.CAMERA
        ).apply {
            if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.P) {
                add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            }
        }.toTypedArray()
    }
}
