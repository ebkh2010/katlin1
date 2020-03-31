package ir.ebkh.sana.activitis.estelam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.ebkh.sana.R
import kotlinx.android.synthetic.main.sabt_khodro.*
import kotlinx.android.synthetic.main.sabt_takhalof.*
import kotlinx.android.synthetic.main.sabt_takhalof2.*
import kotlinx.android.synthetic.main.sabt_takhalof3.*
import java.util.*

class ActivityEstelamKhodro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Locale.getDefault().getDisplayLanguage()== "English")
            setContentView(R.layout.estelam_khodro)
        else
            setContentView(R.layout.estelam_khodro_fa)





    }
}
