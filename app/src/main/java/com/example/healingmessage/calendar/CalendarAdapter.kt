package com.example.healingmessage.calendar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.healingmessage.databinding.CalendarItemBinding

class CalendarAdapter(private var calendarList: ArrayList<CalendarData>): RecyclerView.Adapter<CalendarViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
        val binding = CalendarItemBinding.inflate(LayoutInflater.from(parent.context))

        return CalendarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        holder.bind(calendarList[position])
    }

    override fun getItemCount(): Int {
        return calendarList.size
    }

    fun setCalendarList(calendarList: ArrayList<CalendarData>) {
        this.calendarList = calendarList
    }

    fun addItem(item: CalendarData) {
        calendarList.add(item)
    }
}