package com.example.voxsmart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userNumber = "+447123456789"
        val dailledNumber = "07123456789"


        val countryCodes = HashMap<String, Int>()
        val prefixes = HashMap<String, String>()

        val parser = NumberParser(countryCodes, prefixes)

        Log.d("International Format", parser.parse(dailledNumber, userNumber))


    }
}
