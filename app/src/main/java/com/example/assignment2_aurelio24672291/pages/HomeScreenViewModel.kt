package com.example.assignment2_aurelio24672291.pages

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment2_aurelio24672291.network.RestfulApiDevRetrofitClient
import com.vu.androidbasicapp.home.data.ResponseItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class HomeScreenViewModel: ViewModel() {

    val greetingText = MutableStateFlow("Hello Class")
    val apiResponseObjects = MutableStateFlow<List<ResponseItem>>(listOf())
    val restfulDevApiService = RestfulApiDevRetrofitClient().apiService

    init {
        Log.d("nit3213", "HomeScreenViewModel ViewModel injected ")

        viewModelScope.launch {
            val result = restfulDevApiService.getAllObjects()
            apiResponseObjects.value = result
        }
    }

    private fun updateGreetingTextState(value: String) {
        greetingText.value = value
    }
}