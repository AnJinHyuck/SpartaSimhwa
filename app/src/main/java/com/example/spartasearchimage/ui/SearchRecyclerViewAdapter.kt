package com.example.spartasearchimage.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.spartasearchimage.data.DocumentResponse
import com.example.spartasearchimage.databinding.SearchimagesitemBinding
import java.text.SimpleDateFormat
import java.util.Locale
//컨텍스트 넘기면 안됨, 컨텍스트 참조 하면 먼저 제거 되어야 하는데 안 됨
class SearchRecyclerViewAdapter(private val searchData : List<DocumentResponse>) : RecyclerView.Adapter<SearchRecyclerViewAdapter.SearchViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding = SearchimagesitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(binding)

    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
       holder.bindItem(searchData[position])
    }

    override fun getItemCount(): Int {
       return searchData.size
    }



    class SearchViewHolder(val binding:SearchimagesitemBinding):ViewHolder(binding.root){
        fun bindItem( item : DocumentResponse){

            Glide.with(binding.root.context)
                .load(item.thumbnailUrl)
                .into(binding.ivsearchImage)

            binding.tvfromWhere.text = item.displaySitename
            item.datetime?.let {
                val fromat = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
                binding.tvwhen.text = fromat.format(it)
            } ?: run {
                binding.tvwhen.text = ""
            }

        }
    }

}