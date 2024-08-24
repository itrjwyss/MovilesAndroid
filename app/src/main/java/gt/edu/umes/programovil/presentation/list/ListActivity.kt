package gt.edu.umes.programovil.presentation.list

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import gt.edu.umes.programovil.databinding.ActivityListBinding
import org.koin.android.ext.android.inject

class ListActivity: ComponentActivity() {

    private val viewModel: ListViewModel by inject()
    private lateinit var binding: ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.all.observe(this) { list ->
            binding.rvInfoList.apply {
                layoutManager = LinearLayoutManager(this@ListActivity)
                addItemDecoration(
                    DividerItemDecoration(
                        this@ListActivity,
                        DividerItemDecoration.VERTICAL
                    )
                )
                adapter = ListRecyclerAdapter(
                    context = this@ListActivity,
                    list = list
                )
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadData()
    }
}
