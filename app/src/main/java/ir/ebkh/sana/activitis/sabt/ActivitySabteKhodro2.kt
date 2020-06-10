package ir.ebkh.sana.activitis.sabt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.ebkh.sana.R
import ir.ebkh.sana.activitis.estelam.ActivityEstelam
import ir.ebkh.sana.main.G
import ir.ebkh.sana.main.G.database
import kotlinx.android.synthetic.main.sabt_khodro.*
import kotlinx.android.synthetic.main.sabt_khodro2.*
import kotlinx.android.synthetic.main.sabt_takhalof.*
import kotlinx.android.synthetic.main.sabt_takhalof2.*
import kotlinx.android.synthetic.main.sabt_takhalof3.*
import java.util.*

class ActivitySabteKhodro2 : AppCompatActivity() {

    private var isRegistred=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sabt_khodro2)

        btn_sabtekhodro2.setOnClickListener {
            var sqlq="INSERT INTO car(car_pelak,name,system,tip," +
                    "color,shasi_number,motor_number) " +
                    "VALUES ('"+ G.carPelak +"','"+ G.carName +"','"+ G.carSystem +"','"+ G.carTip +"','"+ khodro_color.text.toString() +"','"+
                    khodro_shasinumber.text.toString() +"','"+ khodro_motornumber.text.toString() +"')";

            try {
                database.execSQL(sqlq)
                isRegistred=true
            }catch (e: NumberFormatException) {
                println("kodmelli")
                isRegistred=false
            }

            if (isRegistred)
            {
                G.carPelak=""
                G.carName = ""
                G.carTip = ""
                G.carSystem = ""
            }

            val intent = Intent(this, ActivitySabteTakhalof4::class.java)
            startActivity(intent)
            fullfinish()
        }
    }

    override fun onBackPressed() {
        val intent = Intent(this, ActivitySabteKhodro::class.java)
        startActivity(intent)
        fullfinish()
    }

    private fun fullfinish(){
        b53.setImageDrawable(null)
        b54.setImageDrawable(null)
        b55.setImageDrawable(null)
        b56.setImageDrawable(null)
        b57.setImageDrawable(null)
        btn_next2_sabt_motor.setImageDrawable(null)
        btn_sabtekhodro2.setImageDrawable(null)

        sabt_khodro2_mail_layout.removeAllViews()
        finish()

    }
}
