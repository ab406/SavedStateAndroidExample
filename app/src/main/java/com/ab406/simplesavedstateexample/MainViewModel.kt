package com.ab406.simplesavedstateexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class MainViewModel(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val savedImage: LiveData<String> = savedStateHandle.getLiveData(KEY)

    fun saveImage(imageTag: String) {
        savedStateHandle.set(KEY, imageTag)
    }

    companion object {
        private const val KEY = "Saved_Image"
    }
}
