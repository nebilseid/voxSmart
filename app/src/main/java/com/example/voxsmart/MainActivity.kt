package com.example.voxsmart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userNumber = "+447123456789"
        val dailedNumber = "07123456789"


        val countryCodes = HashMap<String, Int>()
        val prefixes = HashMap<String, String>()

        countryCodes["GB"] = 44
        countryCodes["US"] = 1
        countryCodes["FR"] = 33
        countryCodes["IT"] = 39
        countryCodes["IN"] = 91
        countryCodes["CN"] = 86

        prefixes["GB"] = "0"
        prefixes["US"] = "1"
        prefixes["FR"] = "0"
        prefixes["CN"] = "0"
        prefixes["IT"] = "0"
        prefixes["IN"] = "0"
        val parser = NumberParser(countryCodes, prefixes)

        Log.d("International Format", parser.parse(dailedNumber, userNumber))


    }
}
