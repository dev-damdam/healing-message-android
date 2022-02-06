package com.example.healingmessage.calendar

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.healingmessage.databinding.CalendarItemBinding

class CalendarViewHolder(private val binding: CalendarItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: CalendarData) {
        binding.imgaeviewEmotion.setImageDrawable(data.emotionImage)
        binding.textviewDay.text = data.day
    }
}