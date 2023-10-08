package com.example.databinding_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.databinding_sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var isClicked = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.user = User("kim", "Guen", 15)
        binding.myActivity = this

        binding.btn.setOnClickListener {
            isClicked = !isClicked
        }

    }
}

data class User(val firstName: String, val lastName: String, val age: Int) {

}

