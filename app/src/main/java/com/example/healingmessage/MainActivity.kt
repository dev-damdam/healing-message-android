package com.example.healingmessage

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.healingmessage.calendar.CalendarAdapter
import com.example.healingmessage.calendar.CalendarInfo
import com.example.healingmessage.calendar.OnItemClickListener
import com.example.healingmessage.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var context: Context
    private lateinit var binding: ActivityMainBinding
    private lateinit var calendarAdapter: CalendarAdapter
    private lateinit var calendar: Calendar
    private lateinit var calendarList: MutableList<CalendarInfo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        context = this

        calendarAdapter = CalendarAdapter()
        binding.calendarView.setHasFixedSize(true)
        binding.calendarView.layoutManager = GridLayoutManager(this, 7)
        binding.calendarView.adapter = calendarAdapter

        calendar = Calendar.getInstance()
        calendar.timeInMillis = System.currentTimeMillis()

        //init
        calendarList = MutableList(0, init = {CalendarInfo()})

        setCalendar(0)

        binding.buttonNextMonth.setOnClickListener {
            setCalendar(1)
            calendarAdapter.notifyDataSetChanged()
        }

        binding.buttonPrevMonth.setOnClickListener {
            setCalendar(-1)
            calendarAdapter.notifyDataSetChanged()
        }


        calendarAdapter.setItemClickListener(object : OnItemClickListener {
            override fun onItemClickListener(view: View, position: Int) {
                Toast.makeText(context, "${calendarList[position].dayOfMonth} click", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setCalendar(num: Int) {
        calendarList.clear()

        calendar.set(Calendar.DAY_OF_MONTH, 1)
        calendar.set(Calendar.DAY_OF_WEEK, 2)

        calendar.add(Calendar.MONTH, num)

        val tempCalendar = calendar.timeInMillis
        calendar.timeInMillis = tempCalendar

        val year = calendar.get(Calendar.YEAR)
        val maxDate = calendar.getActualMaximum(Calendar.DATE)
        val week = calendar.get(Calendar.DAY_OF_WEEK) - 1
        val month = calendar.get(Calendar.MONTH) + 1

        binding.textviewMonth.text =
            if (month.toString().length == 1) "0${month}" else {
                month.toString()
            }.toString()
        binding.textviewYear.text = year.toString()

        val list = MutableList(week, init = {CalendarInfo()})

        for(i: Int in 1..maxDate) {
            var id = UUID.randomUUID().toString()
            list.add(CalendarInfo(id, month, i, 0, this.getDrawable(R.drawable.happy_ic)))
        }
        calendarList = list
        calendarAdapter.submitList(list)
    }
}