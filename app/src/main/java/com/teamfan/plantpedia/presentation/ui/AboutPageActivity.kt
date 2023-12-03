package com.teamfan.plantpedia.presentation.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.teamfan.plantpedia.R
import com.teamfan.plantpedia.databinding.ActivityAboutPageBinding

class AboutPageActivity : AppCompatActivity() {
    private var _binding: ActivityAboutPageBinding? = null
    private val binding get() = _binding as ActivityAboutPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityAboutPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGithub.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://github.com/syiffanoriza/PlantPedia")
            })
        }
    }


}