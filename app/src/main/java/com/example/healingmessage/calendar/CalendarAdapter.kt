package com.example.healingmessage.calendar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.healingmessage.databinding.CalendarItemBinding

class CalendarAdapter: RecyclerView.Adapter<CalendarViewHolder>() {
    private var dateList: ArrayList<CalendarData> = ArrayList<CalendarData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
        val binding = CalendarItemBinding.inflate(LayoutInflater.from(parent.context))

        return CalendarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        holder.bind(dateList[position])
    }

    override fun getItemCount(): Int {
        return dateList.size
    }

    fun addItem(item: CalendarData) {
        dateList.add(item)
    }
}