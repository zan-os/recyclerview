package com.example.fragmentrecycleview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentrecycleview.databinding.ItemContainerBinding
import com.example.fragmentrecycleview.model.Contact
import com.example.fragmentrecycleview.ui.HomeFragmentDirections

class ContactAdapter(private val listContact: ArrayList<Contact>) :
    RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            ItemContainerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact: Contact = listContact[position]
        holder.binding(contact)

        holder.itemView.setOnClickListener {
            val data = Contact(
                listContact[holder.absoluteAdapterPosition].name,
                listContact[holder.absoluteAdapterPosition].phoneNumber
            )
            val direction = HomeFragmentDirections.actionHomeFragmentToDetailFragment(data)

            it.findNavController().navigate(direction)
        }
    }

    override fun getItemCount(): Int = listContact.size

    class ViewHolder(private val itemBinding: ItemContainerBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun binding(contact: Contact) {
            itemBinding.nameTextView.text = contact.name
            itemBinding.numberTextView.text = contact.phoneNumber.toString()
        }
    }

}