package com.example.databinding_sample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.databinding_sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding  =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.user = User("kim", "Guen", 15)
        binding.presenter = Presenter()
    }
}

class Presenter {
    fun onToastClick(view: View,user: User) {
        Toast.makeText(view.context, "${user.firstName}, ${user.lastName}", Toast.LENGTH_SHORT).show()
    }
}


data class User(val firstName: String, val lastName: String, val age: Int) {

}

