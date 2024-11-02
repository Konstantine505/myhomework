package com.example.myhomework1.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myhomework1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var intent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        intent = Intent(this, DestinationActivity::class.java)
        binding.btnSend.setOnClickListener {
            handleSendClick(intent)
        }


    }


    private fun validInput(): Boolean {
        with(binding) {
            if (etNumber.text.isNullOrEmpty() || etMessage.text.isNullOrEmpty()) {
                Toast.makeText(
                    this@MainActivity,
                    "Please fill all fields!",
                    Toast.LENGTH_SHORT
                ).show()
                return false
            }
            return true
        }
    }

    private fun handleSendClick(intent: Intent) {
        if (validInput()) {
            intent.putExtra(
                "number", binding.etNumber.text.toString()
            )
            intent.putExtra(
                "message", binding.etMessage.text.toString()
            )
            startActivity(intent)
        }

    }
}