package ir.ebkh.sana.activitis.sabt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.ebkh.sana.R
import kotlinx.android.synthetic.main.sabt_takhalof.*

class ActivitySabteTakhalof : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sabt_takhalof)

        btn_takhalof2.setOnClickListener {
            val intent = Intent(this, ActivitySabteTakhalof2::class.java)
            startActivity(intent)
        }
    }
}
