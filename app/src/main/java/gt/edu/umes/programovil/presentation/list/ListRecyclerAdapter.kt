package gt.edu.umes.programovil.presentation.list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import gt.edu.umes.programovil.data.InformationEntity
import gt.edu.umes.programovil.databinding.ItemPictureBinding

class ListRecyclerAdapter(
    private val context: Context,
    val list: List<InformationEntity>
): RecyclerView.Adapter<ListRecyclerAdapter.PictureHolder>() {

    inner class PictureHolder(val binding: ItemPictureBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PictureHolder(ItemPictureBinding.inflate(LayoutInflater.from(parent.context)))

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: PictureHolder, position: Int) {
        val info = list[position]

        holder.binding.tvDescription.text = info.description
        Glide.with(context)
            .load(info.path)
            .fitCenter()
            .into(holder.binding.ivPicture)
    }
}
