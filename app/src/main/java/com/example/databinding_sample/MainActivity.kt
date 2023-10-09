package com.example.databinding_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.DataBindingUtil
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

        val user: User = User("kim", "Guen", 15)
        binding.user = user
        binding.presenter = Presenter()

        // Update UI
        CoroutineScope(Main).launch {
            delay(5000)
            user.firstName = "pack"
            user.lastName = "android"
            user.age = 30
        }

    }
}

class Presenter {
    fun onToastClick(view: View, user: User) {
        Toast.makeText(view.context, "${user.firstName}, ${user.lastName}", Toast.LENGTH_SHORT)
            .show()
    }
}

class User(fn: String, ln: String, a: Int) : BaseObservable() {

    @get:Bindable
    var firstName: String = fn
        set(value) {
            field = value
            notifyPropertyChanged(BR.firstName)
        }

    @get:Bindable
    var lastName: String = ln
        set(value) {
            field = value
            notifyPropertyChanged(BR.lastName)
        }

    @get:Bindable
    var age: Int = a
        set(value) {
            field = value
            notifyPropertyChanged(BR.age)
        }
}





