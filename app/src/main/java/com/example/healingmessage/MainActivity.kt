package com.example.healingmessage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.healingmessage.calendar.CalendarAdapter
import com.example.healingmessage.calendar.CalendarInfo
import com.example.healingmessage.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var calendarAdapter: CalendarAdapter
    private lateinit var calendar: Calendar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        calendarAdapter = CalendarAdapter()
        binding.calendarView.setHasFixedSize(true)
        binding.calendarView.layoutManager = GridLayoutManager(this, 7)
        binding.calendarView.adapter = calendarAdapter

        calendar = Calendar.getInstance()
        calendar.timeInMillis = System.currentTimeMillis()

        setCalendar(0)

        binding.buttonNextMonth.setOnClickListener {
            setCalendar(1)
            calendarAdapter.notifyDataSetChanged()
        }

        binding.buttonPrevMonth.setOnClickListener {
            setCalendar(-1)
            calendarAdapter.notifyDataSetChanged()
        }

    }

    private fun setCalendar(num: Int) {
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

        calendarAdapter.submitList(list)
    }
    /*private var calendarList: ArrayList<CalendarData> = ArrayList<CalendarData>()

    private val cal = GregorianCalendar()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calendarView.setHasFixedSize(true)
        binding.calendarView.layoutManager = GridLayoutManager(this, 7)

        binding.buttonNextMonth.setOnClickListener {
            setCalendarList(1)
            calendarAdapter.notifyDataSetChanged()
        }

        binding.buttonPrevMonth.setOnClickListener {
            setCalendarList(-1)
            calendarAdapter.notifyDataSetChanged()
        }

        // Initialised
        setCalendarList(0)
        calendarAdapter = CalendarAdapter(calendarList)
        calendarAdapter.notifyDataSetChanged()
        binding.calendarView.adapter = calendarAdapter

        calendarAdapter.setItemClickListener(object: CalendarAdapter.OnItemClickListener{
            override fun onClick(v: View, position: Int) {
                // 클릭 시 이벤트 작성
                Toast.makeText(v.context,
                    "${calendarList[position].day}",
                    Toast.LENGTH_SHORT).show()
            }
        })

        Toast.makeText(this, "test", Toast.LENGTH_SHORT).show()
    }

    private fun setCalendarList(num: Int) {
        calendarList.clear()
        cal.add(Calendar.MONTH, num)

        val calendar =
            GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1, 0, 0, 0)

        binding.textviewMonth.text =
            if ((cal.get(Calendar.MONTH) + 1).toString().length == 1) "0${cal.get(Calendar.MONTH) + 1}" else {
                (cal.get(Calendar.MONTH) + 1).toString()
            }.toString()
        binding.textviewYear.text = cal.get(Calendar.YEAR).toString()

        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)

        val max = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)

        for (j in 1 until dayOfWeek) {
            calendarList.add(CalendarData(null, ""))
        }

        for (j in 1..max) {
            calendarList.add(
                CalendarData(
                    this.getDrawable(R.drawable.ic_launcher_foreground),
                    j.toString()
                )
            )
        }
    }*/
}