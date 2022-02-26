package com.example.healingmessage.calendar

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.healingmessage.databinding.CalendarItemBinding

class CalendarAdapter: ListAdapter<CalendarInfo, CalendarViewHolder>(CalendarAdapterDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
        val binding = CalendarItemBinding.inflate(LayoutInflater.from(parent.context))
        return CalendarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        val item: CalendarInfo = getItem(position)
        if(item.dayOfMonth == 0) {
            holder.day.visibility = View.GONE
            holder.emotion.visibility = View.GONE
        }

        holder.bind(item)
    }
    /*private lateinit var itemClickListener : OnItemClickListener

    interface OnItemClickListener {
        fun onClick(v: View, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
        val binding = CalendarItemBinding.inflate(LayoutInflater.from(parent.context))

        return CalendarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        holder.bind(calendarList[position])

        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it, position)
        }
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

    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }*/
}

