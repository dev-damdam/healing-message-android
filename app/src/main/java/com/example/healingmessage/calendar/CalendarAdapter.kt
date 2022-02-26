package com.example.healingmessage.calendar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.healingmessage.databinding.CalendarItemBinding

class CalendarAdapter :
    ListAdapter<CalendarInfo, CalendarViewHolder>(CalendarAdapterDiffCallback()) {

    private lateinit var itemClickListener : OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
        val binding = CalendarItemBinding.inflate(LayoutInflater.from(parent.context))
        return CalendarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        val item: CalendarInfo = getItem(position)
        if (item.dayOfMonth == 0) {
            holder.day.visibility = View.GONE
            holder.emotion.visibility = View.GONE
        }

        holder.bind(item)

        holder.itemView.setOnClickListener {
            itemClickListener.onItemClickListener(it, position)
        }
    }

    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }
}

