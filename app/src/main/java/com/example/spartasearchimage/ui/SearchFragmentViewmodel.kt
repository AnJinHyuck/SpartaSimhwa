package com.example.spartasearchimage.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.spartasearchimage.data.DocumentResponse
import com.example.spartasearchimage.retrofit.NetWorkClient
import com.example.spartasearchimage.retrofit.NetWorkInterface
import kotlinx.coroutines.launch

class SearchViewModel(private val kakaoSearch: NetWorkInterface) : ViewModel() {
    //viewModel에서 liveData에 값 세팅
    private val _kakaoList: MutableLiveData<List<DocumentResponse>?> = MutableLiveData()
    //view에서 livedata값 observing할 것
    val kakaoList: LiveData<List<DocumentResponse>?> get() = _kakaoList


    fun getKakaoList(query:String) {
        viewModelScope.launch {
            _kakaoList.value =
                kakaoSearch.getImage(query).documents
        }
    }
}

class SearchViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(
        modelClass: Class<T>,
        extras: CreationExtras
    ): T {
        return SearchViewModel(NetWorkClient.kakaoSearch) as T
    }

}