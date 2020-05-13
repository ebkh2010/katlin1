package ir.ebkh.sana.activitis.sabt

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import ir.ebkh.sana.R
import ir.ebkh.sana.main.G.*
import ir.hamsaa.persiandatepicker.Listener
import ir.hamsaa.persiandatepicker.PersianDatePickerDialog
import ir.hamsaa.persiandatepicker.util.PersianCalendar
import kotlinx.android.synthetic.main.sabt_fard.*
import kotlinx.android.synthetic.main.sabt_fard2.*


class ActivitySabteFard2 : AppCompatActivity() {


    var list_of_marage_spiner = arrayOf("وضعیت تاهل", "مجرد", "متاهل","جدا شده","فوت همسر","نامشخص")
    var list_of_school_spiner = arrayOf("تحصیلات", "بیسواد", "زیر دیپلم","دیپلم","کارشناسی","کارشناسی ارشد","دکتری تخصصی","نامشخص")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sabt_fard2)

        txt_born_date.setTypeface(Typeface.createFromAsset(assets, "Shabnam-Light-FD.ttf"))

        btn_date_born.setOnTouchListener(View.OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                btn_date_born.setImageResource(R.drawable.pushed_borndate)
            }
            if (event.action == MotionEvent.ACTION_UP) {
                btn_date_born.setImageResource(R.drawable.borndate)
            }
            false
        })//تابع کلیک روی این کلید در لیاوت فعال شده است



        val sp1 = findViewById(R.id.marage) as Spinner
        val adapter1: ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, list_of_marage_spiner)
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sp1.setAdapter(adapter1)
        sp1.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(arg0: AdapterView<*>?, arg1: View, position: Int, id: Long) {
                 marage_stat = list_of_marage_spiner.get(position)
            }
            override fun onNothingSelected(arg0: AdapterView<*>?) {
            }
        }


        val sp2 = findViewById(R.id.school) as Spinner
        val adapter2: ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, list_of_school_spiner)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sp2.setAdapter(adapter2)
        sp2.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(arg0: AdapterView<*>?, arg1: View, position: Int, id: Long) {
                school_stat = list_of_school_spiner.get(position)

            }
            override fun onNothingSelected(arg0: AdapterView<*>?) {
            }
        }


        btn_sabtefard2.setOnTouchListener(View.OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                btn_sabtefard2.setImageResource(R.drawable.pushed_btn_next)
            }
            if (event.action == MotionEvent.ACTION_UP) {
                btn_sabtefard2.setImageResource(R.drawable.btn_next)
            }
            false
        })
        btn_sabtefard2.setOnClickListener {

            born_city= makan_tavalod.text.toString()

            val intent = Intent(this, ActivitySabteFard3::class.java)
            startActivity(intent)
        }
    }

    fun showbornCalendar(v: View?) {
        val typeface = Typeface.createFromAsset(assets, "Shabnam-Light-FD.ttf")
        val initDate = PersianCalendar()
        initDate.setPersianDate(1370, 3, 13)
        var picker = PersianDatePickerDialog(this)
            .setPositiveButtonString("تایید")
            .setNegativeButton("انصراف")
            .setTodayButton("امروز")
            .setTodayButtonVisible(true)
            .setMinYear(1300)
            .setMaxYear(PersianDatePickerDialog.THIS_YEAR)
            .setInitDate(initDate)
            .setActionTextColor(Color.GRAY)
            .setTypeFace(typeface)
            .setTitleType(PersianDatePickerDialog.WEEKDAY_DAY_MONTH_YEAR)
            .setShowInBottomSheet(false)
            .setListener(object : Listener {
                override fun onDateSelected(persianCalendar: PersianCalendar) {
                    born_date = persianCalendar.getPersianYear()
                        .toString() + "/" + persianCalendar.getPersianMonth() + "/" + persianCalendar.getPersianDay()
//                    Toast.makeText(this@ActivitySabteTakhalof,date, Toast.LENGTH_SHORT).show()
                    txt_born_date.setText(born_date)
                }

                override fun onDismissed() {}
            })
        picker.show()
    }

    override fun onBackPressed() {

        val intent = Intent(this, ActivitySabteFard::class.java)
        startActivity(intent)
        finish()

    }
}
