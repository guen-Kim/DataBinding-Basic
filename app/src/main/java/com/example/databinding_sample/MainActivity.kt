package com.example.databinding_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
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

        val userList= ObservableArrayList<Any>().apply {
            add("kim")
            add("guen")
            add(30)
        }
        binding.user = userList

        // Update UI
        CoroutineScope(Main).launch {
            delay(5000)
            with(userList) {
                add("pack")
                add("guen")
                add(15)
            }
        }

    }
}



