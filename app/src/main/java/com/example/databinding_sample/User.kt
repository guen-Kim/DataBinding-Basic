package com.example.databinding_sample

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

data class User1(private var firstName: String, private var lastName: String) : BaseObservable() {

    // 데이터 변경 시 알림을 수신 하고자 하는 필드에 Bindable annotation 추가
    @Bindable
    fun getFirstName() = firstName

    @Bindable
    fun getLastName() = lastName


    fun setFirstName(firstName: String) {
        this.firstName = firstName
        // 데이터 변경을 알린다.
        notifyPropertyChanged(BR.firstName)
    }

    fun setLastName(lastName: String) {
        this.lastName = lastName

        notifyPropertyChanged(BR.lastName)
    }

}