package ir.ebkh.sana.activitis.estelam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.ebkh.sana.R
import ir.ebkh.sana.activitis.sabt.ActivitySabteTakhalof
import kotlinx.android.synthetic.main.estelam.*

class ActivityEstelam : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.estelam)


        btn_estelam_fard.setOnClickListener {
            val intent = Intent(this, ActivityEstelamFard::class.java)
            startActivity(intent)
        }


        new_sana.setOnClickListener {
            val intent = Intent(this, ActivitySabteTakhalof::class.java)
            startActivity(intent)
        }
    }
}
