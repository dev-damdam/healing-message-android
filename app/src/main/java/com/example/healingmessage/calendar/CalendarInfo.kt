package com.example.healingmessage.calendar

import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter

data class CalendarInfo(var id: String = "", var month: Int = 0, var dayOfMonth: Int = 0, var dayOfWeek: Int = 0, var emotion: Drawable? = null)

@BindingAdapter("setDate")
fun TextView.setDate(item: CalendarInfo?) {
    item?.let {
        text = it.dayOfMonth.toString()
    }
}

@BindingAdapter("setEmotion")
fun ImageView.setEmotion(item: CalendarInfo?) {
    item?.let {
        setImageDrawable(it.emotion)
    }
}