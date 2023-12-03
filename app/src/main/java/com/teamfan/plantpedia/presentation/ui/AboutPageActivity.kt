package com.teamfan.plantpedia.presentation.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.teamfan.plantpedia.R
import com.teamfan.plantpedia.databinding.ActivityAboutPageBinding

class AboutPageActivity : AppCompatActivity() {
    private var _binding: ActivityAboutPageBinding? = null
    private val binding get() = _binding as ActivityAboutPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityAboutPageBinding.inflate(layoutInflater)
        setSupportActionBar(binding.toolbarAbout)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "About the App"
        }
        setContentView(binding.root)

        Toast.makeText(this, "Check us out on Github!", Toast.LENGTH_SHORT).show()

        binding.btnGithub.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://github.com/syiffanoriza/PlantPedia")
            })
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }

}