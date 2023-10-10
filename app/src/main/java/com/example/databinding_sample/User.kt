package com.example.databinding_sample

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class User(name: String, firstName: String) : BaseObservable() {

    // 데이터 변경 시 알림을 수신 하고자 하는 필드에 Bindable annotation 추가
    //
    @get:Bindable
   var name: String = name
        set(value) { // custom Setter
            field = value
            notifyPropertyChanged(BR.name)
        }

    @get:Bindable
    var firstName: String = firstName
        set(value) { // custom Setter
            field = value
            notifyPropertyChanged(BR.firstName)
        }


}