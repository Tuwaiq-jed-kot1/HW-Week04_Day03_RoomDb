package com.myprojects.wk4d3hw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Observer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = WordListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        private val wordViewModel: WordViewModel by viewModels {
            WordViewModelFactory((application as WordsApplication).repository)
        }

        wordViewModel.allWords.observe(this, Obser { words ->
            // Update the cached copy of the words in the adapter.
            words?.let { adapter.submitList(it) }
        })
    }


}