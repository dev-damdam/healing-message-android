package com.example.healingmessage.calendar

import androidx.recyclerview.widget.RecyclerView
import com.example.healingmessage.databinding.CalendarItemBinding

class CalendarViewHolder(private val binding: CalendarItemBinding) : RecyclerView.ViewHolder(binding.root) {
    val day = binding.textviewDay
    val emotion = binding.imgaeviewEmotion

    fun bind(item: CalendarInfo) {
        binding.calendarInfo = item
        binding.textviewDay.setOnClickListener {  }
        binding.executePendingBindings()
    }
}