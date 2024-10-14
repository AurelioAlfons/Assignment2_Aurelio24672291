package com.example.assignment2_aurelio24672291.pages

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment2_aurelio24672291.data.ResponseItem
import com.example.assignment2_aurelio24672291.network.RestfulApiDevRetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class DashScreenViewModel: ViewModel() {

    val greetingText = MutableStateFlow("Hello Class")
    val apiResponseObjects = MutableStateFlow<List<ResponseItem>>(listOf())
    val restfulDevApiService = RestfulApiDevRetrofitClient().apiService

    init {
        Log.d("nit3213", "DashboardScreenViewModel ViewModel injected ")

        viewModelScope.launch {
            val result = restfulDevApiService.getAllObjects()
            apiResponseObjects.value = result
        }
    }

    private fun updateGreetingTextState(value: String) {
        greetingText.value = value
    }
}