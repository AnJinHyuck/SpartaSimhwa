package com.example.spartasearchimage.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.spartasearchimage.R
import com.example.spartasearchimage.data.DocumentResponse
import com.example.spartasearchimage.databinding.FragmentSearchBinding
import com.example.spartasearchimage.databinding.FragmentStorageBinding

class StorageFragment : Fragment() {

    private val sharedViewModel: HeartViewModel by activityViewModels()
    private lateinit var binding: FragmentStorageBinding
    private lateinit var storageAdapter: StorageRecyclerViewAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStorageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        sharedViewModel.selectedItems.observe(viewLifecycleOwner) { items ->
            items?.let {
                Log.d("check","$items")
                storageAdapter.updateItems(it)
            }
        }

    }
    private fun setupRecyclerView() {
        storageAdapter = StorageRecyclerViewAdapter()
        Log.d("check3","$")
        binding.rvStorage.adapter = storageAdapter
        binding.rvStorage.layoutManager = GridLayoutManager(context, 2)
    }
}