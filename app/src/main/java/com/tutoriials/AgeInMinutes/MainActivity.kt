package com.tutoriials.AgeInMinutes

import android.app.DatePickerDialog
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn=findViewById(R.id.selectdate) as Button
        btn.setOnClickListener {view->
            clickdate(view )

        }
    }
    fun clickdate(view:View){
        val mycalender=Calendar.getInstance()
        val year=mycalender.get(Calendar.YEAR)
        val month=mycalender.get(Calendar.MONTH)
        val day=mycalender.get(Calendar.DAY_OF_MONTH)
        val dpd=DatePickerDialog(this,DatePickerDialog.OnDateSetListener
        { view, selectyear, selectmonth, selectdayOfMonth ->
            val sm=selectmonth+1
           var selectdate="$selectdayOfMonth/$sm/$selectyear"
           val selecteddate=findViewById(R.id.date) as TextView
            selecteddate.text=selectdate

            val dateformat=SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH)
            val thedate=dateformat.parse(selectdate)
            val curentdate=dateformat.parse(dateformat.format(System.currentTimeMillis()))

            val selecteddateinmin=thedate!!.time/60000


            val currenttimeinmin=curentdate!!.time/60000
            val selectinmin=findViewById(R.id.ageinmin)as TextView
            val outinmin=currenttimeinmin-selecteddateinmin
            selectinmin.text=outinmin.toString()

            val selecteddateinhr=thedate!!.time/3600000
            val currenttimeinhr=curentdate!!.time/3600000
            val outinhr=currenttimeinhr-selecteddateinhr
            val selectininhr=findViewById(R.id.ageinhr) as TextView
            selectininhr.text=outinhr.toString()


            val selecteddateindy=thedate!!.time/(24*3600000)
            val currenttimeindy=curentdate!!.time/(24*3600000)
            val outinhdy=currenttimeindy-selecteddateindy
            val selectinindy=findViewById(R.id.ageindys) as TextView
            selectinindy.text=outinhdy.toString()







        },year,month,day)
        dpd.datePicker.maxDate=Date().time-86400000
        dpd.show()
    }
}