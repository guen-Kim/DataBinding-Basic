package com.example.databinding_sample

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener

// BindingAdapter (Setter 역할, Model의 값 view으로 가져옴)
@BindingAdapter("android:text")
fun setTextString(view: EditText, contet: String) {
    var old: String = view.text.toString()
    if (old != contet) view.setText(contet)
}

// InverseBindingAdapter (Getter 역할, view의 값 Model으로 가져옴)
@InverseBindingAdapter(attribute = "android:text", event = "textAttrChanged")
fun getTextString(view: EditText): String? {    //재정의
    return view.text.toString()
}

// InverseBindingListener (InverseBindingAdpater실행 역할, android:text에 대한 속성 리스너 등록)
@BindingAdapter("textAttrChanged")
fun setTextWatcher(view: EditText, textAttrChagned: InverseBindingListener ){
    view.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) { }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            textAttrChagned?.onChange();
        }
    })
}



