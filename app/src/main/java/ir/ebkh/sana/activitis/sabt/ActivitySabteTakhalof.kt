package ir.ebkh.sana.activitis.sabt

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.michaldrabik.classicmaterialtimepicker.CmtpTimeDialogFragment
import com.michaldrabik.classicmaterialtimepicker.utilities.setOnTime12PickedListener
import ir.ebkh.sana.R
import kotlinx.android.synthetic.main.sabt_takhalof.*
import ir.hamsaa.persiandatepicker.Listener
import ir.hamsaa.persiandatepicker.PersianDatePickerDialog
import ir.hamsaa.persiandatepicker.util.PersianCalendar
import com.michaldrabik.classicmaterialtimepicker.model.CmtpTime12.PmAm.PM



class ActivitySabteTakhalof : AppCompatActivity() {

    var date=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sabt_takhalof)

        takhalof_hour.setOnClickListener { showTime12PickerDialog() }

        btn_sabt_takhalof_next.setOnTouchListener(View.OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                btn_sabt_takhalof_next.setImageResource(R.drawable.pushed_btn_next)
            }
            if (event.action == MotionEvent.ACTION_UP) {
                btn_sabt_takhalof_next.setImageResource(R.drawable.btn_next)
            }
            false
        })
        btn_sabt_takhalof_next.setOnClickListener {
            val intent = Intent(this, ActivitySabteTakhalof2::class.java)
            startActivity(intent)
            finish()


        }

    }

    fun showCalendar(v: View?) {
        val typeface = Typeface.createFromAsset(assets, "Shabnam-Light-FD.ttf")
        val initDate = PersianCalendar()
        initDate.setPersianDate(1370, 3, 13)
        var picker = PersianDatePickerDialog(this)
            .setPositiveButtonString("تایید")
            .setNegativeButton("انصراف")
            .setTodayButton("امروز")
            .setTodayButtonVisible(true)
            .setMinYear(1380)
            .setMaxYear(PersianDatePickerDialog.THIS_YEAR)
            .setInitDate(initDate)
            .setActionTextColor(Color.GRAY)
            .setTypeFace(typeface)
            .setTitleType(PersianDatePickerDialog.WEEKDAY_DAY_MONTH_YEAR)
            .setShowInBottomSheet(false)
            .setListener(object : Listener {
                override fun onDateSelected(persianCalendar: PersianCalendar) {
                    date = persianCalendar.getPersianYear()
                        .toString() + "/" + persianCalendar.getPersianMonth() + "/" + persianCalendar.getPersianDay()
//                    Toast.makeText(this@ActivitySabteTakhalof,date, Toast.LENGTH_SHORT).show()
                    tarikh_takhalof.setText(date)
                }

                override fun onDismissed() {}
            })
        picker.show()
    }

    private fun showTime12PickerDialog() {
        val dialog = CmtpTimeDialogFragment.newInstance()
        dialog.setInitialTime12(5, 15, PM)
        dialog.setOnTime12PickedListener {
            Toast.makeText(this@ActivitySabteTakhalof, it.toString(), Toast.LENGTH_SHORT).show()
        }
        dialog.show(supportFragmentManager, "TimePicker")
    }

}
