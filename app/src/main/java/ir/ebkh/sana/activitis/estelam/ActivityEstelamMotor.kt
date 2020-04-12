package ir.ebkh.sana.activitis.estelam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.ebkh.sana.R
import java.util.*

class ActivityEstelamMotor : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Locale.getDefault().getDisplayLanguage()== "English")
            setContentView(R.layout.estelam_motor)
        else
            setContentView(R.layout.estelam_motor_fa)

    }

    override fun onBackPressed() {

        val intent = Intent(this, ActivityEstelamKhodro::class.java)
        startActivity(intent)
        finish()

    }
}
