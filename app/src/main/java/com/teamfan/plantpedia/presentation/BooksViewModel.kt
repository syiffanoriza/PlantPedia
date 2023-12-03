package com.teamfan.plantpedia.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.teamfan.plantpedia.network.ApiClient
import com.teamfan.plantpedia.network.BookResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksViewModel: ViewModel() {
    private var _books = MutableLiveData<BookResponse>()
    val books get() = _books as LiveData<BookResponse>

    private var _searchBooks = MutableLiveData<BookResponse>()
    val searchBooks get() = _searchBooks as LiveData<BookResponse>

    fun showBooks() {
        ApiClient.provideApiService().getPlantBooks()
            .enqueue(object : Callback<BookResponse> {
                override fun onResponse(
                    call: Call<BookResponse>,
                    response: Response<BookResponse>
                ) {
                    if (response.isSuccessful){
                        Log.i(
                            "ViewModel",
                            "onResponse: Call success with HTTP status code ${response.body()}"
                        )
                        _books.postValue(response.body())
                    } else Log.e(
                        "ViewModel",
                        "onResponse: Call error with HTTP status code ${response.code()}"
                    )
                }

                override fun onFailure(call: Call<BookResponse>, t: Throwable) {
                    Log.e(
                        "ViewModel",
                        "onFailure: ${t.localizedMessage}"
                    )
                }
            })
    }

    fun searchBooks(q: String) {
        ApiClient.provideApiService().getSearchBooks(q)
            .enqueue(object :Callback<BookResponse>{
                override fun onResponse(
                    call: Call<BookResponse>,
                    response: Response<BookResponse>
                ) {
                    if (response.isSuccessful){
                        Log.i(
                            "ViewModel",
                            "onResponse: Call error with HTTP status code" + response.code()
                        )
                        _searchBooks.postValue(response.body())
                   } else Log.e(
                       "ViewModel",
                       "onFailure: " + response.code()
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