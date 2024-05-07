package com.example.spartasearchimage.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.spartasearchimage.databinding.SearchimagesitemBinding

class SearchRecyclerViewAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): searchViewHolder {
       return searchViewHolder(
           SearchimagesitemBinding.inflate(
               LayoutInflater.from(parent.context),
               parent,
               false
           )
       )
    }

    class searchViewHolder(val itemBinding:SearchimagesitemBinding):ViewHolder(itemBinding.root){
        //fun bindItem()
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}