package gt.edu.umes.programovil.presentation.contact

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import gt.edu.umes.programovil.databinding.ItemContactBinding

@SuppressLint("NotifyDataSetChanged")
class ContactRecyclerAdapter(): RecyclerView.Adapter<ContactRecyclerAdapter.ContactHolder>() {

    private val list = mutableListOf<ContactData>()

    inner class ContactHolder(val binding: ItemContactBinding): RecyclerView.ViewHolder(binding.root)

    fun addContact(contact: ContactData) {
        list.add(contact)
        notifyDataSetChanged()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ContactHolder(ItemContactBinding.inflate(LayoutInflater.from(parent.context)))

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        val contact = list[position]

        holder.binding.tvName.text = contact.name
        holder.binding.tvNumber.text = contact.number
    }
}
