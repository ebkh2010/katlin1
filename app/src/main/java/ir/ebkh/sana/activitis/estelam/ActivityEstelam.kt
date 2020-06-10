package ir.ebkh.sana.activitis.estelam

import android.R.attr.button
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.View.OnTouchListener
import androidx.appcompat.app.AppCompatActivity
import ir.ebkh.sana.R
import ir.ebkh.sana.activitis.sabt.ActivitySabteTakhalof
import kotlinx.android.synthetic.main.estelam.*


class ActivityEstelam : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.estelam)


        btn_estelam_fard.setOnTouchListener(OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                btn_estelam_fard.setImageResource(R.drawable.pushed_btn_fard)
            }
            if (event.action == MotionEvent.ACTION_UP) {
                btn_estelam_fard.setImageResource(R.drawable.btn_fard)
            }
            false
        })
        btn_estelam_fard.setOnClickListener {
            val intent = Intent(this, ActivityEstelamFard::class.java)
            startActivity(intent)
            fullFinish()
        }

        btn_estelam_makan.setOnTouchListener(OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                btn_estelam_makan.setImageResource(R.drawable.pushed_btn_makan)
            }
            if (event.action == MotionEvent.ACTION_UP) {
                btn_estelam_makan.setImageResource(R.drawable.btn_makan)
            }
            false
        })
        btn_estelam_makan.setOnClickListener {
//            val intent = Intent(this, ActivityEstelamFard::class.java)
//            startActivity(intent)
        }

        btn_estelam_vasile.setOnTouchListener(OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                btn_estelam_vasile.setImageResource(R.drawable.pushed_btn_vasile)
            }
            if (event.action == MotionEvent.ACTION_UP) {
                btn_estelam_vasile.setImageResource(R.drawable.btn_vasile)
            }
            false
        })
        btn_estelam_vasile.setOnClickListener {
            val intent = Intent(this, ActivityEstelamKhodro::class.java)
            startActivity(intent)
            fullFinish()
        }

        btn_estelam_takhalof.setOnTouchListener(OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                btn_estelam_takhalof.setImageResource(R.drawable.pushed_btn_takhalof)
            }
            if (event.action == MotionEvent.ACTION_UP) {
                btn_estelam_takhalof.setImageResource(R.drawable.btn_takhalof)
            }
            false
        })
        btn_estelam_takhalof.setOnClickListener {
//            val intent = Intent(this, ActivityEstelamFard::class.java)
//            startActivity(intent)
        }

        new_sana.setOnTouchListener(OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                new_sana.setImageResource(R.drawable.pushed_btn_newinfo)
            }
            if (event.action == MotionEvent.ACTION_UP) {
                new_sana.setImageResource(R.drawable.btn_newinfo)
            }
            false
        })
        new_sana.setOnClickListener {
            val intent = Intent(this, ActivitySabteTakhalof::class.java)
            startActivity(intent)
            fullFinish()
        }

    }


    private fun fullFinish () {
        btn_estelam_fard.setImageDrawable(null)
        btn_estelam_makan.setImageDrawable(null)
        btn_estelam_takhalof.setImageDrawable(null)
        btn_estelam_vasile.setImageDrawable(null)
        new_sana.setImageDrawable(null)
        b1.setImageDrawable(null)
        b2.setImageDrawable(null)
        b3.setImageDrawable(null)
        b4.setImageDrawable(null)

        estelam_main_lyout.removeAllViews()

        btn_estelam_fard.setOnClickListener(null)
        btn_estelam_fard.setOnTouchListener(null)
        btn_estelam_makan.setOnClickListener(null)
        btn_estelam_makan.setOnTouchListener(null)
        btn_estelam_vasile.setOnClickListener(null)
        btn_estelam_vasile.setOnTouchListener(null)
        btn_estelam_takhalof.setOnClickListener(null)
        btn_estelam_takhalof.setOnTouchListener(null)
        new_sana.setOnClickListener(null)
        new_sana.setOnTouchListener(null)

        Runtime.getRuntime().gc()
    }

}
