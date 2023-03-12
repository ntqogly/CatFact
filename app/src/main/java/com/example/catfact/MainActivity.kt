package com.example.catfact

import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.catfact.api.ApiFactory
import com.example.catfact.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var catAdapter: CatAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        catAdapter = CatAdapter()
        binding.rvCatFacts.layoutManager = LinearLayoutManager(this)
        binding.rvCatFacts.adapter = catAdapter

        binding.buttonFact.setOnClickListener {
            lifecycleScope.launch {
                loadFact()
            }
        }
//        binding.buttonBreeds.setOnClickListener {
//            lifecycleScope.launch {
//
//            }
//        }

    }

    private suspend fun loadFact() {
        binding.buttonFact.isEnabled = false
        binding.chronometer.base = SystemClock.elapsedRealtime()
        binding.chronometer.start()
//        binding.rvCatFacts.visibility = INVISIBLE
        binding.catImageView.visibility = VISIBLE
        val factsS = ApiFactory.getApiService().loadCatFact()
        binding.apply {
            catAdapter.
        }
        binding.chronometer.stop()
        binding.catImageView.visibility = INVISIBLE
        binding.buttonFact.isEnabled = true
        binding.rvCatFacts.visibility = VISIBLE
    }

//    private suspend fun loadFacts() {
//        val facts = ApiFactory.getApiService().loadListOfCatFacts()

}