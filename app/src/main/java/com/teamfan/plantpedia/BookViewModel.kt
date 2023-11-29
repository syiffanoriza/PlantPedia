package com.teamfan.plantpedia

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.teamfan.plantpedia.network.ApiClient
import com.teamfan.plantpedia.network.BookResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookViewModel: ViewModel(){
    private var _searchBook = MutableLiveData<BookResponse>()
    val searchBook get() = _searchBook as LiveData<BookResponse>

    fun searchNews(q: String) {
        ApiClient.provideApiService().getPlantBooks(q)
            .enqueue(object : Callback<BookResponse> {
                override fun onResponse(
                    call: Call<BookResponse>,
                    response: Response<BookResponse>
                ) {
                    if (response.isSuccessful){
                        Log.i(
                            "ViewModel",
                            "onResponse: ${response.body()}"
                        )
                        _searchBook.postValue(response.body())
                    } else Log.e(
                        "ViewModel",
                        "onResponse: Call error with HTTP status code" + response.code()
                    )
                }

                override fun onFailure(call: Call<BookResponse>, t: Throwable) {
                    Log.e(
                        "ViewModel",
                        "onFailure: " + t.localizedMessage
                    )
                }
            })
    }
}