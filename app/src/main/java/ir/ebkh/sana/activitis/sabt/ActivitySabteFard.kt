package ir.ebkh.sana.activitis.sabt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.get
import ir.ebkh.sana.R
import ir.ebkh.sana.activitis.estelam.ActivityEstelam
import ir.ebkh.sana.main.G
import kotlinx.android.synthetic.main.sabt_fard.*

class ActivitySabteFard : AppCompatActivity() {


    var kode_meli=""
    var name=""
    var lastname=""
    var fathername=""
    var gender=""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sabt_fard)


        btn_sabtefard.setOnClickListener {

//            var sqlq="INSERT INTO persons(kode_meli,first_name,last_name) " +
//                    "VALUES ('"+sabt_fard_kodmelli.text+"','"+sabt_fard_name.text+"','"+sabt_fard_famil.text+"')";
//            try {
//                G.database.execSQL(sqlq)
//            }catch (e: NumberFormatException) {
//                println("kodmelli") }

            kode_meli= sabt_fard_kodmelli.text.toString()
            name = sabt_fard_name.text.toString()
            lastname = sabt_fard_famil.text.toString()
            fathername = sabt_fard_father_name.text.toString()
            gender = spinner_sabt_gender.toString()

            val intent = Intent(this, ActivitySabteFard2::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onBackPressed() {

        val intent = Intent(this, ActivitySabteTakhalof::class.java)
        startActivity(intent)
        finish()

    }
}

//کد ملی یونیک است یعنی اگر طرف کد ملی تکراری زد نباید کلید بعدی عمل کند و به گونه ای نشان دهد که کد ملی تکراری است