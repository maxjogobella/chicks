package com.example.tinkoff.presentation.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tinkoff.R
import com.example.tinkoff.databinding.ActivityMainBinding
import com.example.tinkoff.presentation.fragment.MovieFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        launchOnMovieFragment()
    }

    private fun launchOnMovieFragment() {
        val movieFragment = supportFragmentManager.findFragmentById(binding.main.id)
        if (movieFragment !is MovieFragment) {
            val fragment = MovieFragment.newInstance()
            supportFragmentManager.beginTransaction()
                .replace(binding.main.id, fragment)
                .addToBackStack(null)
                .commit()
        }
    }

}