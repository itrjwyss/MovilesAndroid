package gt.edu.umes.programovil.presentation.contact

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import gt.edu.umes.programovil.databinding.ActivityListBinding
import gt.edu.umes.programovil.databinding.DialogContactBinding

class ContactActivity: ComponentActivity() {

    private lateinit var binding: ActivityListBinding
    private lateinit var contactBinding: DialogContactBinding
    private lateinit var contactDialog: AlertDialog
    private lateinit var contactAdapter: ContactRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        contactAdapter = ContactRecyclerAdapter()
        binding.rvInfoList.apply {
            layoutManager = LinearLayoutManager(this@ContactActivity)
            addItemDecoration(
                DividerItemDecoration(
                    this@ContactActivity,
                    DividerItemDecoration.VERTICAL
                )
            )
            adapter = contactAdapter
        }

        contactBinding = DialogContactBinding.inflate(layoutInflater)
        val builder = AlertDialog.Builder(this)
        builder.setCancelable(false)
        builder.setView(contactBinding.root)

        builder.setNegativeButton("Cancelar") { dialogInterface, _ ->
            dialogInterface.cancel()
        }

        builder.setPositiveButton("Agregar") { dialogInterface, _ ->
            contactAdapter.addContact(
                ContactData(
                    name = contactBinding.etName.text.toString(),
                    number = contactBinding.etNumber.text.toString()
                )
            )

            contactBinding.etName.text.clear()
            contactBinding.etNumber.text.clear()

            dialogInterface.cancel()
        }

        contactDialog = builder.create()

        binding.fabAdd.visibility = View.VISIBLE
        binding.fabAdd.setOnClickListener {
            contactDialog.show()
        }
    }
}
