package ir.ebkh.sana.activitis.sabt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.ebkh.sana.R
import ir.ebkh.sana.activitis.estelam.ActivityEstelam

class ActivitySabteFard2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sabt_fard2)
    }
    override fun onBackPressed() {

        val intent = Intent(this, ActivitySabteFard::class.java)
        startActivity(intent)
        finish()

    }
}
