package com.example.random_movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    lateinit var movies: Array<String>
    lateinit var showed: IntArray

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        textView.setText(R.string.empty)
        movies = resources.getStringArray(R.array.movies)
        showed = IntArray(movies.size) {0}
    }

    fun onClickNext(view: View) {

        if (showed.sum() == showed.size - 1) {
            textView.setText(R.string.end)
            return
        }

        var randNum = Random.nextInt(showed.size)
        while (showed[randNum] != 0) {
            randNum = Random.nextInt(showed.size)
        }
        showed[randNum] = 1
        textView.setText(movies[randNum])
    }

    fun onClickReset(view: View) {
        showed = IntArray(movies.size) {0}
        textView.setText(R.string.empty)
    }
}