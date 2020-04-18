package ir.ebkh.sana.activitis.sabt

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ir.ebkh.sana.R
import ir.ebkh.sana.activitis.estelam.ActivityEstelam
import ir.hamsaa.persiandatepicker.Listener
import ir.hamsaa.persiandatepicker.PersianDatePickerDialog
import ir.hamsaa.persiandatepicker.util.PersianCalendar
import kotlinx.android.synthetic.main.sabt_fard2.*
import kotlinx.android.synthetic.main.sabt_takhalof.*

class ActivitySabteFard2 : AppCompatActivity() {

    var born_date=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sabt_fard2)







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
                    date_born.setText(born_date)
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
