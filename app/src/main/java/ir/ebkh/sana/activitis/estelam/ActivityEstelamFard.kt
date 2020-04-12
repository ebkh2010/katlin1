package ir.ebkh.sana.activitis.estelam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.ebkh.sana.R

class ActivityEstelamFard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.estelam_fard)
    }

    override fun onBackPressed() {

        val intent = Intent(this, ActivityEstelam::class.java)
        startActivity(intent)
        finish()

    }
}
