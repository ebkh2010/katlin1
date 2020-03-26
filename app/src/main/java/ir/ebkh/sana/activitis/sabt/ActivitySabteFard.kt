package ir.ebkh.sana.activitis.sabt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.ebkh.sana.R
import ir.ebkh.sana.activitis.estelam.ActivityEstelamFard
import kotlinx.android.synthetic.main.sabt_fard.*

class ActivitySabteFard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sabt_fard)

        btn_estelam_fard.setOnClickListener {
            val intent = Intent(this, ActivitySabteFard2::class.java)
            startActivity(intent)
        }
    }
}
