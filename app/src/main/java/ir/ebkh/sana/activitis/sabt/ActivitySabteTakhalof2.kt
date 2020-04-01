package ir.ebkh.sana.activitis.sabt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import ir.ebkh.sana.R
import kotlinx.android.synthetic.main.sabt_takhalof.*
import kotlinx.android.synthetic.main.sabt_takhalof2.*
import kotlinx.android.synthetic.main.sabt_takhalof3.*

class ActivitySabteTakhalof2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sabt_takhalof2)

        searchablespinner_add_takhalof.setTitle("جستجو و انتخاب کنید")
        searchablespinner_add_takhalof.setPositiveButton("تایید")


        btn_sabtetakhalof2.setOnTouchListener(View.OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                btn_sabtetakhalof2.setImageResource(R.drawable.pushed_btn_next)
            }
            if (event.action == MotionEvent.ACTION_UP) {
                btn_sabtetakhalof2.setImageResource(R.drawable.btn_next)
            }
            false
        })
        btn_sabtetakhalof2.setOnClickListener {
            val intent = Intent(this, ActivitySabteTakhalof3::class.java)
            startActivity(intent)
        }

    }
}
