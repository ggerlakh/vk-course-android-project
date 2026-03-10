package com.example.vkcourseapp

import android.os.Bundle
import android.content.Intent
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.vkcourseapp.databinding.ActivityMainBinding
import androidx.core.net.toUri

class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding

    private fun isValidPhoneNumber(phone: String): Boolean {
        if (phone.isEmpty()) return false

        val allowedChars = setOf('+', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ' ', '-', '(', ')')
        val invalidChars = phone.filter { it !in allowedChars }

        if (invalidChars.isNotEmpty() ||
            (phone.contains("+") && phone.indexOf('+') != 0)) {
            return false
        }

        return when (phone.length) {
            in 10..11 -> true
            else -> false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnSecondActivity.setOnClickListener {
            val inputText = binding.editTextId.text.toString()

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("USER_TEXT", inputText)
            startActivity(intent)
        }

        binding.buttonCall.setOnClickListener {
            val phoneNumber = binding.editTextId.text.toString().trim()

            // Валидация номера телефона
            if (isValidPhoneNumber(phoneNumber)) {
                val uri = "tel:$phoneNumber".toUri()
                val intent = Intent(Intent.ACTION_DIAL, uri)

                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Нет приложения для звонков", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(
                    this,
                    "Введите корректный номер телефона\n(например: +7 XXX XXX-XX-XX)",
                    Toast.LENGTH_LONG
                ).show()

                // Подсветить поле с ошибкой
                binding.editTextId.error = "Неверный формат номера"
            }
        }

        binding.buttonShare.setOnClickListener {
            val textToShare = binding.editTextId.text.toString().trim()

            if (textToShare.isNotEmpty()) {
                val intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, textToShare)
                }
                startActivity(Intent.createChooser(intent, "Поделиться через..."))
            } else {
                Toast.makeText(this, "Введите текст", Toast.LENGTH_SHORT).show()
            }
        }
    }
}