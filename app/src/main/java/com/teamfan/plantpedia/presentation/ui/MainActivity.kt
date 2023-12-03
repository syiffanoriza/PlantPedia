package com.teamfan.plantpedia.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.teamfan.plantpedia.R
import com.teamfan.plantpedia.databinding.ActivityMainBinding
import com.teamfan.plantpedia.presentation.fragment.BookFragment

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentManager = supportFragmentManager
        val bookFragment = BookFragment()

        fragmentManager
            .beginTransaction()
            .add(R.id.fl_books, bookFragment, BookFragment::class.java.simpleName)
            .commit()
     }
}