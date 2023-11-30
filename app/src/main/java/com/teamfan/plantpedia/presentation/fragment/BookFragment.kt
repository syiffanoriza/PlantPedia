package com.teamfan.plantpedia.presentation.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.teamfan.plantpedia.R
import com.teamfan.plantpedia.adapter.BookAdapter
import com.teamfan.plantpedia.databinding.FragmentBookBinding
import com.teamfan.plantpedia.presentation.BooksViewModel

class BookFragment : Fragment() {
    private var _binding: FragmentBookBinding? = null
    private val binding get() = _binding as FragmentBookBinding
    private var _booksViewModel: BooksViewModel? = null
    private val booksViewModel get() = _booksViewModel as BooksViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBookBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _booksViewModel = ViewModelProvider(this)[BooksViewModel::class.java]
        booksViewModel.showBooks()
        booksViewModel.books.observe(viewLifecycleOwner) {
            val mAdapter = BookAdapter()
            mAdapter.setData(it.books)
            Log.i(
                "BookFragment",
                "onViewCreated: ${it.books}"
            )
            binding.
        }
    }
}