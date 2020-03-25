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

        val btn_fard = estelam_fard
        btn_fard.setOnClickListener {
            val intent = Intent(this, ActivityEstelamFard::class.java)
            startActivity(intent)
        }

        val btn_newsana = new_sana
        btn_newsana.setOnClickListener {
            val intent = Intent(this, ActivitySabteTakhalof::class.java)
            startActivity(intent)
        }
    }
}
