package ir.ebkh.sana.activitis.sabt

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ir.ebkh.sana.R
import ir.ebkh.sana.activitis.estelam.ActivityEstelam
import kotlinx.android.synthetic.main.sabt_takhalof2.*
import kotlinx.android.synthetic.main.sabt_takhalof3.*
import kotlinx.android.synthetic.main.sabt_takhalof5.*
import java.util.*


class ActivitySabteTakhalof5 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sabt_takhalof5)

        searchablespinner_makantakhalof.setTitle("جستجو و انتخاب کنید")
        searchablespinner_makantakhalof.setPositiveButton("تایید")

        btn_sabtetakhalof5.setOnTouchListener(View.OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                btn_sabtetakhalof5.setImageResource(R.drawable.pushedd_sabte_sana)
            }
            if (event.action == MotionEvent.ACTION_UP) {
                btn_sabtetakhalof5.setImageResource(R.drawable.sabte_sana)
            }
            false
        })
        btn_sabtetakhalof5.setOnClickListener {
            val intent = Intent(this, ActivityEstelam::class.java)
            startActivity(intent)
            fullfinish()
        }
    }

    override fun onBackPressed() {

        val intent = Intent(this, ActivitySabteTakhalof4::class.java)
        startActivity(intent)
        fullfinish()

    }

    private fun fullfinish(){
        b21.setImageDrawable(null)
        b22.setImageDrawable(null)
        b23.setImageDrawable(null)
        b24.setImageDrawable(null)
        btn_add_place.setImageDrawable(null)
        btn_sabt_makantakhalof.setImageDrawable(null)
        list_amaken_takhalof.setImageDrawable(null)
        btn_sabtetakhalof5.setImageDrawable(null)
        sabt_takhalof5_mail_layout.removeAllViews()
        finish()
    }
}
