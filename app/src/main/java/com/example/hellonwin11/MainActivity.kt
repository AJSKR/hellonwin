package com.example.hellonwin11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //z:must be called before fvbid.
        val button1z = findViewById<Button>(R.id.button1z) //z:fvbid returns generic in kt. <Btn> casts return to be button type.
        button1z.setOnClickListener(object:View)
    }
}