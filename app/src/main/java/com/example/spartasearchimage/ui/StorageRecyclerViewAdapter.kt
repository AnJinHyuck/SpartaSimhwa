package com.example.spartasearchimage.ui

import android.app.appsearch.StorageInfo
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.spartasearchimage.data.DocumentResponse
import com.example.spartasearchimage.databinding.FragmentStorageBinding
import com.example.spartasearchimage.databinding.StorageitemBinding
import java.text.SimpleDateFormat
import java.util.Locale

class StorageRecyclerViewAdapter(
    private val storageItem: MutableList<DocumentResponse>,
    private val listener: OnClickListener
) : RecyclerView.Adapter<StorageRecyclerViewAdapter.ViewHolder>() {
    fun updateItems(newItems: List<DocumentResponse>) {
        storageItem.clear()
        storageItem.addAll(newItems)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = StorageitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindStorageItem(storageItem[position])
    }

    override fun getItemCount(): Int {
        return storageItem.size
    }

    class ViewHolder(private val binding: StorageitemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindStorageItem(item: DocumentResponse) {
            Glide.with(binding.root.context)
                .load(item.thumbnailUrl)
                .into(binding.ivstorageImage)

            binding.tvfromWhereInStorage.text = item.displaySitename
            item.datetime?.let {
                val fromat = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
                binding.tvwhenInStorage.text = fromat.format(it)
            }


        }
    }

}