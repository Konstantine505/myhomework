package com.example.myhomework1.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myhomework1.databinding.ActivityDestinationBinding

class DestinationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDestinationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDestinationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val number = intent.getStringExtra("number")
        val message = intent.getStringExtra("message")
        setData(number, message)

        binding.btnClear.setOnClickListener {
            emptyText()
        }

    }

    private fun setData(number: String?, message: String?) {
        with(binding) {
            if (!number.isNullOrEmpty() && !message.isNullOrEmpty()) {

                tvNumber.text = number
                tvMessage.text = message

            } else {
                emptyText()
            }
        }
    }

    private fun emptyText() {
        with(binding) {
            tvNumber.text = ""
            tvMessage.text = ""
        }
    }

}