package ir.ebkh.sana.activitis.sabt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.ebkh.sana.R
import kotlinx.android.synthetic.main.sabt_takhalof.*
import kotlinx.android.synthetic.main.sabt_takhalof2.*

class ActivitySabteTakhalof2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sabt_takhalof2)

        btn_sabtetakhalof3.setOnClickListener {
            val intent = Intent(this, ActivitySabteTakhalof3::class.java)
            startActivity(intent)
        }

    }
}
