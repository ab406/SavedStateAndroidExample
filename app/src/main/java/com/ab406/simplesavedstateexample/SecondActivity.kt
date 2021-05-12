package com.ab406.simplesavedstateexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val text = intent.getStringExtra("key")
        Log.d("TAG", "onCreate: text: $text")
        findViewById<TextView>(R.id.text).text = text

    }

}
