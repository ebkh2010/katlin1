package ir.ebkh.sana.activitis.sabt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.ebkh.sana.R
import ir.ebkh.sana.activitis.estelam.ActivityEstelam
import kotlinx.android.synthetic.main.sabt_khodro.*
import kotlinx.android.synthetic.main.sabt_takhalof.*
import kotlinx.android.synthetic.main.sabt_takhalof2.*
import kotlinx.android.synthetic.main.sabt_takhalof3.*
import java.util.*

class ActivitySabteKhodro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Locale.getDefault().getDisplayLanguage()== "English")
            setContentView(R.layout.sabt_khodro)
        else
            setContentView(R.layout.sabt_khodro_fa)


    }

    override fun onBackPressed() {

        val intent = Intent(this, ActivitySabteTakhalof::class.java)
        startActivity(intent)
        finish()

    }
}
