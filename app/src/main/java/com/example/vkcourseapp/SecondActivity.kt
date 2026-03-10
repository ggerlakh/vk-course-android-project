package com.example.vkcourseapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.vkcourseapp.databinding.ActivitySecondBinding
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.vkcourseapp.ui.theme.VkCourseAppTheme

class SecondActivity : ComponentActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val receivedText = intent.getStringExtra("USER_TEXT")

        binding.textViewReceived.text = receivedText

    }
}
