package com.teamfan.plantpedia.presentation.ui

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.teamfan.plantpedia.R
import com.teamfan.plantpedia.adapter.BookAdapter
import com.teamfan.plantpedia.databinding.ActivitySearchableBinding
import com.teamfan.plantpedia.presentation.BooksViewModel

class SearchableActivity : AppCompatActivity() {

    private var _binding: ActivitySearchableBinding? = null
    private val binding get() = _binding as ActivitySearchableBinding

    private var _searchViewModel: BooksViewModel? = null
    private val searchViewModel get() = _searchViewModel as BooksViewModel

    private var querySearch: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySearchableBinding.inflate(layoutInflater)
        setContentView(binding.root)

        _searchViewModel = ViewModelProvider(this)[BooksViewModel::class.java]
        binding.loadingView.root.visibility = View.VISIBLE
        handleIntent(intent)

        searchViewModel.searchBooks.observe(this){
            binding.apply {
                if (it.items?.size == 0) {
                    tvNoBooks.text = getString(R.string.no_books_text)
                    tvNoBooks.visibility = View.VISIBLE
            } else {
                rvSearchResult.apply {
                    val mAdapter = BookAdapter()
                    mAdapter.setData(it.items)
                    adapter = mAdapter
                    layoutManager = LinearLayoutManager(this@SearchableActivity)
                    visibility = View.VISIBLE
                }
              }
            }
            binding.loadingView.root.visibility = View.GONE
        }
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        binding.searchBookView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        setIntent(intent)
    }
    fun handleIntent(intent: Intent){
        if (Intent.ACTION_SEARCH == intent.action){
            intent.getStringExtra(SearchManager.QUERY)
                ?.also { query ->
                    querySearch = query
                    binding.apply {
                        rvSearchResult.visibility = View.GONE
                        loadingView.root.visibility = View.VISIBLE
                        tvNoBooks.visibility = View.INVISIBLE
                        searchBookView.setQuery("", false)
                        searchBookView.queryHint = query
                        searchBookView.clearFocus()
                    }
                    doMySearch(query)
                }
        }
    }

    fun doMySearch(q: String){
        searchViewModel.searchBooks(q)
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}