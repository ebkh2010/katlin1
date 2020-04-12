package ir.ebkh.sana.activitis.sabt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import ir.ebkh.sana.R
import ir.ebkh.sana.activitis.estelam.ActivityEstelam
import kotlinx.android.synthetic.main.estelam.*
import kotlinx.android.synthetic.main.sabt_motor.*
import kotlinx.android.synthetic.main.sabt_motor_fa.*
import java.util.*

class ActivitySabteMotor : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Locale.getDefault().getDisplayLanguage()== "English")
        {
            setContentView(R.layout.sabt_motor)
            btn_sabtemotor.setOnTouchListener(View.OnTouchListener { v, event ->
                if (event.action == MotionEvent.ACTION_DOWN) {
                    btn_sabtemotor.setImageResource(R.drawable.pushedd_sabte_sana)
                }
                if (event.action == MotionEvent.ACTION_UP) {
                    btn_sabtemotor.setImageResource(R.drawable.sabte_sana)
                }
                false
            })
        }
        else
        {
            setContentView(R.layout.sabt_motor_fa)
            btn_sabtemotor_fa.setOnTouchListener(View.OnTouchListener { v, event ->
                if (event.action == MotionEvent.ACTION_DOWN) {
                    btn_sabtemotor_fa.setImageResource(R.drawable.pushedd_sabte_sana)
                }
                if (event.action == MotionEvent.ACTION_UP) {
                    btn_sabtemotor_fa.setImageResource(R.drawable.sabte_sana)
                }
                false
            })

        }
    }

    override fun onBackPressed() {

        val intent = Intent(this, ActivitySabteKhodro::class.java)
        startActivity(intent)
        finish()

    }
}
