package ir.ebkh.sana.activitis.sabt

import android.content.Intent
import android.os.Bundle
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


        btn_sabtetakhalof5.setOnClickListener {
            val intent = Intent(this, ActivityEstelam::class.java)
            startActivity(intent)
        }
    }
}
