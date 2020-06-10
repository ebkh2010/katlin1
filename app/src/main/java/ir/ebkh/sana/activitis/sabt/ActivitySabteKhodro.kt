package ir.ebkh.sana.activitis.sabt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import ir.ebkh.sana.R
import ir.ebkh.sana.main.G
import kotlinx.android.synthetic.main.sabt_khodro.*
import kotlinx.android.synthetic.main.sabt_khodro_fa.*
import java.util.*

class ActivitySabteKhodro : AppCompatActivity() {

    private var englishLayout=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //نیاز به اصلاح دارد چون ممکن است زبان سیستم به غیر از این دو زبان باشد
        if (Locale.getDefault().getDisplayLanguage()== "English")
        {
            setContentView(R.layout.sabt_khodro)
            englishLayout=true


            btn_sabtekhodro.setOnTouchListener(View.OnTouchListener { v, event ->
                if (event.action == MotionEvent.ACTION_DOWN) {
                    btn_sabtekhodro.setImageResource(R.drawable.pushed_btn_next)
                }
                if (event.action == MotionEvent.ACTION_UP) {
                    btn_sabtekhodro.setImageResource(R.drawable.btn_next)
                }
                false
            })
            btn_sabtekhodro.setOnClickListener {

                G.carPelak= pelak_iran.text.toString()+" ایران "+pelak3.text.toString()+" "+
                        pelak2.text.toString()+" "+pelak1.text.toString()
                G.carName = khodro_name.text.toString()
                G.carSystem = khodro_system.text.toString()
                G.carTip = khodro_tip.text.toString()

                val intent = Intent(this, ActivitySabteKhodro2::class.java)
                startActivity(intent)
                fullfinish()
            }
        }
        else
        {
            setContentView(R.layout.sabt_khodro_fa)
            englishLayout=false


            btn_sabtekhodro_fa.setOnTouchListener(View.OnTouchListener { v, event ->
                if (event.action == MotionEvent.ACTION_DOWN) {
                    btn_sabtekhodro_fa.setImageResource(R.drawable.pushed_btn_next)
                }
                if (event.action == MotionEvent.ACTION_UP) {
                    btn_sabtekhodro_fa.setImageResource(R.drawable.btn_next)
                }
                false
            })
            btn_sabtekhodro_fa.setOnClickListener {



                G.carPelak= pelak_iran_fa.text.toString()+pelak3_fa.text.toString()+
                        pelak2_fa.text.toString()+pelak1_fa.text.toString()
                G.carName = khodro_name_fa.text.toString()
                G.carSystem = khodro_system_fa.text.toString()
                G.carTip = khodro_tip_fa.text.toString()

                val intent = Intent(this, ActivitySabteKhodro2::class.java)
                startActivity(intent)
                fullfinish_fa()
            }
        }


    }

    override fun onBackPressed() {
        val intent = Intent(this, ActivitySabteTakhalof4::class.java)
        startActivity(intent)
        if (englishLayout)
            fullfinish()
        else
            fullfinish_fa()

    }

    private fun fullfinish(){
        b41.setImageDrawable(null)
        b42.setImageDrawable(null)
        b43.setImageDrawable(null)
        b44.setImageDrawable(null)
        b45.setImageDrawable(null)
        b46.setImageDrawable(null)
        btn_sabtekhodro.setImageDrawable(null)
        btn_next_sabt_motor.setImageDrawable(null)

        sabt_khodro_mail_layout.removeAllViews()
    }

    private fun fullfinish_fa(){
        b47.setImageDrawable(null)
        b48.setImageDrawable(null)
        b49.setImageDrawable(null)
        b50.setImageDrawable(null)
        b51.setImageDrawable(null)
        b52.setImageDrawable(null)
        btn_sabtekhodro_fa.setImageDrawable(null)
        btn_next_sabt_motor_fa.setImageDrawable(null)

        sabt_khodro_fa_mail_layout.removeAllViews()
    }
}
