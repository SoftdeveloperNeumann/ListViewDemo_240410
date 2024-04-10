package com.example.listviewdemo

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.listviewdemo.databinding.ActivityMainBinding
import com.example.listviewdemo.databinding.ListItemBinding

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

        listView.adapter = MyAdapter()

        listView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "Es wurde der Würfel ${textArray[position]}", Toast.LENGTH_SHORT).show()
        }

    }

    private inner class MyAdapter : BaseAdapter(){ // ohne deklaration als inner ist es eine nested class ohne Zugriff auf die äußere Klasse
        val counter = textArray.size

        override fun getCount(): Int {
            return counter
        }

        override fun getItem(position: Int): Any {
            return  textArray[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val itemView = ListItemBinding.inflate(layoutInflater)
            itemView.tvImageDesc.text = textArray[position]
            itemView.imageView.setImageResource(imageArray[position])
            return itemView.root
        }
    }
}

