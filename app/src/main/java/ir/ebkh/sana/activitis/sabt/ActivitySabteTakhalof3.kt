package ir.ebkh.sana.activitis.sabt

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ir.ebkh.sana.R
import kotlinx.android.synthetic.main.sabt_takhalof2.*
import kotlinx.android.synthetic.main.sabt_takhalof3.*
import java.util.*


class ActivitySabteTakhalof3 : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sabt_takhalof3)

        searchablespinner.setTitle("جستجو و انتخاب کنید")
        searchablespinner.setPositiveButton("تایید")

        btn_sabtetakhalof3.setOnTouchListener(View.OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                btn_sabtetakhalof3.setImageResource(R.drawable.pushed_btn_next)
            }
            if (event.action == MotionEvent.ACTION_UP) {
                btn_sabtetakhalof3.setImageResource(R.drawable.btn_next)
            }
            false
        })
        btn_sabtetakhalof3.setOnClickListener {
            val intent = Intent(this, ActivitySabteTakhalof4::class.java)
            startActivity(intent)
        }
    }
}
