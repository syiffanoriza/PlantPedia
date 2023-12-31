package com.teamfan.plantpedia.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.teamfan.plantpedia.R
import com.teamfan.plantpedia.databinding.BookItemAltBinding
import com.teamfan.plantpedia.databinding.BookItemBinding
import com.teamfan.plantpedia.network.BookItem
import com.teamfan.plantpedia.presentation.ui.DetailActivity

class SearchAdapter: RecyclerView.Adapter<SearchAdapter.BookViewHolder>() {
    private val listData = ArrayList<BookItem>()
    class BookViewHolder(var binding: BookItemAltBinding) : RecyclerView.ViewHolder(binding.root)

    fun setData(list: List<BookItem>?) {
        if (list == null) return
        listData.clear()
        listData.addAll(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BookViewHolder (
        BookItemAltBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount(): Int = listData.size

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val books = listData[position]

        holder.binding.apply {
            val image = books.volumeInfo?.imageLinks?.thumbnail
            Log.d(
                "SearchAdapter",
                "Thumbnail Image URL: $image"
            )
            tvTitle.text = books.volumeInfo?.title
            tvAuthor.text = books.volumeInfo?.authors?.first()
            tvDescription.text = books.volumeInfo?.description
            Picasso.get()
                .load(image)
                .resize(2048, 1600)
                .onlyScaleDown()
                .placeholder(R.drawable.ic_logo)
                .into(ivBook)
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.BOOK_DATA, books)
            it.context.startActivity(intent)
        }
    }
}