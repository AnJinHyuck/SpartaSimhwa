package com.example.spartasearchimage.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spartasearchimage.data.DocumentResponse

class HeartViewModel : ViewModel() {
    private val _selectedItems = MutableLiveData<MutableList<DocumentResponse>?>(mutableListOf())
    val selectedItems: LiveData<MutableList<DocumentResponse>?> get() = _selectedItems


    fun addItem(item: DocumentResponse) {
        val heartList = _selectedItems.value
        heartList?.add(item)
        _selectedItems.value = heartList
    }

    fun removeItem(){

    }
}
