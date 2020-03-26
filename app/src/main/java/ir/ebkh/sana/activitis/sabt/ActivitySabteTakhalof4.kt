package ir.ebkh.sana.activitis.sabt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ir.ebkh.sana.R
import kotlinx.android.synthetic.main.sabt_takhalof3.*
import kotlinx.android.synthetic.main.sabt_takhalof4.*
import java.util.*


class ActivitySabteTakhalof4 : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sabt_takhalof3)

        searchablespinner_add_car.setTitle("Select Item")
        searchablespinner_add_car.setPositiveButton("OK")

        searchablespinner_add_motor.setTitle("Select Item")
        searchablespinner_add_motor.setPositiveButton("OK")

    }
}
