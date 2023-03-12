package com.example.catfact

import android.os.Bundle
import android.os.CountDownTimer
import android.os.SystemClock
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Chronometer
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.catfact.api.ApiFactory
import com.example.catfact.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import java.util.Timer

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            lifecycleScope.launch {
                load()
            }
        }
    }

    private suspend fun load() {
        binding.chronometer.base = SystemClock.elapsedRealtime()
        binding.chronometer.start()
        binding.tvCatFact.visibility = INVISIBLE
        runOnUiThread {
            binding.catImageView.visibility = VISIBLE
        }
        binding.button.isEnabled = false
        val retrofit = ApiFactory.getApiService().loadCatFact()
        binding.tvCatFact.text = retrofit.fact
        binding.chronometer.stop()
        runOnUiThread {
            binding.catImageView.visibility = INVISIBLE
        }
        binding.button.isEnabled = true
        binding.tvCatFact.visibility = VISIBLE
    }
}