package com.db8.demoapp.data.ui

import android.util.Log
import androidx.lifecycle.*
import com.db8.demoapp.data.model.Home
import com.db8.demoapp.data.network.RetrofitBuilder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.lang.Exception

class HomeViewModel : ViewModel() {

    private val _result: MutableLiveData<Home> = MutableLiveData()
    val result = _result.asFlow()

    init {
        getHome()
    }

    private fun getHome() = viewModelScope.launch {
        try {
            val data = RetrofitBuilder.apiService.getHome()
            _result.value = data
            Log.d("main", "${data.availableProducts[0].price}")
        } catch (e: Exception) {
            e.printStackTrace()
            Log.d("main", "getHome: ${e.message}")
        }
    }
}