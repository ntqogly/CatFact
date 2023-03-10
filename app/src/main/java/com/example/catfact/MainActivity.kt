package com.example.catfact

import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.catfact.api.ApiFactory
import com.example.catfact.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            lifecycleScope.launch {
                binding.tvCatFact.visibility = INVISIBLE
                load()
                binding.tvCatFact.visibility = VISIBLE
            }
        }
    }

    private suspend fun load() {
        binding.catImageView.visibility = VISIBLE
        binding.button.isEnabled = false
        val retrofit = ApiFactory.getApiService().loadCatFact()
        binding.tvCatFact.text = retrofit.fact
        binding.catImageView.visibility = INVISIBLE
        binding.button.isEnabled = true
    }

}