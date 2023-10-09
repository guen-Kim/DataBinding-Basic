package com.example.databinding_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayMap
import com.example.databinding_sample.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        val userMap= ObservableArrayMap<String, Any>().apply {
            put("firstName", "kim")
            put("lastName", "guen")
            put("age", 30)
        }
        binding.user = userMap

        // Update UI
        CoroutineScope(Main).launch {
            delay(5000)
            with(userMap) {
                put("firstName", "pack")
                put("lastName", "guen")
                put("age", 15)
            }
        }

    }
}



