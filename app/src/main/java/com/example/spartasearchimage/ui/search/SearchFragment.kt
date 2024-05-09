package com.example.spartasearchimage.ui.search

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.spartasearchimage.data.DocumentResponse
import com.example.spartasearchimage.databinding.FragmentSearchBinding
import com.example.spartasearchimage.ui.HeartViewModel

class SearchFragment : Fragment() {

    private val items = mutableListOf<DocumentResponse>()
    private lateinit var binding: FragmentSearchBinding
    private lateinit var searchImageAdapter: SearchRecyclerViewAdapter

    private val searchViewModel: SearchViewModel by viewModels {
        SearchViewModelFactory()
    }
    private val heartViewModel: HeartViewModel by activityViewModels()

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
        onClickListener()
        observer()

    }


    private fun onClickListener(){
        binding.btnSearch.setOnClickListener {
            val searchName = binding.svSearch.text.toString()
            searchViewModel.getKakaoList(searchName)
            hideKeyBoard()
        }


    }
    private fun observer(){
        searchViewModel.kakaoList.observe(viewLifecycleOwner) { documents ->
            documents?.let {
                searchImageAdapter.updateItems(it)
            }
        }
    }
    private fun hideKeyBoard(){
        val inputMethodManager = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(requireActivity().window.decorView.applicationWindowToken,0)
    }


    private fun setupAdapter() {
        searchImageAdapter = SearchRecyclerViewAdapter(items,
            object : SearchRecyclerViewAdapter.OnItemClickListener {
                override fun onItemClick(document: DocumentResponse) {
                    heartViewModel.addItem(document)
                }
            })
        binding.rvSearch.adapter = searchImageAdapter
    }


}