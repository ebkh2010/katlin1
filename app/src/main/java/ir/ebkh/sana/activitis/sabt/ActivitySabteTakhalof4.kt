package ir.ebkh.sana.activitis.sabt

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ir.ebkh.sana.R
import kotlinx.android.synthetic.main.sabt_takhalof3.*
import kotlinx.android.synthetic.main.sabt_takhalof4.*
import java.util.*


class ActivitySabteTakhalof4 : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sabt_takhalof4)

        searchablespinner_add_car.setTitle("جستجو و انتخاب کنید")
        searchablespinner_add_car.setPositiveButton("تایید")

        searchablespinner_add_motor.setTitle("جستجو و انتخاب کنید")
        searchablespinner_add_motor.setPositiveButton("تایید")


        btn_sabtetakhalof4.setOnTouchListener(View.OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                btn_sabtetakhalof4.setImageResource(R.drawable.pushed_btn_next)
            }
            if (event.action == MotionEvent.ACTION_UP) {
                btn_sabtetakhalof4.setImageResource(R.drawable.btn_next)
            }
            false
        })
        btn_sabtetakhalof4.setOnClickListener {
            val intent = Intent(this, ActivitySabteTakhalof5::class.java)
            startActivity(intent)
        }

        btn_add_car.setOnClickListener {
            val intent = Intent(this, ActivitySabteKhodro::class.java)
            startActivity(intent)
        }
    }
}
