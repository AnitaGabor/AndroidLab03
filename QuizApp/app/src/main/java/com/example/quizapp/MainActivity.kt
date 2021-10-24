package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener { view ->
            val toast = Toast.makeText(applicationContext, "Loads data...", Toast.LENGTH_SHORT)
            toast.show()
            Log.i("Info", "Button Pressed");
        }
    }

}