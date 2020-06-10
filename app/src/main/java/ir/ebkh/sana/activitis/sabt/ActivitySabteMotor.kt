package ir.ebkh.sana.activitis.sabt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import ir.ebkh.sana.R
import ir.ebkh.sana.activitis.estelam.ActivityEstelam
import ir.ebkh.sana.main.G
import kotlinx.android.synthetic.main.estelam.*
import kotlinx.android.synthetic.main.sabt_motor.*
import kotlinx.android.synthetic.main.sabt_motor_fa.*
import java.util.*

class ActivitySabteMotor : AppCompatActivity() {

    var isRegistred =false
    private var englishLayout=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        englishLayout=true

        if (Locale.getDefault().getDisplayLanguage()== "English")
        {
            setContentView(R.layout.sabt_motor)
            englishLayout=true
            btn_sabtemotor.setOnTouchListener(View.OnTouchListener { v, event ->
                if (event.action == MotionEvent.ACTION_DOWN) {
                    btn_sabtemotor.setImageResource(R.drawable.pushedd_sabte_sana)
                }
                if (event.action == MotionEvent.ACTION_UP) {
                    btn_sabtemotor.setImageResource(R.drawable.sabte_sana)
                }
                false
            })
            btn_sabtemotor.setOnClickListener {
                var sqlq="INSERT INTO motor(motor_pelak,motor_name,motor_system,motor_color) " +
                        "VALUES ('"+ pelak_motor_p1.text.toString() +" ایران " + pelak_motor_p2.text.toString()+"','"+
                        sabt_motor_name.text.toString() +"','"+ sabt_motor_system.text.toString() +"','"+
                        sabt_motor_color.text.toString()  +"')";

                try {
                    G.database.execSQL(sqlq)
                    isRegistred=true
                }catch (e: NumberFormatException) {
                    isRegistred=false
                }

                val intent = Intent(this, ActivitySabteKhodro::class.java)
                startActivity(intent)
                fulfinish()
            }
        }
        else
        {
            setContentView(R.layout.sabt_motor_fa)
            englishLayout=false
            btn_sabtemotor_fa.setOnTouchListener(View.OnTouchListener { v, event ->
                if (event.action == MotionEvent.ACTION_DOWN) {
                    btn_sabtemotor_fa.setImageResource(R.drawable.pushedd_sabte_sana)
                }
                if (event.action == MotionEvent.ACTION_UP) {
                    btn_sabtemotor_fa.setImageResource(R.drawable.sabte_sana)
                }
                false
            })
            btn_sabtemotor_fa.setOnClickListener {
                var sqlq="INSERT INTO motor(motor_pelak,motor_name,motor_system,motor_color) " +
                        "VALUES ('"+ pelak_motor_p1_fa.text.toString() +" ایران " + pelak_motor_p2_fa.text.toString()+"','"+
                        sabt_motor_name_fa.text.toString() +"','"+ sabt_motor_system_fa.text.toString() +"','"+
                        sabt_motor_color_fa.text.toString()  +"')";

                try {
                    G.database.execSQL(sqlq)
                    isRegistred=true
                }catch (e: NumberFormatException) {
                    isRegistred=false
                }

                val intent = Intent(this, ActivitySabteTakhalof4::class.java)
                startActivity(intent)
                finish()
            }

        }
    }

    override fun onBackPressed() {

        val intent = Intent(this, ActivitySabteTakhalof4::class.java)
        startActivity(intent)
        if (englishLayout)
           fulfinish()
        else
            fulfinish_fa()


    }

    private fun fulfinish(){
        b58.setImageDrawable(null)
        b59.setImageDrawable(null)
        b60.setImageDrawable(null)
        b61.setImageDrawable(null)
        b62.setImageDrawable(null)
        btn_sabtemotor.setImageDrawable(null)
        sabt_motor_mail_layout.removeAllViews()
        finish()

    }

    private fun fulfinish_fa(){
        b63.setImageDrawable(null)
        b64.setImageDrawable(null)
        b65.setImageDrawable(null)
        b66.setImageDrawable(null)
        b67.setImageDrawable(null)
        btn_sabtemotor_fa.setImageDrawable(null)
        sabt_motor_fa_mail_layout.removeAllViews()
        finish()

    }
}
