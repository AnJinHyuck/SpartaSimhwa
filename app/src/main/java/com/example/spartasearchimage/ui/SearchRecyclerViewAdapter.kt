package com.example.spartasearchimage.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.spartasearchimage.data.DocumentResponse
import com.example.spartasearchimage.databinding.SearchimagesitemBinding
import java.text.SimpleDateFormat
import java.util.Locale

interface OnItemClickListener {
    fun onItemClick(document: DocumentResponse)
}

class SearchRecyclerViewAdapter(
    private val searchData: MutableList<DocumentResponse>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<SearchRecyclerViewAdapter.SearchViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding =
            SearchimagesitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(binding, listener)

    }


    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bindItem(searchData[position])
    }

    override fun getItemCount(): Int {
        return searchData.size
    }

    fun updateItems(newItems: List<DocumentResponse>) {
        searchData.clear()
        searchData.addAll(newItems)
        notifyDataSetChanged()
    }

    class SearchViewHolder(
        val binding: SearchimagesitemBinding,
        private val listener: OnItemClickListener
    ) : ViewHolder(binding.root) {
        fun bindItem(item: DocumentResponse) {
            Glide.with(binding.root.context)
                .load(item.thumbnailUrl)
                .into(binding.ivsearchImage)

            binding.tvfromWhere.text = item.displaySitename
            item.datetime?.let {
                val fromat = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
                binding.tvwhen.text = fromat.format(it)
            }
            binding.root.setOnClickListener {
                listener.onItemClick(item)
            }

        }
    }


}