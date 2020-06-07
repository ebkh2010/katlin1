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
import ir.ebkh.sana.activitis.estelam.ActivityEstelam
import ir.ebkh.sana.main.G


class ActivitySabteTakhalof : AppCompatActivity() {

    var date=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sabt_takhalof)

        //TODO کد جدید ثاتا باید تولید شود
        //کد ثاتا باید در سیستم یکتا باشد
        // برای همین هر نرم افزار یا باید آنلاین کدهای ثاتا را دریافت کند و یا در اولین اتصال به سرور، تعدادی کد ثاتا را برای خو رزرو کند.
        // رزرو کدهای ثاتا میتواند به معنی ایجاد یک کد ترکیبی ویژه باشد که مشخص کننده دستگاه ثبت کننده است و یا صرفا یک کد ساده رزرو شده باشد.

        sana_new_cod.setTypeface(Typeface.createFromAsset(assets, "Shabnam-Light-FD.ttf"))
        sana_new_cod.setText("کد جدید: ۱۲۳۴۵۶")

        btn_takhalof_date.setOnTouchListener(View.OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                btn_takhalof_date.setImageResource(R.drawable.pushed_btn_takhalof_date)
            }
            if (event.action == MotionEvent.ACTION_UP) {
                btn_takhalof_date.setImageResource(R.drawable.btn_takhalof_date)
            }
            false
        })
        btn_takhalof_date.setOnClickListener {
            showCalendar()
        }

        btn_takhalof_time.setOnTouchListener(View.OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                btn_takhalof_time.setImageResource(R.drawable.pushed_btn_takhalof_time)
            }
            if (event.action == MotionEvent.ACTION_UP) {
                btn_takhalof_time.setImageResource(R.drawable.btn_takhalof_time)
            }
            false
        })
        btn_takhalof_time.setOnClickListener {
            showTime12PickerDialog()
        }

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

            G.takhalofSanaCod = sana_new_cod.text.toString()
            G.takhalofTarikh = takhalof_date.text.toString()
            G.takhalofSaat = takhalof_time.text.toString()
            val intent = Intent(this, ActivitySabteTakhalof2::class.java)
            startActivity(intent)
            finish()


        }

    }

    fun showCalendar() {
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
                    takhalof_date.setTypeface(Typeface.createFromAsset(assets, "Shabnam-Light-FD.ttf"))
                    takhalof_date.setText(date)
                }

                override fun onDismissed() {}
            })
        picker.show()
    }

    private fun  showTime12PickerDialog()  {
        val dialog = CmtpTimeDialogFragment.newInstance()

        dialog.setInitialTime12(1, 0, PM)
        dialog.setOnTime12PickedListener {
//            Toast.makeText(this@ActivitySabteTakhalof, it.toString(), Toast.LENGTH_SHORT).show()
            takhalof_time.setTypeface(Typeface.createFromAsset(assets, "Shabnam-Light-FD.ttf"))
            takhalof_time.setText(it.toString())
        }
        dialog.show(supportFragmentManager, "TimePicker")

    }

    override fun onBackPressed() {

        val intent = Intent(this, ActivityEstelam::class.java)
        startActivity(intent)
        finish()

    }

}
