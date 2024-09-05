package com.example.loyaltyapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.loyaltyapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Initialize ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get the transaction details from the Intent
        val transactionAmount = intent.getFloatExtra("amount", 0.0f)
        val transactionId = intent.getStringExtra("transactionId")

        binding.saveDiscountButton.setOnClickListener {
            val discountAmount = binding.discountAmount.text.toString().toFloatOrNull()
            if (discountAmount != null) {
                val finalAmount = transactionAmount - discountAmount
                val resultIntent = Intent().apply {
                    putExtra("transactionId", transactionId)
                    putExtra("discountAmount", discountAmount)
                    putExtra("finalAmount", finalAmount)
            }
                // Send the result back
                setResult(Activity.RESULT_OK, resultIntent)
                this.finish()  // Close the LoyaltyActivity
        }
    }
}
}
