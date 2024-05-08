package com.example.spartasearchimage.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.spartasearchimage.data.DocumentResponse
import com.example.spartasearchimage.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private val items = mutableListOf<DocumentResponse>()
    private lateinit var binding: FragmentSearchBinding
    private lateinit var searchImageAdapter: SearchRecyclerViewAdapter

    private val searchViewModel : SearchViewModel by viewModels {
        SearchViewModelFactory()
    }

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

        searchViewModel.kakaoList.observe(viewLifecycleOwner) {documents ->
            documents?.let {
                searchImageAdapter.updateItems(it)
            }
            Log.d("", this.toString())
            //TODO RecyclerView 값 setting -> notify, 전역으로 선언 된 recyclerview list에 값 세팅 해주던지,,
        }
        searchViewModel.getKakaoList("아이브")
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