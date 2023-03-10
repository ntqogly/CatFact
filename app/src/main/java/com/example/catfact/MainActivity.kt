package com.example.catfact

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.VISIBLE
import com.example.catfact.api.ApiFactory
import com.example.catfact.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val api = ApiFactory.getApiService().loadCatFact()
                runOnUiThread {
                    binding.tvCatFact.visibility = VISIBLE
                    binding.tvCatFact.text = api.fact

                }
            }
        }
    }

}