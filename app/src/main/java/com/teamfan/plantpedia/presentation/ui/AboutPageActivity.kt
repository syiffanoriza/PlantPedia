package com.teamfan.plantpedia.presentation.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.teamfan.plantpedia.R

class AboutPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_page)

        val btnOpenUrl: Button = findViewById(R.id.btn_github)

        btnOpenUrl.setOnClickListener {
            val openUrl = Intent(android.content.Intent.ACTION_VIEW)
            openUrl.data = Uri.parse("https://github.com/syiffanoriza/PlantPedia")

            startActivity(openUrl)
        }
    }


}