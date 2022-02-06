package com.example.healingmessage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.healingmessage.calendar.CalendarAdapter
import com.example.healingmessage.calendar.CalendarData
import com.example.healingmessage.databinding.ActivityMainBinding
import java.util.*
import android.R.string.no




class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var calendarAdapter: CalendarAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calendarView.setHasFixedSize(true)
        binding.calendarView.layoutManager = GridLayoutManager(this, 7)

        // Initialised
        calendarAdapter = CalendarAdapter()
        calendarAdapter.notifyDataSetChanged()
        binding.calendarView.adapter = calendarAdapter

        setCalendarList()
    }

    private fun setCalendarList() {
        val calendar: Calendar = Calendar.getInstance()

        val currentYear = calendar.get(Calendar.YEAR)
        val currentMonth = calendar.get(Calendar.MONTH) + 1// MONTH : 0 ~ 11
        val currentDay = calendar.get(Calendar.DAY_OF_MONTH)

        calendar.set(currentYear, currentMonth - 1, 1)

        val lastDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)

        binding.textviewMonth.text =
            if (currentMonth.toString().length == 1) "0$currentMonth" else currentMonth.toString()
        binding.textviewYear.text = currentYear.toString()

        val dayNum: Int = calendar.get(Calendar.DAY_OF_WEEK)


        //1일 - 요일 매칭 시키기 위해 공백 add
        for (i in 1 until dayNum) {
            calendarAdapter.addItem(CalendarData(null, ""))
        }

        //set day
        for(day in 1..lastDayOfMonth) {
            calendarAdapter.addItem(CalendarData(this.getDrawable(R.drawable.ic_launcher_foreground), day.toString()))
        }
    }
}