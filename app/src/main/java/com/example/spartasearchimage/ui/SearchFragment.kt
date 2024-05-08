package com.example.spartasearchimage.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.spartasearchimage.data.DocumentResponse
import com.example.spartasearchimage.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private val items = listOf<DocumentResponse>()
    private lateinit var binding: FragmentSearchBinding
    private lateinit var searchImageAdapter: SearchRecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAdapter()
    }


    private fun setupAdapter(){
        searchImageAdapter = SearchRecyclerViewAdapter(items)
        binding.rvSearch.adapter = searchImageAdapter
//      binding.rvSearch.layoutManager = GridLayoutManager(context, 2)
    }

    private fun setUpImageParameter(search:String):HashMap<String,Any> {
        return hashMapOf(
            "query" to search,
            "sort" to "accuracy",
            "page" to 1,
            "size" to 80
        )
    }


}

