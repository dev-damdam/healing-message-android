package com.example.healingmessage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.healingmessage.calendar.CalendarAdapter
import com.example.healingmessage.calendar.CalendarData
import com.example.healingmessage.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var calendarAdapter: CalendarAdapter
    private var calendarList: ArrayList<CalendarData> = ArrayList<CalendarData>()

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
    }
}