package com.example.urbandrive.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.urbandrive.data.User
import com.example.urbandrive.data.LoginRequest
import com.example.urbandrive.data.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class UserViewModel : ViewModel() {

    private val _userLiveData = MutableLiveData<User>()
    val userLiveData: LiveData<User> get() = _userLiveData

    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> get() = _errorLiveData

    fun registerUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response: Response<User> = RetrofitClient.apiService.registerUser(user)
                if (response.isSuccessful) {
                    _userLiveData.postValue(response.body())
                } else {
                    _errorLiveData.postValue("Error: ${response.message()}")
                }
            } catch (e: Exception) {
                _errorLiveData.postValue("Exception: ${e.message}")
            }
        }
    }

    fun loginUser(loginRequest: LoginRequest) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response: Response<User> = RetrofitClient.apiService.loginUser(loginRequest)
                if (response.isSuccessful) {
                    _userLiveData.postValue(response.body())
                } else {
                    _errorLiveData.postValue("Error: ${response.message()}")
                }
            } catch (e: Exception) {
                _errorLiveData.postValue("Exception: ${e.message}")
            }
        }
    }
}
