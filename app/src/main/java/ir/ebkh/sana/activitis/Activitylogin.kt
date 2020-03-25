package ir.ebkh.sana.activitis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.ebkh.sana.R
import ir.ebkh.sana.activitis.estelam.ActivityEstelam
import kotlinx.android.synthetic.main.login.*

class Activitylogin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val btn = btn_login
        btn.setOnClickListener {
            val intent = Intent(this, ActivityEstelam::class.java)
            startActivity(intent)
        }
    }
}
