package com.example.healingmessage.calendar

import androidx.recyclerview.widget.DiffUtil

class CalendarAdapterDiffCallback: DiffUtil.ItemCallback<CalendarInfo>() {
    override fun areItemsTheSame(oldItem: CalendarInfo, newItem: CalendarInfo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CalendarInfo, newItem: CalendarInfo): Boolean {
        return oldItem == newItem
    }
}