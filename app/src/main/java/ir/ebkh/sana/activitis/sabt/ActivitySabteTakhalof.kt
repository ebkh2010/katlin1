package ir.ebkh.sana.activitis.sabt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import ir.ebkh.sana.R
import kotlinx.android.synthetic.main.estelam.*
import kotlinx.android.synthetic.main.sabt_takhalof.*

class ActivitySabteTakhalof : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sabt_takhalof)

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
        }

    }
}
