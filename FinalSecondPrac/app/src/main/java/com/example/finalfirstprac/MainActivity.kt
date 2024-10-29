package com.example.finalfirstprac

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var mViewModel: MainViewModel
    private lateinit var textViewTimer: TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val to_sec_btn : Button = findViewById(R.id.to_sec_btn)
        textViewTimer = findViewById(R.id.textViewTimer)
        to_sec_btn.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

    }


    override fun onStart() {
        super.onStart()

        mViewModel.liveData.observe(this, Observer{
            textViewTimer.text = it
        })
    }
}