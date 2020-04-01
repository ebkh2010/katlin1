package ir.ebkh.sana.activitis.estelam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import ir.ebkh.sana.R
import kotlinx.android.synthetic.main.estelam.*
import kotlinx.android.synthetic.main.estelam_khodro.*
import kotlinx.android.synthetic.main.estelam_khodro_fa.*

import java.util.*

class ActivityEstelamKhodro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Locale.getDefault().getDisplayLanguage()== "English")
        {
            setContentView(R.layout.estelam_khodro)
            btn_estelam_motor.setOnTouchListener(View.OnTouchListener { v, event ->
                if (event.action == MotionEvent.ACTION_DOWN) {
                    btn_estelam_motor.setImageResource(R.drawable.pushed_estelam_motor)
                }
                if (event.action == MotionEvent.ACTION_UP) {
                    btn_estelam_motor.setImageResource(R.drawable.estelam_motor)
                }
                false
            })
            btn_estelam_motor.setOnClickListener {
                val intent = Intent(this, ActivityEstelamMotor::class.java)
                startActivity(intent)
            }
        }
        else
        {
            setContentView(R.layout.estelam_khodro_fa)
            btn_estelam_motor_fa.setOnTouchListener(View.OnTouchListener { v, event ->
                if (event.action == MotionEvent.ACTION_DOWN) {
                    btn_estelam_motor_fa.setImageResource(R.drawable.pushed_estelam_motor)
                }
                if (event.action == MotionEvent.ACTION_UP) {
                    btn_estelam_motor_fa.setImageResource(R.drawable.estelam_motor)
                }
                false
            })
            btn_estelam_motor_fa.setOnClickListener {
                val intent = Intent(this, ActivityEstelamMotor::class.java)
                startActivity(intent)
            }
        }



    }
}
