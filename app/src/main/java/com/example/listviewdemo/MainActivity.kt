package com.example.listviewdemo

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.listviewdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var textArray: Array<String>
    lateinit var imageArray: Array<Int>
    // optional
    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listView = binding.lvDaten

        textArray = resources.getStringArray(R.array.bild_texte)

        imageArray = arrayOf(
            R.drawable.dice1,
            R.drawable.dice2,
            R.drawable.dice3,
            R.drawable.dice4,
            R.drawable.dice5,
            R.drawable.dice6,
        )

    }

    private inner class MyAdapter{ // ohne deklaration als inner ist es eine nested class ohne Zugriff auf die äußere Klasse
        val size = textArray.size

    }
}

