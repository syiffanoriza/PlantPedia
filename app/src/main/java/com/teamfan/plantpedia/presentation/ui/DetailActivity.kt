package com.teamfan.plantpedia.presentation.ui

import android.content.Intent
import android.net.Uri
import android.opengl.Visibility
import android.os.Build.VERSION.SDK_INT
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.squareup.picasso.Picasso
import com.teamfan.plantpedia.R
import com.teamfan.plantpedia.databinding.ActivityDetailBinding
import com.teamfan.plantpedia.network.BookItem

class DetailActivity : AppCompatActivity() {
    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding as ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)

        setSupportActionBar(binding.toolbarDetail)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "Back"
        }
        setContentView(binding.root)

        @Suppress("DEPRECATION") var bookData = when {
            SDK_INT >= 33 -> intent.getParcelableExtra(BOOK_DATA, BookItem::class.java)
            else -> intent.getParcelableExtra(BOOK_DATA)
        }

        binding.apply {
            Picasso.get().load(bookData?.volumeInfo?.imageLinks?.thumbnail).into(imgBook)
            tvTitleBook.text = bookData?.volumeInfo?.title
            tvAuthorBook.text = bookData?.volumeInfo?.authors?.first()
            tvDescription.text = bookData?.volumeInfo?.description
            tvPublishAt.text = bookData?.volumeInfo?.publishedDate
            binding.loadingView.root.visibility = View.GONE
        }

        binding.btnRead.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(bookData?.volumeInfo?.previewLink)
            })
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }

    companion object {
        const val BOOK_DATA = "data"
    }
}